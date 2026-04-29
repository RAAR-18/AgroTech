package com.agrotech.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class FincaUpdateRequest {

    @NotBlank(message = "El nombre de la finca es obligatorio")
    private String nombreFinca;

    @Positive(message = "Las hectáreas deben ser un número positivo")
    private Double hectareas;

    public FincaUpdateRequest() {}

    public FincaUpdateRequest(String nombreFinca, Double hectareas) {
        this.nombreFinca = nombreFinca;
        this.hectareas = hectareas;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setHectareas(Double hectareas) {
        this.hectareas = hectareas;
    }

    public Double getHectareas() {
        return hectareas;
    }

    @Override
    public String toString() {
        return "FincaUpdateRequest{" +
                "nombreFinca='" + nombreFinca + '\'' +
                ", hectareas=" + hectareas +
                '}';
    }
}
