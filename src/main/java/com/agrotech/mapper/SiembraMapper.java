package com.agrotech.mapper;

import com.agrotech.Entity.Siembra;
import com.agrotech.dto.response.SiembraResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SiembraMapper {

    @Mapping(source = "idSiembra", target = "idSiembra")
    @Mapping(source = "cultivo.nombre", target = "nombreCultivo")
    @Mapping(source = "finca.nombreFinca", target = "nombreFinca")
    @Mapping(source = "numLote", target = "numLote")
    @Mapping(target = "nombreEstado", ignore = true) // Se ignora porque se setea manualmente en el servicio
    SiembraResponseDTO toResponse(Siembra siembra);
}
