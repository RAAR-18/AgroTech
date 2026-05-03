package com.agrotech.service;

import com.agrotech.dto.request.SiembraEstadoCultivoRequestDTO;
import com.agrotech.dto.response.SiembraEstadoCultivoResponseDTO;

import java.util.List;

public interface SiembraEstadoCultivoService {

    SiembraEstadoCultivoResponseDTO registrarEstadoCultivo(SiembraEstadoCultivoRequestDTO siembraEstadoCultivoRequestDTO);

    List<SiembraEstadoCultivoResponseDTO> listarPorSiembra(Integer idSiembra);

    SiembraEstadoCultivoResponseDTO obtenerEstadoCultivoActual(Integer idSiembra);

    List<SiembraEstadoCultivoResponseDTO> listarPorEstadoCultivo(Integer idEstadoCultivo);

    void eliminarEstadoCultivo(Integer idSiembra, Integer idEstadoCultivo);
}
