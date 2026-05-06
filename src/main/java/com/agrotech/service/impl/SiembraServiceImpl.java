package com.agrotech.service.impl;

import com.agrotech.Entity.*;
import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.request.SiembraUpdateRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;
import com.agrotech.mapper.SiembraMapper;
import com.agrotech.repository.*;
import com.agrotech.service.SiembraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
            response.setFechaEstado(siembraRequestDTO.getFechaEstado());
            response.setFechaSiembra(siembraRequestDTO.getFechaEstado());
            return response;
     }

     // Listar todas las siembras
     @Override
     @Transactional(readOnly = true)
     public List<SiembraResponseDTO> listar() {
         return siembraRepository.findAllConUltimoEstado().stream()
                 .map(this::buildResponse)
                 .toList();
     }

     // Buscar por finca
     @Override
     @Transactional(readOnly = true)
     public List<SiembraResponseDTO> bucarPorFinca(Integer idFinca) {
         return siembraRepository.findByFincaConUltimoEstado(idFinca).stream()
                 .map(this::buildResponse)
                 .toList();
     }

     // Buscar por cultivo
    @Override
    @Transactional(readOnly = true)
    public List<SiembraResponseDTO> bucarPorCultivo(Integer idCultivo) {
        return siembraRepository.findByCultivoConUltimoEstado(idCultivo).stream()
                .map(this::buildResponse)
                .toList();
    }

     // Buscar por finca y cultivo
     @Override
     @Transactional(readOnly = true)
     public List<SiembraResponseDTO> buscarPorFincaYCultivo(Integer idFinca, Integer idCultivo) {
         return siembraRepository.findByFincaCultivoYUltimoEstado(idFinca, idCultivo).stream()
                 .map(this::buildResponse)
                 .toList();
     }

     // Buscar por número de lote
     @Override
     @Transactional(readOnly = true)
     public List<SiembraResponseDTO> buscarPorFincaYLote(Integer idFinca, Integer numLote) {
         return siembraRepository.findByFincaAndNumLoteConUltimoEstado(idFinca, numLote).stream()
                 .map(this::buildResponse)
                 .toList();
     }

    @Override
    @Transactional(readOnly = true)
    public List<SiembraResponseDTO> buscarPorEstado(Integer idEstado) {
        return siembraRepository.findByEstadoCultivoConUltimoEstado(idEstado).stream()
                .map(this::buildResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiembraResponseDTO> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta) {
        return siembraRepository.findByRangoFechaConUltimoEstado(desde, hasta).stream()
                .map(this::buildResponse)
                .toList();
    }

    @Override
    public SiembraResponseDTO actualizar(Integer idSiembra, SiembraUpdateRequestDTO dto) {
        Siembra siembra = siembraRepository.findById(idSiembra)
                .orElseThrow(() -> new RuntimeException("Siembra no encontrada con ID: " + idSiembra));

        if (dto.getNumLote() != null) {
            Finca finca = dto.getIdFinca() != null
                    ? fincaRepository.findById(dto.getIdFinca())
                    .orElseThrow(() -> new RuntimeException("Finca no encontrada"))
                    : siembra.getFinca();

            if (dto.getNumLote() < 1 || dto.getNumLote() > finca.getNumLotes()) {
                throw new RuntimeException("Número de lote inválido. Debe estar entre 1 y " + finca.getNumLotes());
            }
            siembra.setNumLote(dto.getNumLote());
            siembra.setFinca(finca);
        }

        if (dto.getIdCultivo() != null) {
            Cultivo cultivo = cultivoRepository.findById(dto.getIdCultivo())
                    .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));
            siembra.setCultivo(cultivo);
        }

        siembraRepository.save(siembra);

        return buildResponse(siembra);
    }

     // Eliminar siembra
     @Override
    public void eliminar(Integer idSiembra) {
        if (!siembraRepository.existsById(idSiembra)) {
            throw new RuntimeException("Siembra no encontrada con ID: " + idSiembra);
        }
        siembraRepository.deleteById(idSiembra);
     }

    private SiembraResponseDTO buildResponse(Siembra siembra) {
        SiembraResponseDTO response = siembraMapper.toResponse(siembra);

        // Estado actual y su fecha
        if (siembra.getEstadosCultivo() != null && !siembra.getEstadosCultivo().isEmpty()) {
            siembra.getEstadosCultivo().stream()
                    .findFirst()
                    .ifPresent(sec -> {
                        response.setNombreEstado(sec.getEstadoCultivo().getNombre());
                        response.setFechaEstado(sec.getFechaEstado());
                    });
        }

        // Fecha de siembra (primer estado registrado)
        siembraEstadoCultivoRepository.findPrimerEstado(siembra.getIdSiembra())
                .stream()
                .findFirst()
                .ifPresent(sec -> response.setFechaSiembra(sec.getFechaEstado()));

        return response;
    }
}
