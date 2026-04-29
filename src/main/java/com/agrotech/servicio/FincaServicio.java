package com.agrotech.servicio;

import com.agrotech.Entity.Finca;
import com.agrotech.dto.request.FincaRequest;

import java.util.List;

public interface FincaServicio {

    // Consultar fincas del productor
    List<Finca> listarPorProductor(Integer idProductor);

    // Buscar una finca específica
    Finca buscarPorId(Integer id);

    // Crear finca
    Finca crear(Integer idProductor, FincaRequest fincaRequest);

    // Editar finca
    Finca actualizar(Integer idFinca, Integer idProductor, FincaRequest fincaRequest);

    // Eliminar finca
    void eliminar(Integer id);
}
