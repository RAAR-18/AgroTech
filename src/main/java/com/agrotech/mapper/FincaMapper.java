package com.agrotech.mapper;

import com.agrotech.Entity.Finca;
import com.agrotech.dto.request.FincaRequest;
import com.agrotech.dto.request.FincaUpdateRequest;
import com.agrotech.dto.response.FincaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface FincaMapper {

    // FincaRequest -> Finca
    @Mapping(target = "idFinca", ignore = true) // Ignorar el ID al crear
    @Mapping(target = "productor", ignore = true) // Ignorar el productor, se asignará en el servicio
    @Mapping(target = "ubicacion", ignore = true)
    @Mapping(target = "siembras", ignore = true) // Ignorar las siembras, se gestionarán por separado
    @Mapping(target = "hectareas", expression = "java(toBigDecimal(fincaRequest.getHectareas()))") // Convertir String a BigDecimal
    Finca toEntity(FincaRequest fincaRequest);

    // Finca -> FincaResponse
    @Mapping(source = "ubicacion.nombre", target = "nombreUbicacion") // Mapear el nombre de la ubicación
    @Mapping(target = "hectareas", expression = "java(toDouble(finca.getHectareas()))") // Convertir BigDecimal a String
    FincaResponse toResponse(Finca finca);

    @Mapping(target = "idFinca", ignore = true) // Ignorar el ID al actualizar
    @Mapping(target = "productor", ignore = true) // Ignorar el productor,
    @Mapping(target = "ubicacion", ignore = true)
    @Mapping(target = "siembras", ignore = true)
    @Mapping(target = "hectareas", expression = "java(toBigDecimal(fincaUpdateRequest.getHectareas()))") // Convertir String a BigDecimal
    void updateEntityFromRequest(FincaUpdateRequest fincaUpdateRequest, @MappingTarget Finca finca);


    // Conversión Double -> BigDecimal
    default BigDecimal toBigDecimal(Double value) {
        return value != null ? BigDecimal.valueOf(value) : null;
    }

    // Conversión BigDecimal -> Double
    default Double toDouble(BigDecimal value) {
        return value != null ? value.doubleValue() : null;
    }
}
