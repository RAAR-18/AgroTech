package com.agrotech.service.impl;

import com.agrotech.Entity.*;
import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;
import com.agrotech.mapper.SiembraMapper;
import com.agrotech.repository.*;
import com.agrotech.service.SiembraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SiembraServiceImpl implements SiembraService {

    private final SiembraRepository siembraRepository;
    private final FincaRepository fincaRepository;
    private final CultivoRepository cultivoRepository;
    private final SiembraMapper siembraMapper;
    private final EstadoCultivoRepository estadoCultivoRepository;
    private final SiembraEstadoCultivoRepository siembraEstadoCultivoRepository;

    public SiembraServiceImpl(SiembraRepository siembraRepository, FincaRepository fincaRepository,
                              CultivoRepository cultivoRepository, SiembraMapper siembraMapper, EstadoCultivoRepository estadoCultivoRepository, SiembraEstadoCultivoRepository siembraEstadoCultivoRepository) {
        this.siembraRepository = siembraRepository;
        this.fincaRepository = fincaRepository;
        this.cultivoRepository = cultivoRepository;
        this.siembraMapper = siembraMapper;
        this.estadoCultivoRepository = estadoCultivoRepository;
        this.siembraEstadoCultivoRepository = siembraEstadoCultivoRepository;
    }

     @Override
    public SiembraResponseDTO crear(SiembraRequestDTO siembraRequestDTO) {
         Finca finca = fincaRepository.findById(siembraRequestDTO.getIdFinca())
                 .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + siembraRequestDTO.getIdFinca()));

         Cultivo cultivo = cultivoRepository.findById(siembraRequestDTO.getIdCultivo())
                 .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con ID: " + siembraRequestDTO.getIdCultivo()));

         EstadoCultivo estado = estadoCultivoRepository.findById(siembraRequestDTO.getIdEstadoCultivo())
                 .orElseThrow(() -> new RuntimeException("EstadoCultivo no encontrado con ID: " + siembraRequestDTO.getIdEstadoCultivo()));

         if (siembraRequestDTO.getNumLote() < 1 || siembraRequestDTO.getNumLote() > finca.getNumLotes()) {
                throw new RuntimeException("Número de lote inválido. Debe estar entre 1 y " + finca.getNumLotes());
         }

         Siembra siembra = new Siembra();

         siembra.setFinca(finca);
         siembra.setCultivo(cultivo);
         siembra.setNumLote(siembraRequestDTO.getNumLote());
         siembraRepository.save(siembra);

         SiembraEstadoCultivo estadoInicial = new SiembraEstadoCultivo(
                 siembra, estado, siembraRequestDTO.getFechaEstado()
         );
         siembraEstadoCultivoRepository.save(estadoInicial);

         SiembraResponseDTO response = siembraMapper.toResponse(siembra);
         response.setNombreEstado(estado.getNombre());
         return response;
     }

     // Listar todas las siembras
     @Override
    public List<SiembraResponseDTO> listar() {
        return siembraRepository.findAll().stream()
                .map(siembra -> {
                    SiembraResponseDTO response = siembraMapper.toResponse(siembra);
                    siembra.getEstadosCultivo().stream()
                            .findFirst()
                            .ifPresent(estado -> response.setNombreEstado(estado.getEstadoCultivo().getNombre()));
                    return response;
                })
                .toList();
     }

     // Buscar por finca
     @Override
    public java.util.List<SiembraResponseDTO> bucarPorFinca(Integer idFinca) {
        return siembraRepository.findByFinca_IdFinca(idFinca).stream()
                .map(siembra -> {
                    SiembraResponseDTO response = siembraMapper.toResponse(siembra);
                    siembra.getEstadosCultivo().stream()
                            .findFirst()
                            .ifPresent(estado -> response.setNombreEstado(estado.getEstadoCultivo().getNombre()));
                    return response;
                })
                .toList();
     }

     // Buscar por cultivo
    @Override
    public List<SiembraResponseDTO> bucarPorCultivo(Integer idCultivo) {
        return siembraRepository.findByCultivo_IdCultivo(idCultivo).stream()
                .map(siembra -> {
                    SiembraResponseDTO response = siembraMapper.toResponse(siembra);
                    siembra.getEstadosCultivo().stream()
                            .findFirst()
                            .ifPresent(estado -> response.setNombreEstado(estado.getEstadoCultivo().getNombre()));
                    return response;
                })
                .toList();
     }

     // Buscar por finca y cultivo
     @Override
     @Transactional(readOnly = true)
    public List<SiembraResponseDTO> buscarPorFincaYCultivo(Integer idFinca, Integer idCultivo) {
        return siembraRepository.findByFincaCultivoYUltimoEstado(idFinca, idCultivo).stream()
                .map(siembra -> {
                    SiembraResponseDTO response = siembraMapper.toResponse(siembra);
                    siembra.getEstadosCultivo().stream()
                            .findFirst()
                            .ifPresent(estado -> response.setNombreEstado(estado.getEstadoCultivo().getNombre()));
                    return response;
                })
                .toList();
        }



     // Buscar por número de lote
     @Override
     @Transactional(readOnly = true)
     public List<SiembraResponseDTO> buscarPorFincaYLote(Integer idFinca, Integer numLote) {
         return siembraRepository.findByFincaAndNumLoteConUltimoEstado(idFinca, numLote).stream()
                 .map(siembra -> {
                     SiembraResponseDTO response = siembraMapper.toResponse(siembra);
                     siembra.getEstadosCultivo().stream()
                             .findFirst()
                             .ifPresent(sec -> response.setNombreEstado(sec.getEstadoCultivo().getNombre()));
                     return response;
                 })
                 .toList();
     }

     // Eliminar siembra
     @Override
    public void eliminar(Integer idSiembra) {
        if (!siembraRepository.existsById(idSiembra)) {
            throw new RuntimeException("Siembra no encontrada con ID: " + idSiembra);
        }
        siembraRepository.deleteById(idSiembra);
     }
}
