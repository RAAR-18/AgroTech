package com.agrotech.servicio;

import com.agrotech.dto.request.SiembraEstadoCultivoRequest;
import com.agrotech.dto.response.SiembraEstadoCultivoResponse;

import java.util.List;

public interface SiembraEstadoCultivoServicio {

    SiembraEstadoCultivoResponse registrarEstadoCultivo(SiembraEstadoCultivoRequest siembraEstadoCultivoRequest);

    List<SiembraEstadoCultivoResponse> listarPorSiembra(Integer idSiembra);

    SiembraEstadoCultivoResponse obtenerEstadoCultivoActual(Integer idSiembra);

    List<SiembraEstadoCultivoResponse> listarPorEstadoCultivo(Integer idEstadoCultivo);

    void eliminarEstadoCultivo(Integer idSiembra, Integer idEstadoCultivo);
}
