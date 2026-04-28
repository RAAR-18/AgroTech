package com.agrotech.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reacciones")
public class Reaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reacciones")
    private Integer idReacciones;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "fecha_reaccion")
    private LocalDateTime fechaReaccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operario")
    private Operario operario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_productor")
    private Productor productor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recomendacion")
    private Recomendacion recomendacion;

    public Reaccion() {}

    public Reaccion(Integer idReacciones, String tipo, LocalDateTime fechaReaccion,
                    Operario operario, Productor productor, Recomendacion recomendacion) {
        this.idReacciones = idReacciones;
        this.tipo = tipo;
        this.fechaReaccion = fechaReaccion;
        this.operario = operario;
        this.productor = productor;
        this.recomendacion = recomendacion;
    }

    public Integer getIdReacciones() { return idReacciones; }
    public void setIdReacciones(Integer idReacciones) { this.idReacciones = idReacciones; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFechaReaccion() { return fechaReaccion; }
    public void setFechaReaccion(LocalDateTime fechaReaccion) { this.fechaReaccion = fechaReaccion; }

    public Operario getOperario() { return operario; }
    public void setOperario(Operario operario) { this.operario = operario; }

    public Productor getProductor() { return productor; }
    public void setProductor(Productor productor) { this.productor = productor; }

    public Recomendacion getRecomendacion() { return recomendacion; }
    public void setRecomendacion(Recomendacion recomendacion) { this.recomendacion = recomendacion; }

    @Override
    public String toString() {
        return "Reaccion{idReacciones=" + idReacciones + ", tipo='" + tipo +
                "', fechaReaccion=" + fechaReaccion + "}";
    }
}
