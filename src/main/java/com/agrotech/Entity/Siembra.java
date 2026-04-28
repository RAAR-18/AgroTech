package com.agrotech.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "siembras")
public class Siembra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siembra")
    private Integer idSiembra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultivo", nullable = false)
    private Cultivo cultivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_finca", nullable = false)
    private Finca finca;

    @OneToMany(mappedBy = "siembra", fetch = FetchType.LAZY)
    private List<SiembraEstadoCultivo> estadosCultivo;

    public Siembra() {}

    public Siembra(Integer idSiembra, Cultivo cultivo, Finca finca) {
        this.idSiembra = idSiembra;
        this.cultivo = cultivo;
        this.finca = finca;
    }

    public Integer getIdSiembra() { return idSiembra; }
    public void setIdSiembra(Integer idSiembra) { this.idSiembra = idSiembra; }

    public Cultivo getCultivo() { return cultivo; }
    public void setCultivo(Cultivo cultivo) { this.cultivo = cultivo; }

    public Finca getFinca() { return finca; }
    public void setFinca(Finca finca) { this.finca = finca; }

    public List<SiembraEstadoCultivo> getEstadosCultivo() { return estadosCultivo; }
    public void setEstadosCultivo(List<SiembraEstadoCultivo> estadosCultivo) {
        this.estadosCultivo = estadosCultivo;
    }

    @Override
    public String toString() {
        return "Siembra{idSiembra=" + idSiembra + "}";
    }

}
