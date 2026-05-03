package com.agrotech.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FincaRequestDTO {

    @NotBlank(message = "El nombre de la finca es obligatorio")
    private String nombreFinca;

    @Positive(message = "Las hectáreas deben ser un número positivo")
    private Double hectareas;

    @NotNull(message = "La ubicación es obligatoria")
    private Integer idUbicacion;

    @NotNull(message = "El número de lotes es obligatorio")
    private Integer numLotes;

    public FincaRequestDTO() {}

    public FincaRequestDTO(String nombreFinca, Double hectareas, Integer idUbicacion, Integer numLotes) {
        this.nombreFinca = nombreFinca;
        this.hectareas = hectareas;
        this.idUbicacion = idUbicacion;
        this.numLotes = numLotes;
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

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Integer getNumLotes() {
        return numLotes;
    }

    public void setNumLotes(Integer numLotes) {
        this.numLotes = numLotes;
    }

    @Override
    public String toString() {
        return "FincaRequest{" +
                "nombreFinca='" + nombreFinca + '\'' +
                ", hectareas=" + hectareas +
                ", idUbicacion=" + idUbicacion +
                " numLotes=" + numLotes + "}";
    }
}
