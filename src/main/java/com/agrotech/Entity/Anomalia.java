package com.agrotech.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anomalias")
public class Anomalia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anomalia")
    private Integer idAnomalia;

    @Column(name = "nombre", length = 300)
    private String nombre;

    @Column(name = "tipo", length = 250)
    private String tipo;

    @Column(name = "estado", length = 250)
    private String estado;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "nivel_severidad", length = 100)
    private String nivelSeveridad;

    @Column(name = "fecha_deteccion")
    private LocalDateTime fechaDeteccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_finca")
    private Finca finca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Anomalia() {}

    public Anomalia(Integer idAnomalia, String nombre, String tipo, String estado,
                    String descripcion, String nivelSeveridad, LocalDateTime fechaDeteccion,
                    Finca finca, Usuario usuario) {
        this.idAnomalia = idAnomalia;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.nivelSeveridad = nivelSeveridad;
        this.fechaDeteccion = fechaDeteccion;
        this.finca = finca;
        this.usuario = usuario;
    }

    public Integer getIdAnomalia() { return idAnomalia; }
    public void setIdAnomalia(Integer idAnomalia) { this.idAnomalia = idAnomalia; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getNivelSeveridad() { return nivelSeveridad; }
    public void setNivelSeveridad(String nivelSeveridad) { this.nivelSeveridad = nivelSeveridad; }

    public LocalDateTime getFechaDeteccion() { return fechaDeteccion; }
    public void setFechaDeteccion(LocalDateTime fechaDeteccion) { this.fechaDeteccion = fechaDeteccion; }

    public Finca getFinca() { return finca; }
    public void setFinca(Finca finca) { this.finca = finca; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Anomalia{idAnomalia=" + idAnomalia + ", nombre='" + nombre +
                "', tipo='" + tipo + "', estado='" + estado +
                "', nivelSeveridad='" + nivelSeveridad +
                "', fechaDeteccion=" + fechaDeteccion + "}";
    }
}
