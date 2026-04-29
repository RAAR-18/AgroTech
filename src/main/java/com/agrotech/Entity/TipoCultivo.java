package com.agrotech.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipos_cultivos")
public class TipoCultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipos_cultivos")
    private Integer idTiposCultivos;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @OneToMany(mappedBy = "tipoCultivo", fetch = FetchType.LAZY)
    private List<Cultivo> cultivos;

    public TipoCultivo() {}

    public TipoCultivo(Integer idTiposCultivos, String nombre) {
        this.idTiposCultivos = idTiposCultivos;
        this.nombre = nombre;
    }

    public Integer getIdTiposCultivos() { return idTiposCultivos; }
    public void setIdTiposCultivos(Integer idTiposCultivos) { this.idTiposCultivos = idTiposCultivos; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Cultivo> getCultivos() { return cultivos; }
    public void setCultivos(List<Cultivo> cultivos) { this.cultivos = cultivos; }

    @Override
    public String toString() {
        return "TipoCultivo{idTiposCultivos=" + idTiposCultivos + ", nombre='" + nombre + "'}";
    }

}
