package com.agrotech.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "fincas")
public class Finca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_finca")
    private Integer idFinca;

    @Column(name = "nombre_finca", length = 100)
    private String nombreFinca;

    @Column(name = "hectareas", precision = 10, scale = 2)
    private BigDecimal hectareas;

    @Column(name = "num_lotes")
    private Integer numLotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_productor")
    private Productor productor;

    @OneToMany(mappedBy = "finca", fetch = FetchType.LAZY)
    private List<Siembra> siembras;

    public Finca() {}

    public Finca(Integer idFinca, String nombreFinca, BigDecimal hectareas,
                 Ubicacion ubicacion, Productor productor, Integer numLotes) {
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
        this.hectareas = hectareas;
        this.ubicacion = ubicacion;
        this.productor = productor;
        this.numLotes = numLotes;
    }

    public Integer getIdFinca() { return idFinca; }
    public void setIdFinca(Integer idFinca) { this.idFinca = idFinca; }

    public String getNombreFinca() { return nombreFinca; }
    public void setNombreFinca(String nombreFinca) { this.nombreFinca = nombreFinca; }

    public BigDecimal getHectareas() { return hectareas; }
    public void setHectareas(BigDecimal hectareas) { this.hectareas = hectareas; }

    public Ubicacion getUbicacion() { return ubicacion; }
    public void setUbicacion(Ubicacion ubicacion) { this.ubicacion = ubicacion; }

    public Productor getProductor() { return productor; }
    public void setProductor(Productor productor) { this.productor = productor; }

    public List<Siembra> getSiembras() { return siembras; }
    public void setSiembras(List<Siembra> siembras) { this.siembras = siembras; }

    public Integer getNumLotes() {
        return numLotes;
    }

    public void setNumLotes(Integer numLotes) {
        this.numLotes = numLotes;
    }

    @Override
    public String toString() {
        return "Finca{idFinca=" + idFinca + ", nombreFinca='" + nombreFinca +
                "', hectareas=" + hectareas + "numLotes=" + numLotes + "}";
    }

}
