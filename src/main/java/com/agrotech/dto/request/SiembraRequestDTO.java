package com.agrotech.dto.request;

import java.time.LocalDateTime;

public class SiembraRequestDTO {

    private Integer idFinca;
    private Integer idCultivo;
    private Integer idEstadoCultivo;
    private LocalDateTime fechaEstado;
    private Integer numLote;

    public SiembraRequestDTO() {}

    public SiembraRequestDTO(Integer idFinca, Integer idCultivo, Integer idEstadoCultivo, LocalDateTime fechaEstado, Integer numLote) {
        this.idFinca = idFinca;
        this.idCultivo = idCultivo;
        this.idEstadoCultivo = idEstadoCultivo;
        this.fechaEstado = fechaEstado;
        this.numLote = numLote;
    }

    public Integer getIdFinca() { return idFinca; }

    public void setIdFinca(Integer idFinca) { this.idFinca = idFinca; }

    public Integer getIdCultivo() { return idCultivo; }

    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

    public Integer getIdEstadoCultivo() { return idEstadoCultivo; }

    public void setIdEstadoCultivo(Integer IdEstadoCultivo) { this.idEstadoCultivo = IdEstadoCultivo; }

    public LocalDateTime getFechaEstado() { return fechaEstado; }

    public void setFechaEstado(LocalDateTime fechaEstado) { this.fechaEstado = fechaEstado; }

    public Integer getNumLote() { return numLote; }

    public void setNumLote(Integer numLote) { this.numLote = numLote; }

     @Override
    public String toString() {
         return "SiembraRequestDTO{" +
                 "idFinca=" + idFinca +
                 ", idCultivo=" + idCultivo +
                 ", idEstadoCultivo=" + idEstadoCultivo +
                 ", fechaEstado=" + fechaEstado +
                 "numLote=" + numLote + "}";
     }
}
