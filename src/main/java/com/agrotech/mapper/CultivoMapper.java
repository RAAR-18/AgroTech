package com.agrotech.mapper;

import com.agrotech.Entity.Cultivo;
import com.agrotech.dto.request.CultivoRequest;
import com.agrotech.dto.response.CultivoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CultivoMapper {

    @Mapping(source = "tipoCultivo.nombre", target = "nombreTipoCultivo")
    CultivoResponse toResponse(Cultivo cultivo);

    @Mapping(target = "idCultivo", ignore = true)
    @Mapping(target = "tipoCultivo", ignore = true)
    @Mapping(target = "siembras", ignore = true)
    void UpdateCultivoFromRequest(CultivoRequest request, @MappingTarget Cultivo cultivo);
}
