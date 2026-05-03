package com.agrotech.service.impl;

import com.agrotech.Entity.Finca;
import com.agrotech.Entity.Productor;
import com.agrotech.Entity.Ubicacion;
import com.agrotech.dto.request.FincaRequestDTO;
import com.agrotech.dto.request.FincaUpdateRequestDTO;
import com.agrotech.dto.response.FincaResponseDTO;
import com.agrotech.mapper.FincaMapper;
import com.agrotech.repository.FincaRepository;
import com.agrotech.repository.ProductorRepository;
import com.agrotech.repository.UbicacionRepository;
import com.agrotech.service.FincaServIce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FincaServIceImpl implements FincaServIce {

    private final FincaRepository fincaRepository;
    private final ProductorRepository productorRepository;
    private final UbicacionRepository ubicacionRepository;
    private final FincaMapper fincaMapper;

    public FincaServIceImpl(FincaRepository fincaRepository, ProductorRepository productorRepository, UbicacionRepository ubicacionRepository, FincaMapper fincaMapper) {
        this.fincaRepository = fincaRepository;
        this.productorRepository = productorRepository;
        this.ubicacionRepository = ubicacionRepository;
        this.fincaMapper = fincaMapper;
    }

    // Listar por productor
    @Override
    public List<FincaResponseDTO> listarPorProductor(Integer idProductor) {
        List<Finca> fincas = fincaRepository.findByProductor_IdUsuario(idProductor);
        return fincas.stream()
                .map(fincaMapper::toResponse)
                .toList();
    }

    // Listar fincas por id
    @Override
    public FincaResponseDTO buscarPorId(Integer idFinca) {
        Finca finca = fincaRepository.findById(idFinca)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + idFinca));
        return fincaMapper.toResponse(finca);
    }

    // Crear finca
    @Override
    public FincaResponseDTO crear(Integer idProductor, FincaRequestDTO fincaRequestDTO) {

        // Buscar productor
        Productor productor = productorRepository.findById(idProductor)
                .orElseThrow(() -> new RuntimeException("Productor no encontrada con ID: " + idProductor));

        // Buscar ubicación
        Ubicacion ubicacion = ubicacionRepository.findById(fincaRequestDTO.getIdUbicacion())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con ID: " + fincaRequestDTO.getIdUbicacion()));

        boolean existeFinca = fincaRepository.existsByNombreFincaAndProductor_IdUsuario(fincaRequestDTO.getNombreFinca(), idProductor);

        if (existeFinca) {
            throw new RuntimeException("Ya existe una finca con el mismo nombre para este productor");
        }

        // convertir FincaRequest a Finca
        Finca finca = fincaMapper.toEntity(fincaRequestDTO);

        finca.setProductor(productor);
        finca.setUbicacion(ubicacion);

        // Guardar finca
        finca = fincaRepository.save(finca);

        // Convertir a FincaResponse
        return fincaMapper.toResponse(finca);
    }

    // Actualizar finca
    @Override
    public FincaResponseDTO actualizar(Integer idFinca, Integer idProductor, FincaUpdateRequestDTO fincaUpdateRequestDTO) {
        // Buscar finca
        Finca finca = fincaRepository.findById(idFinca)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + idFinca));

        if (fincaUpdateRequestDTO.getNombreFinca() != null && !fincaUpdateRequestDTO.getNombreFinca().equalsIgnoreCase(finca.getNombreFinca())) {
            boolean existeFinca = fincaRepository.existsByNombreFincaAndProductor_IdUsuario(fincaUpdateRequestDTO.getNombreFinca(), idProductor);

            if (existeFinca) {
                throw new RuntimeException("Ya existe una finca con el mismo nombre para este productor");
            }
        }

        fincaMapper.updateEntityFromRequest(fincaUpdateRequestDTO, finca);
        fincaMapper.updateHectareas(fincaUpdateRequestDTO, finca);

        Finca fincaActualizada = fincaRepository.save(finca);

        return fincaMapper.toResponse(fincaActualizada);
    }

    @Override
    public void eliminar(Integer idFinca) {
        Finca finca = fincaRepository.findById(idFinca)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + idFinca));
        fincaRepository.delete(finca);
    }
}
