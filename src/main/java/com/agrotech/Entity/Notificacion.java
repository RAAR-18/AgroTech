package com.agrotech.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;

    @Column(name = "estado", length = 250)
    private String estado;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "prioridad", length = 100)
    private String prioridad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clima")
    private Clima clima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Notificacion() {}

    public Notificacion(Integer idNotificacion, String estado, String tipo, String prioridad,
                        LocalDateTime fechaCreacion, Clima clima, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.estado = estado;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.clima = clima;
        this.usuario = usuario;
    }

    public Integer getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(Integer idNotificacion) { this.idNotificacion = idNotificacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Clima getClima() { return clima; }
    public void setClima(Clima clima) { this.clima = clima; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Notificacion{idNotificacion=" + idNotificacion + ", tipo='" + tipo +
                "', prioridad='" + prioridad + "', fechaCreacion=" + fechaCreacion + "}";
    }

}
