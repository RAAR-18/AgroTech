package com.agrotech.servicio.impl;

import com.agrotech.Entity.Cultivo;
import com.agrotech.Entity.TipoCultivo;
import com.agrotech.dto.request.CultivoRequest;
import com.agrotech.dto.response.CultivoResponse;
import com.agrotech.mapper.CultivoMapper;
import com.agrotech.repository.CultivoRepository;
import com.agrotech.repository.TipoCultivoRepository;
import com.agrotech.servicio.CultivoServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CultivoServicioImpl implements CultivoServicio {

    private final CultivoRepository cultivoRepository;
    private final TipoCultivoRepository tipoCultivoRepository;
    private final CultivoMapper cultivoMapper;

    public CultivoServicioImpl(CultivoRepository cultivoRepository, TipoCultivoRepository tipoCultivoRepository, CultivoMapper cultivoMapper) {
        this.cultivoRepository = cultivoRepository;
        this.tipoCultivoRepository = tipoCultivoRepository;
        this.cultivoMapper = cultivoMapper;
    }

    @Override
    public CultivoResponse crear(CultivoRequest cultivoRequest) {
        TipoCultivo tipo = tipoCultivoRepository.findById(cultivoRequest.getIdTipoCultivo())
                .orElseThrow(() -> new RuntimeException("TipoCultivo no encontrado con id: " + cultivoRequest.getIdTipoCultivo()));

        Cultivo cultivo = new Cultivo();
        cultivo.setNombre(cultivoRequest.getNombre());
        cultivo.setTipoCultivo(tipo);

        return cultivoMapper.toResponse(cultivoRepository.save(cultivo));
    }

    @Override
    public CultivoResponse buscarPorId(Integer id) {
        Cultivo cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con id: " + id));
        return cultivoMapper.toResponse(cultivo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CultivoResponse> buscarPorNombre(String nombre) {
        return cultivoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(cultivoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CultivoResponse> buscarPorTipo(Integer idTipoCultivo) {
        return cultivoRepository.findByTipoCultivo_IdTiposCultivos(idTipoCultivo)
                .stream()
                .map(cultivoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CultivoResponse> listarTodos() {
        return cultivoRepository.findAll()
                .stream()
                .map(cultivoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CultivoResponse> filtrarPorNombreTipo(String nombreTipo) {
        return cultivoRepository.findByTipoCultivo_NombreContainingIgnoreCase(nombreTipo)
                .stream()
                .map(cultivoMapper::toResponse)
                .toList();
    }

    @Override
    public CultivoResponse actualizar(Integer id, CultivoRequest cultivoRequest) {
        Cultivo cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con id: " + id));

        TipoCultivo tipo = tipoCultivoRepository.findById(cultivoRequest.getIdTipoCultivo())
                .orElseThrow(() -> new RuntimeException("TipoCultivo no encontrado con id: " + cultivoRequest.getIdTipoCultivo()));

        cultivo.setNombre(cultivoRequest.getNombre());
        cultivo.setTipoCultivo(tipo);

        return cultivoMapper.toResponse(cultivoRepository.save(cultivo));
    }

    @Override
    public void eliminar(Integer id) {
        if (!cultivoRepository.existsById(id)) {
            throw new RuntimeException("Cultivo no encontrado con id: " + id);
        }
        cultivoRepository.deleteById(id);
    }
}
