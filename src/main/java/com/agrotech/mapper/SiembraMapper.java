package com.agrotech.mapper;

import com.agrotech.Entity.Siembra;
import com.agrotech.dto.response.SiembraResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SiembraMapper {

    @Mapping(source = "idSiembra", target = "idSiembra")
    @Mapping(source = "cultivo.nombre", target = "nombreCultivo")
    @Mapping(source = "finca.nombreFinca", target = "nombreFinca")
    SiembraResponse toResponse(Siembra siembra);
}
