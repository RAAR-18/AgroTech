package com.agrotech.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SiembraEstadoCultivoId implements Serializable {
    @Column(name = "id_siembra")
    private Integer idSiembra;

    @Column(name = "id_estadocultivo")
    private Integer idEstadoCultivo;

    public SiembraEstadoCultivoId() {}

    public SiembraEstadoCultivoId(Integer idSiembra, Integer idEstadoCultivo) {
        this.idSiembra = idSiembra;
        this.idEstadoCultivo = idEstadoCultivo;
    }

    public Integer getIdSiembra() { return idSiembra; }
    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra; }

    public Integer getIdEstadoCultivo() { return idEstadoCultivo; }
    public void setIdEstadoCultivo(Integer idEstadoCultivo) { this.idEstadoCultivo = idEstadoCultivo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SiembraEstadoCultivoId)) return false;
        SiembraEstadoCultivoId that = (SiembraEstadoCultivoId) o;
        return Objects.equals(idSiembra, that.idSiembra) &&
                Objects.equals(idEstadoCultivo, that.idEstadoCultivo);
    }

    @Override
    public int hashCode() { return Objects.hash(idSiembra, idEstadoCultivo); }

    @Override
    public String toString() {
        return "SiembraEstadoCultivoId{idSiembra=" + idSiembra +
                ", idEstadoCultivo=" + idEstadoCultivo + "}";
    }

}
