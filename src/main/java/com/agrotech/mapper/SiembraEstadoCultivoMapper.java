package com.agrotech.mapper;

import com.agrotech.Entity.SiembraEstadoCultivo;
import com.agrotech.dto.response.SiembraEstadoCultivoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SiembraEstadoCultivoMapper {

    @Mapping(target = "idSiembra", expression = "java(siembraEstadoCultivo.getId().getIdSiembra())")
    @Mapping(target = "idEstadoCultivo", expression = "java(siembraEstadoCultivo.getId().getIdEstadoCultivo())")
    @Mapping(source = "estadoCultivo.nombre", target = "nombreEstado")
    @Mapping(source = "siembra.cultivo.nombre", target = "nombreCultivo")
    @Mapping(source = "siembra.finca.nombreFinca", target = "nombreFinca")
    @Mapping(source = "fechaEstado", target = "fechaEstado")
    SiembraEstadoCultivoResponse toResponse(SiembraEstadoCultivo siembraEstadoCultivo);

}
