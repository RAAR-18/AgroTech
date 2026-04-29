package com.agrotech.dto.response;

public class FincaResponse {

    private Integer idFinca;
    private String nombreFinca;
    private Double hectareas;
    private String nombreUbicacion;

    public FincaResponse() {}

    public FincaResponse(Integer idFinca, String nombreFinca, Double hectareas, String nombreUbicacion) {
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
        this.hectareas = hectareas;
        this.nombreUbicacion = nombreUbicacion;
    }

    public Integer getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public Double getHectareas() {
        return hectareas;
    }

    public void setHectareas(Double hectareas) {
        this.hectareas = hectareas;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    @Override
    public String toString() {
        return "FincaResponse{" +
                "idFinca=" + idFinca +
                ", nombreFinca='" + nombreFinca + '\'' +
                ", hectareas=" + hectareas +
                ", nombreUbicacion='" + nombreUbicacion + '\'' +
                '}';
    }
}
