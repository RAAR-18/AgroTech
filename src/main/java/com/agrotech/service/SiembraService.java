package com.agrotech.service;

import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.request.SiembraUpdateRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface SiembraService {

    public SiembraResponseDTO crear(SiembraRequestDTO siembraRequestDTO);

    List<SiembraResponseDTO> listar();

    List<SiembraResponseDTO> bucarPorFinca(Integer idFinca);

    List<SiembraResponseDTO> bucarPorCultivo(Integer idCultivo);

    List<SiembraResponseDTO> buscarPorFincaYCultivo(Integer idFinca, Integer idCultivo);

    List<SiembraResponseDTO> buscarPorFincaYLote(Integer idFinca, Integer numLote);

    List<SiembraResponseDTO> buscarPorEstado(Integer idEstado);

    List<SiembraResponseDTO> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta);

    SiembraResponseDTO actualizar(Integer idSiembra, SiembraUpdateRequestDTO siembraUpdateRequestDTO);

    void eliminar(Integer idSiembra);
}
