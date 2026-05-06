package com.agrotech.service;

import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;

import java.util.List;

public interface SiembraService {

    public SiembraResponseDTO crear(SiembraRequestDTO siembraRequestDTO);

    List<SiembraResponseDTO> listar();

    List<SiembraResponseDTO> bucarPorFinca(Integer idFinca);

    List<SiembraResponseDTO> bucarPorCultivo(Integer idCultivo);

    List<SiembraResponseDTO> buscarPorFincaYCultivo(Integer idFinca, Integer idCultivo);

    void eliminar(Integer idSiembra);
}
