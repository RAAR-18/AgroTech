package com.agrotech.dto.request;

public class SiembraUpdateRequestDTO {

    private Integer idFinca;
    private Integer idCultivo;
    private Integer numLote;

    public SiembraUpdateRequestDTO() {}

    public SiembraUpdateRequestDTO(Integer idFinca, Integer idCultivo, Integer numLote) {
        this.idFinca = idFinca;
        this.idCultivo = idCultivo;
        this.numLote = numLote;
    }

    public Integer getIdFinca() { return idFinca; }

    public void setIdFinca(Integer idFinca) { this.idFinca = idFinca; }

    public Integer getIdCultivo() { return idCultivo; }

    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

    public Integer getNumLote() { return numLote; }

    public void setNumLote(Integer numLote) { this.numLote = numLote; }

     @Override
    public String toString() {
         return "SiembraUpdateRequestDTO{" +
                 "idFinca=" + idFinca +
                 ", idCultivo=" + idCultivo +
                 ", numLote=" + numLote + "}";
     }
}
