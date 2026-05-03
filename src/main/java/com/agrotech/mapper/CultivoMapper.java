package com.agrotech.mapper;

import com.agrotech.Entity.Cultivo;
import com.agrotech.dto.request.CultivoRequestDTO;
import com.agrotech.dto.response.CultivoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CultivoMapper {

    @Mapping(source = "tipoCultivo.nombre", target = "nombreTipoCultivo")
    CultivoResponseDTO toResponse(Cultivo cultivo);

    @Mapping(target = "idCultivo", ignore = true)
    @Mapping(target = "tipoCultivo", ignore = true)
    @Mapping(target = "siembras", ignore = true)
    void UpdateCultivoFromRequest(CultivoRequestDTO request, @MappingTarget Cultivo cultivo);
}
