package com.agrotech.dto.response;

public class FincaResponseDTO {

    private Integer idFinca;
    private String nombreFinca;
    private Double hectareas;
    private String nombreUbicacion;
    private Integer numLotes;

    public FincaResponseDTO() {}

    public FincaResponseDTO(Integer idFinca, String nombreFinca, Double hectareas, String nombreUbicacion, Integer numLotes) {
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
        this.hectareas = hectareas;
        this.nombreUbicacion = nombreUbicacion;
        this.numLotes = numLotes;
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

    public Integer getNumLotes() {
        return numLotes;
    }

    public void setNumLotes(Integer numLotes) {
        this.numLotes = numLotes;
    }

    @Override
    public String toString() {
        return "FincaResponse{" +
                "idFinca=" + idFinca +
                ", nombreFinca='" + nombreFinca + '\'' +
                ", hectareas=" + hectareas +
                ", nombreUbicacion='" + nombreUbicacion + '\'' +
                "numLotes=" + numLotes + '}';
    }
}
