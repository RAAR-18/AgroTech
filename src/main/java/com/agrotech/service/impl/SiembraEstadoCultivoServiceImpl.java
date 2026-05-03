package com.agrotech.service.impl;

import com.agrotech.Entity.EstadoCultivo;
import com.agrotech.Entity.Siembra;
import com.agrotech.Entity.SiembraEstadoCultivo;
import com.agrotech.Entity.SiembraEstadoCultivoId;
import com.agrotech.dto.request.SiembraEstadoCultivoRequestDTO;
import com.agrotech.dto.response.SiembraEstadoCultivoResponseDTO;
import com.agrotech.mapper.SiembraEstadoCultivoMapper;
import com.agrotech.repository.EstadoCultivoRepository;
import com.agrotech.repository.SiembraEstadoCultivoRepository;
import com.agrotech.repository.SiembraRepository;
import com.agrotech.service.SiembraEstadoCultivoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SiembraEstadoCultivoServiceImpl implements SiembraEstadoCultivoService {

    private final SiembraEstadoCultivoRepository siembraEstadoCultivoRepository;
    private final SiembraRepository siembraRepository;
    private final EstadoCultivoRepository estadoCultivoRepository;
    private final SiembraEstadoCultivoMapper siembraEstadoCultivoMapper;

    public SiembraEstadoCultivoServiceImpl(SiembraEstadoCultivoRepository siembraEstadoCultivoRepository,
                                           SiembraRepository siembraRepository,
                                           EstadoCultivoRepository estadoCultivoRepository,
                                           SiembraEstadoCultivoMapper siembraEstadoCultivoMapper) {
        this.siembraEstadoCultivoRepository = siembraEstadoCultivoRepository;
        this.siembraRepository = siembraRepository;
        this.estadoCultivoRepository = estadoCultivoRepository;
        this.siembraEstadoCultivoMapper = siembraEstadoCultivoMapper;
    }

    @Override
    public SiembraEstadoCultivoResponseDTO registrarEstadoCultivo(SiembraEstadoCultivoRequestDTO siembraEstadoCultivoRequestDTO) {
        Siembra siembra = siembraRepository.findById(siembraEstadoCultivoRequestDTO.getIdSiembra())
                .orElseThrow(() -> new RuntimeException("Siembra no encontrada"));

        EstadoCultivo estadoCultivo = estadoCultivoRepository.findById(siembraEstadoCultivoRequestDTO.getIdEstadoCultivo())
                .orElseThrow(() -> new RuntimeException("Estado de cultivo no encontrado"));

        SiembraEstadoCultivoId id = new SiembraEstadoCultivoId(siembra.getIdSiembra(), estadoCultivo.getIdEstadoCultivo());

        if (siembraEstadoCultivoRepository.existsById(id)) {
            throw new RuntimeException("El estado de cultivo ya está registrado para esta siembra");
        }

        SiembraEstadoCultivo siembraEstadoCultivo = new SiembraEstadoCultivo(siembra, estadoCultivo, LocalDateTime.now());

        SiembraEstadoCultivo guardado = siembraEstadoCultivoRepository.save(siembraEstadoCultivo);
        return siembraEstadoCultivoMapper.toResponse(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiembraEstadoCultivoResponseDTO> listarPorSiembra(Integer idSiembra) {
        return siembraEstadoCultivoRepository.findById_IdSiembra(idSiembra)
                .stream()
                .map(siembraEstadoCultivoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SiembraEstadoCultivoResponseDTO obtenerEstadoCultivoActual(Integer idSiembra) {
        List<SiembraEstadoCultivo> estados = siembraEstadoCultivoRepository.findUltimoEstado(idSiembra);

        if (estados.isEmpty()) {
            throw new RuntimeException("No se encontraron estados para esta siembra");
        }

        return siembraEstadoCultivoMapper.toResponse(estados.get(0));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiembraEstadoCultivoResponseDTO> listarPorEstadoCultivo(Integer idEstadoCultivo) {
        return siembraEstadoCultivoRepository.findById_IdEstadoCultivo(idEstadoCultivo)
                .stream()
                .map(siembraEstadoCultivoMapper::toResponse)
                .toList();
    }

    @Override
    public void eliminarEstadoCultivo(Integer idSiembra, Integer idEstadoCultivo) {
        SiembraEstadoCultivoId id = new SiembraEstadoCultivoId(idSiembra, idEstadoCultivo);

        if (!siembraEstadoCultivoRepository.existsById(id)) {
            throw new RuntimeException("El estado de cultivo no existe para esta siembra");
        }

        siembraEstadoCultivoRepository.deleteById(id);
    }
}
