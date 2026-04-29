package com.agrotech.servicio.impl;

import com.agrotech.Entity.Finca;
import com.agrotech.Entity.Productor;
import com.agrotech.Entity.Ubicacion;
import com.agrotech.dto.request.FincaRequest;
import com.agrotech.dto.request.FincaUpdateRequest;
import com.agrotech.dto.response.FincaResponse;
import com.agrotech.mapper.FincaMapper;
import com.agrotech.repository.FincaRepository;
import com.agrotech.repository.ProductorRepository;
import com.agrotech.repository.UbicacionRepository;
import com.agrotech.servicio.FincaServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FincaServicioImpl implements FincaServicio {

    private final FincaRepository fincaRepository;
    private final ProductorRepository productorRepository;
    private final UbicacionRepository ubicacionRepository;
    private final FincaMapper fincaMapper;

    public FincaServicioImpl(FincaRepository fincaRepository, ProductorRepository productorRepository, UbicacionRepository ubicacionRepository, FincaMapper fincaMapper) {
        this.fincaRepository = fincaRepository;
        this.productorRepository = productorRepository;
        this.ubicacionRepository = ubicacionRepository;
        this.fincaMapper = fincaMapper;
    }

    // Listar por productor
    @Override
    public List<FincaResponse> listarPorProductor(Integer idProductor) {
        List<Finca> fincas = fincaRepository.findByProductor_IdUsuario(idProductor);
        return fincas.stream()
                .map(fincaMapper::toResponse)
                .toList();
    }

    // Listar fincas por id
    @Override
    public FincaResponse buscarPorId(Integer idFinca) {
        Finca finca = fincaRepository.findById(idFinca)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + idFinca));
        return fincaMapper.toResponse(finca);
    }

    // Crear finca
    @Override
    public FincaResponse crear(Integer idProductor, FincaRequest fincaRequest) {

        // Buscar productor
        Productor productor = productorRepository.findById(idProductor)
                .orElseThrow(() -> new RuntimeException("Productor no encontrada con ID: " + idProductor));

        // Buscar ubicación
        Ubicacion ubicacion = ubicacionRepository.findById(fincaRequest.getIdUbicacion())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con ID: " + fincaRequest.getIdUbicacion()));

        // convertir FincaRequest a Finca
        Finca finca = fincaMapper.toEntity(fincaRequest);

        finca.setProductor(productor);
        finca.setUbicacion(ubicacion);

        // Guardar finca
        finca = fincaRepository.save(finca);

        // Convertir a FincaResponse
        return fincaMapper.toResponse(finca);
    }

    // Actualizar finca
    @Override
    public FincaResponse actualizar(Integer idFinca, Integer idProductor, FincaUpdateRequest fincaUpdateRequest) {
        // Buscar finca
        Finca finca = fincaRepository.findById(idFinca)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + idFinca));

        fincaMapper.updateEntityFromRequest(fincaUpdateRequest, finca);

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
