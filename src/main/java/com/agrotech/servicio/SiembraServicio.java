package com.agrotech.servicio;

import com.agrotech.dto.request.SiembraRequest;
import com.agrotech.dto.response.SiembraResponse;

import java.util.List;

public interface SiembraServicio {

    public SiembraResponse crear(SiembraRequest siembraRequest);

    List<SiembraResponse> listar();

    List<SiembraResponse> bucarPorFinca(Integer idFinca);

    List<SiembraResponse> bucarPorCultivo(Integer idCultivo);

    void eliminar(Integer idSiembra);
}
