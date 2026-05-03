package com.agrotech.service;

import com.agrotech.dto.request.CultivoRequestDTO;
import com.agrotech.dto.response.CultivoResponseDTO;

import java.util.List;

public interface CultivoService {

    CultivoResponseDTO crear(CultivoRequestDTO cultivoRequestDTO);
    CultivoResponseDTO buscarPorId(Integer id);
    List<CultivoResponseDTO> buscarPorNombre(String nombre);
    List<CultivoResponseDTO>buscarPorTipo(Integer idTipoCultivo);
    List<CultivoResponseDTO> listarTodos();
    List<CultivoResponseDTO> filtrarPorNombreTipo(String nombreTipo);
    CultivoResponseDTO actualizar(Integer id, CultivoRequestDTO cultivoRequestDTO);
    void eliminar(Integer id);
}
