package com.agrotech.servicio;

import com.agrotech.dto.request.FincaRequest;
import com.agrotech.dto.response.FincaResponse;

import java.util.List;

public interface FincaServicio {

    // Consultar fincas del productor
    List<FincaResponse> listarPorProductor(Integer idProductor);

    // Buscar una finca específica
    FincaResponse buscarPorId(Integer id);

    // Crear finca
    FincaResponse crear(Integer idProductor, FincaRequest fincaRequest);

    // Editar finca
    FincaResponse actualizar(Integer idFinca, Integer idProductor, FincaRequest fincaRequest);

    // Eliminar finca
    void eliminar(Integer id);
}
