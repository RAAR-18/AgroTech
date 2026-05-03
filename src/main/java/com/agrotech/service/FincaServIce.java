package com.agrotech.service;

import com.agrotech.dto.request.FincaRequestDTO;
import com.agrotech.dto.request.FincaUpdateRequestDTO;
import com.agrotech.dto.response.FincaResponseDTO;

import java.util.List;

public interface FincaServIce {

    // Consultar fincas del productor
    List<FincaResponseDTO> listarPorProductor(Integer idProductor);

    // Buscar una finca específica
    FincaResponseDTO buscarPorId(Integer id);

    // Crear finca
    FincaResponseDTO crear(Integer idProductor, FincaRequestDTO fincaRequestDTO);

    // Editar finca
    FincaResponseDTO actualizar(Integer idFinca, Integer idProductor, FincaUpdateRequestDTO fincaUpdateRequestDTO);

    // Eliminar finca
    void eliminar(Integer id);
}
