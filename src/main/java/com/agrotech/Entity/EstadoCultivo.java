package com.agrotech.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estadoscultivos")
public class EstadoCultivo {
    @Id
    @Column(name = "id_estadocultivo")
    private Integer idEstadoCultivo;

    @Column(name = "nombre", length = 500)
    private String nombre;

    @OneToMany(mappedBy = "estadoCultivo", fetch = FetchType.LAZY)
    private List<SiembraEstadoCultivo> siembrasEstado;

    public EstadoCultivo() {}

    public EstadoCultivo(Integer idEstadoCultivo, String nombre) {
        this.idEstadoCultivo = idEstadoCultivo;
        this.nombre = nombre;
    }

    public Integer getIdEstadoCultivo() { return idEstadoCultivo; }
    public void setIdEstadoCultivo(Integer idEstadoCultivo) { this.idEstadoCultivo = idEstadoCultivo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<SiembraEstadoCultivo> getSiembrasEstado() { return siembrasEstado; }
    public void setSiembrasEstado(List<SiembraEstadoCultivo> siembrasEstado) {
        this.siembrasEstado = siembrasEstado;
    }

    @Override
    public String toString() {
        return "EstadoCultivo{idEstadoCultivo=" + idEstadoCultivo + ", nombre='" + nombre + "'}";
    }

}
