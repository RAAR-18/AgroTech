package com.agrotech.servicio.impl;

import com.agrotech.Entity.Cultivo;
import com.agrotech.Entity.Finca;
import com.agrotech.Entity.Siembra;
import com.agrotech.dto.request.SiembraRequest;
import com.agrotech.dto.response.SiembraResponse;
import com.agrotech.mapper.SiembraMapper;
import com.agrotech.repository.CultivoRepository;
import com.agrotech.repository.FincaRepository;
import com.agrotech.repository.SiembraRepository;
import com.agrotech.servicio.SiembraServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiembraServicioImpl implements SiembraServicio {

    private final SiembraRepository siembraRepository;
    private final FincaRepository fincaRepository;
    private final CultivoRepository cultivoRepository;
    private final SiembraMapper siembraMapper;

    public SiembraServicioImpl(SiembraRepository siembraRepository, FincaRepository fincaRepository,
                               CultivoRepository cultivoRepository, SiembraMapper siembraMapper) {
        this.siembraRepository = siembraRepository;
        this.fincaRepository = fincaRepository;
        this.cultivoRepository = cultivoRepository;
        this.siembraMapper = siembraMapper;
    }

     @Override
    public SiembraResponse crear(SiembraRequest siembraRequest) {
         Finca finca = fincaRepository.findById(siembraRequest.getIdFinca())
                 .orElseThrow(() -> new RuntimeException("Finca no encontrada con ID: " + siembraRequest.getIdFinca()));

         Cultivo cultivo = cultivoRepository.findById(siembraRequest.getIdCultivo())
                 .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con ID: " + siembraRequest.getIdCultivo()));

         Siembra siembra = new Siembra();

         siembra.setFinca(finca);
         siembra.setCultivo(cultivo);

         siembraRepository.save(siembra);

         return siembraMapper.toResponse(siembra);
     }

     // Listar todas las siembras
     @Override
    public java.util.List<SiembraResponse> listar() {
        return siembraRepository.findAll().stream()
                .map(siembraMapper::toResponse)
                .toList();
     }

     // Buscar por finca
     @Override
    public java.util.List<SiembraResponse> bucarPorFinca(Integer idFinca) {
        return siembraRepository.findByFinca_IdFinca(idFinca).stream()
                .map(siembraMapper::toResponse)
                .toList();
     }

        // Buscar por cultivo
    @Override
    public List<SiembraResponse> bucarPorCultivo(Integer idCultivo) {
        return siembraRepository.findByCultivo_IdCultivo(idCultivo).stream()
                .map(siembraMapper::toResponse)
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
