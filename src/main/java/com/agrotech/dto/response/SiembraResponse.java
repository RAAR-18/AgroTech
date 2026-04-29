package com.agrotech.dto.response;

public class SiembraResponse {

    private Integer idSiembra;
    private String nombreCultivo;
    private String nombreFinca;

    public SiembraResponse() {}

    public SiembraResponse(Integer idSiembra, String nombreCultivo, String nombreFinca) {
        this.idSiembra = idSiembra;
        this.nombreCultivo = nombreCultivo;
        this.nombreFinca = nombreFinca;
    }

    public Integer getIdSiembra() { return idSiembra; }

    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra; }

    public String getNombreCultivo() { return nombreCultivo; }

    public void setNombreCultivo(String nombreCultivo) { this.nombreCultivo = nombreCultivo; }

    public String getNombreFinca() { return nombreFinca; }

    public void setNombreFinca(String nombreFinca) { this.nombreFinca = nombreFinca; }

     @Override
    public String toString() {
         return "SiembraResponse{idFinca=" + idSiembra + ", nombreCultivo = '" + nombreCultivo + "', nombreFinca='" + nombreFinca + "'}";
     }
}
