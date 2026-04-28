package com.agrotech.Entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "recomendaciones")
public class Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion")
    private Integer idRecomendacion;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clima")
    private Clima clima;

    @OneToMany(mappedBy = "recomendacion", fetch = FetchType.LAZY)
    private List<Reaccion> reacciones;

    public Recomendacion() {}

    public Recomendacion(Integer idRecomendacion, String descripcion, String tipo,
                         LocalDateTime fechaGeneracion, Clima clima) {
        this.idRecomendacion = idRecomendacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaGeneracion = fechaGeneracion;
        this.clima = clima;
    }

    public Integer getIdRecomendacion() { return idRecomendacion; }
    public void setIdRecomendacion(Integer idRecomendacion) { this.idRecomendacion = idRecomendacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public Clima getClima() { return clima; }
    public void setClima(Clima clima) { this.clima = clima; }

    public List<Reaccion> getReacciones() { return reacciones; }
    public void setReacciones(List<Reaccion> reacciones) { this.reacciones = reacciones; }

    @Override
    public String toString() {
        return "Recomendacion{idRecomendacion=" + idRecomendacion + ", tipo='" + tipo +
                "', fechaGeneracion=" + fechaGeneracion + "}";
    }

}
