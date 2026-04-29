package com.agrotech.dto.request;

import jakarta.validation.constraints.NotNull;

public class SiembraRequest {

    private Integer idFinca;
    private Integer idCultivo;

    public SiembraRequest() {}

    public SiembraRequest(Integer idFinca, Integer idCultivo) {
        this.idFinca = idFinca;
        this.idCultivo = idCultivo;
    }

    public Integer getIdFinca() { return idFinca; }

    public void setIdFinca(Integer idFinca) { this.idFinca = idFinca; }

    public Integer getIdCultivo() { return idCultivo; }

    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

     @Override
    public String toString() {
        return "SiembraRequest{idFinca=" + idFinca + ", idCultivo=" + idCultivo + "}";
    }

}
