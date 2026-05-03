package com.agrotech.dto.response;

import java.time.LocalDateTime;

public class SiembraEstadoCultivoResponseDTO {

    private Integer idSiembra;
    private Integer idEstadoCultivo;
    private String nombreEstado;
    private String nombreCultivo;
    private String nombreFinca;
    private LocalDateTime fechaEstado;

    public SiembraEstadoCultivoResponseDTO() {}

    public SiembraEstadoCultivoResponseDTO(Integer idSiembra, Integer idEstadoCultivo, String nombreEstado, String nombreFinca, LocalDateTime fechaEstado, String nombreCultivo) {
        this.idSiembra = idSiembra;
        this.idEstadoCultivo = idEstadoCultivo;
        this.nombreEstado = nombreEstado;
        this.nombreFinca = nombreFinca;
        this.fechaEstado = fechaEstado;
        this.nombreCultivo = nombreCultivo;
    }

    public Integer getIdSiembra() { return idSiembra; }
    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra;}

    public Integer getIdEstadoCultivo() { return idEstadoCultivo; }
    public void setIdEstadoCultivo(Integer idEstadoCultivo) { this.idEstadoCultivo = idEstadoCultivo; }

    public String getNombreEstado() { return nombreEstado; }
    public void setNombreEstado(String nombreEstado) { this.nombreEstado = nombreEstado; }

    public String getNombreFinca() { return nombreFinca; }
    public void setNombreFinca(String nombreFinca) { this.nombreFinca = nombreFinca; }

    public LocalDateTime getFechaEstado() { return fechaEstado; }
    public void setFechaEstado(LocalDateTime fechaEstado) { this.fechaEstado = fechaEstado; }

    public String getNombreCultivo() { return nombreCultivo; }
    public void setNombreCultivo(String nombreCultivo) { this.nombreCultivo = nombreCultivo;}

    @Override
    public String toString() {
        return "SiembraEstadoCultivoResponse{idSiembra=" + idSiembra +
                ", idEstadoCultivo=" + idEstadoCultivo +
                ", nombreEstado='" + nombreEstado + '\'' +
                ", nombreFinca='" + nombreFinca + '\'' +
                ", fechaEstado=" + fechaEstado +
                ", nombreCultivo='" + nombreCultivo + '\'' +
                '}';
    }
}
