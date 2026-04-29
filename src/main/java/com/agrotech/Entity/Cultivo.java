package com.agrotech.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cultivos")
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cultivo")
    private Integer idCultivo;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipocultivo")
    private TipoCultivo tipoCultivo;

    @OneToMany(mappedBy = "cultivo", fetch = FetchType.LAZY)
    private List<Siembra> siembras;

    public Cultivo() {}

    public Cultivo(Integer idCultivo, String nombre, TipoCultivo tipoCultivo) {
        this.idCultivo = idCultivo;
        this.nombre = nombre;
        this.tipoCultivo = tipoCultivo;
    }

    public Integer getIdCultivo() { return idCultivo; }
    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoCultivo getTipoCultivo() { return tipoCultivo; }
    public void setTipoCultivo(TipoCultivo tiposCultivo) { this.tipoCultivo = tipoCultivo; }

    public List<Siembra> getSiembras() { return siembras; }
    public void setSiembras(List<Siembra> siembras) { this.siembras = siembras; }

    @Override
    public String toString() {
        return "Cultivo{" +
                "idCultivo=" + idCultivo +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
