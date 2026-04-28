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

    @Column(name = "numero_lote")
    private Integer numeroLote;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cultivos_tipos_cultivos",
            joinColumns = @JoinColumn(name = "id_cultivo"),
            inverseJoinColumns = @JoinColumn(name = "id_tipocultivo")
    )
    private List<TipoCultivo> tiposCultivos;

    @OneToMany(mappedBy = "cultivo", fetch = FetchType.LAZY)
    private List<Siembra> siembras;

    public Cultivo() {}

    public Cultivo(Integer idCultivo, Integer numeroLote, String nombre) {
        this.idCultivo = idCultivo;
        this.numeroLote = numeroLote;
        this.nombre = nombre;
    }

    public Integer getIdCultivo() { return idCultivo; }
    public void setIdCultivo(Integer idCultivo) { this.idCultivo = idCultivo; }

    public Integer getNumeroLote() { return numeroLote; }
    public void setNumeroLote(Integer numeroLote) { this.numeroLote = numeroLote; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<TipoCultivo> getTiposCultivos() { return tiposCultivos; }
    public void setTiposCultivos(List<TipoCultivo> tiposCultivos) { this.tiposCultivos = tiposCultivos; }

    public List<Siembra> getSiembras() { return siembras; }
    public void setSiembras(List<Siembra> siembras) { this.siembras = siembras; }

    @Override
    public String toString() {
        return "Cultivo{idCultivo=" + idCultivo + ", numeroLote=" + numeroLote +
                ", nombre='" + nombre + "'}";
    }

}
