package com.agrotech.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CultivoRequestDTO {

    @NotBlank(message = "El nombre del cultivo es obligatorio")
    private String nombre;

    @NotNull(message = "El tipo de cultivo es obligatorio")
    private Integer idTipoCultivo;

    public CultivoRequestDTO() {}

    public CultivoRequestDTO(String nombre, Integer idTipoCultivo) {
        this.nombre = nombre;
        this.idTipoCultivo = idTipoCultivo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getIdTipoCultivo() { return idTipoCultivo; }
    public void setIdTipoCultivo(Integer idTipoCultivo) { this.idTipoCultivo = idTipoCultivo; }

    @Override
    public String toString() {
        return "CultivoRequest{" +
                "nombre='" + nombre + '\'' +
                ", idTipoCultivo=" + idTipoCultivo +
                '}';
    }
}
