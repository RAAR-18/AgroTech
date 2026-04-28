package com.agrotech.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "siembras_estadocultivos")
public class SiembraEstadoCultivo {
    @EmbeddedId
    private SiembraEstadoCultivoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSiembra")
    @JoinColumn(name = "id_siembra")
    private Siembra siembra;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEstadoCultivo")
    @JoinColumn(name = "id_estadocultivo")
    private EstadoCultivo estadoCultivo;

    @Column(name = "fecha_estado")
    private LocalDateTime fechaEstado;

    public SiembraEstadoCultivo() {}

    public SiembraEstadoCultivo(Siembra siembra, EstadoCultivo estadoCultivo, LocalDateTime fechaEstado) {
        this.id = new SiembraEstadoCultivoId(siembra.getIdSiembra(), estadoCultivo.getIdEstadoCultivo());
        this.siembra = siembra;
        this.estadoCultivo = estadoCultivo;
        this.fechaEstado = fechaEstado;
    }

    public SiembraEstadoCultivoId getId() { return id; }
    public void setId(SiembraEstadoCultivoId id) { this.id = id; }

    public Siembra getSiembra() { return siembra; }
    public void setSiembra(Siembra siembra) { this.siembra = siembra; }

    public EstadoCultivo getEstadoCultivo() { return estadoCultivo; }
    public void setEstadoCultivo(EstadoCultivo estadoCultivo) { this.estadoCultivo = estadoCultivo; }

    public LocalDateTime getFechaEstado() { return fechaEstado; }
    public void setFechaEstado(LocalDateTime fechaEstado) { this.fechaEstado = fechaEstado; }

    @Override
    public String toString() {
        return "SiembraEstadoCultivo{id=" + id + ", fechaEstado=" + fechaEstado + "}";
    }

}
