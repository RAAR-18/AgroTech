package com.agrotech.dto.response;

public class CultivoResponse {

    private Integer idCultivo;
    private String nombre;
    private String nombreTipoCultivo;

    public CultivoResponse() {}

    public CultivoResponse(Integer idCultivo, String nombre, String nombreTipoCultivo) {
        this.idCultivo = idCultivo;
        this.nombre = nombre;
        this.nombreTipoCultivo = nombreTipoCultivo;
    }

    public Integer getIdCultivo() { return idCultivo; }
    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombreTipoCultivo() { return nombreTipoCultivo; }
    public void setNombreTipoCultivo(String nombreTipoCultivo) { this.nombreTipoCultivo = nombreTipoCultivo; }

    @Override
    public String toString() {
        return "CultivoResponse{" +
                "idCultivo=" + idCultivo +
                ", nombre='" + nombre + '\'' +
                ", nombreTipoCultivo='" + nombreTipoCultivo + '\'' +
                '}';
    }


}
