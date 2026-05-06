package com.agrotech.dto.response;

import java.time.LocalDateTime;

public class SiembraResponseDTO {

    private Integer idSiembra;
    private String nombreCultivo;
    private String nombreFinca;
    private String nombreEstado;
    private Integer numLote;
    private LocalDateTime fechaSiembra;
    private LocalDateTime fechaEstado;

    public SiembraResponseDTO() {}

    public SiembraResponseDTO(Integer idSiembra, String nombreCultivo, String nombreFinca, String nombreEstado,Integer numLote, LocalDateTime fechaSiembra, LocalDateTime fechaEstado) {
        this.idSiembra = idSiembra;
        this.nombreCultivo = nombreCultivo;
        this.nombreFinca = nombreFinca;
        this.nombreEstado = nombreEstado;
        this.numLote = numLote;
        this.fechaSiembra = fechaSiembra;
        this.fechaEstado = fechaEstado;
    }

    public Integer getIdSiembra() { return idSiembra; }

    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra; }

    public String getNombreCultivo() { return nombreCultivo; }

    public void setNombreCultivo(String nombreCultivo) { this.nombreCultivo = nombreCultivo; }

    public String getNombreFinca() { return nombreFinca; }

    public void setNombreFinca(String nombreFinca) { this.nombreFinca = nombreFinca; }

    public Integer getNumLote() { return numLote; }

    public void setNumLote(Integer numLote) { this.numLote = numLote; }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public LocalDateTime getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(LocalDateTime fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public LocalDateTime getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(LocalDateTime fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    @Override
    public String toString() {
         return "SiembraResponse{idFinca=" + idSiembra + ", nombreCultivo = '" + nombreCultivo + "', nombreFinca='" + nombreFinca + "Estados=" + nombreEstado + "numLore= " + numLote + "}";
     }
}
