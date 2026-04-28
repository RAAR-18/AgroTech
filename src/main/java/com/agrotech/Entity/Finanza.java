package com.agrotech.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "finanzas")
public class Finanza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_finanza")
    private Integer idFinanza;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "monto")
    private Float monto;

    @Column(name = "tipo_transaccion", length = 100)
    private String tipoTransaccion;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_productor")
    private Productor usuarioProductor;

    public Finanza() {}

    public Finanza(Integer idFinanza, String descripcion, LocalDateTime fechaRegistro,
                   LocalDateTime fechaActualizacion, Float monto, String tipoTransaccion,
                   String categoria, Productor usuarioProductor) {
        this.idFinanza = idFinanza;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.categoria = categoria;
        this.usuarioProductor = usuarioProductor;
    }

    public Integer getIdFinanza() { return idFinanza; }
    public void setIdFinanza(Integer idFinanza) { this.idFinanza = idFinanza; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    public Float getMonto() { return monto; }
    public void setMonto(Float monto) { this.monto = monto; }

    public String getTipoTransaccion() { return tipoTransaccion; }
    public void setTipoTransaccion(String tipoTransaccion) { this.tipoTransaccion = tipoTransaccion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Productor getUsuarioProductor() { return usuarioProductor; }
    public void setUsuarioProductor(Productor usuarioProductor) { this.usuarioProductor = usuarioProductor; }

    @Override
    public String toString() {
        return "Finanza{idFinanza=" + idFinanza + ", monto=" + monto +
                ", tipoTransaccion='" + tipoTransaccion + "', categoria='" + categoria +
                "', fechaRegistro=" + fechaRegistro + "}";
    }
}
