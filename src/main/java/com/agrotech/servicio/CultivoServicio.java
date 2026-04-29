package com.agrotech.servicio;

import com.agrotech.dto.request.CultivoRequest;
import com.agrotech.dto.response.CultivoResponse;

import java.util.List;

public interface CultivoServicio {

    CultivoResponse crear(CultivoRequest cultivoRequest);
    CultivoResponse buscarPorId(Integer id);
    List<CultivoResponse> buscarPorNombre(String nombre);
    List<CultivoResponse>buscarPorTipo(Integer idTipoCultivo);
    List<CultivoResponse> listarTodos();
    List<CultivoResponse> filtrarPorNombreTipo(String nombreTipo);
    CultivoResponse actualizar(Integer id, CultivoRequest cultivoRequest);
    void eliminar(Integer id);
}
