package com.agrotech.dto.request;

import jakarta.validation.constraints.NotNull;

public class SiembraEstadoCultivoRequestDTO {

    @NotNull(message = "El ID de la siembra es obligatorio")
    private Integer idSiembra;

    @NotNull(message = "El ID del estado de cultivo es obligatorio")
    private Integer idEstadoCultivo;

    public SiembraEstadoCultivoRequestDTO() {}

    public SiembraEstadoCultivoRequestDTO(Integer idSiembra, Integer idEstadoCultivo) {
        this.idSiembra = idSiembra;
        this.idEstadoCultivo = idEstadoCultivo;
    }

    public Integer getIdSiembra() { return idSiembra; }
    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra;}

    public Integer getIdEstadoCultivo() { return idEstadoCultivo; }
    public void setIdEstadoCultivo(Integer idEstadoCultivo) { this.idEstadoCultivo = idEstadoCultivo; }

    @Override
    public String toString() {
        return "SiembraEstadoCultivoRequest{idSiembra=" + idSiembra +
                ", idEstadoCultivo=" + idEstadoCultivo + "}";
        }
}
