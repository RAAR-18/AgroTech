package com.agrotech.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Integer idReporte;

    @Column(name = "formato", length = 50)
    private String formato;

    @Column(name = "nombre_reporte", length = 100)
    private String nombreReporte;

    @Column(name = "tipo_periodicidad", length = 100)
    private String tipoPeriodicidad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_productor")
    private Productor usuarioProductor;

    public Reporte() {}

    public Reporte(Integer idReporte, String formato, String nombreReporte,
                   String tipoPeriodicidad, LocalDateTime fechaCreacion,
                   Productor usuarioProductor) {
        this.idReporte = idReporte;
        this.formato = formato;
        this.nombreReporte = nombreReporte;
        this.tipoPeriodicidad = tipoPeriodicidad;
        this.fechaCreacion = fechaCreacion;
        this.usuarioProductor = usuarioProductor;
    }

    public Integer getIdReporte() { return idReporte; }
    public void setIdReporte(Integer idReporte) { this.idReporte = idReporte; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public String getNombreReporte() { return nombreReporte; }
    public void setNombreReporte(String nombreReporte) { this.nombreReporte = nombreReporte; }

    public String getTipoPeriodicidad() { return tipoPeriodicidad; }
    public void setTipoPeriodicidad(String tipoPeriodicidad) { this.tipoPeriodicidad = tipoPeriodicidad; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Productor getUsuarioProductor() { return usuarioProductor; }
    public void setUsuarioProductor(Productor usuarioProductor) { this.usuarioProductor = usuarioProductor; }

    @Override
    public String toString() {
        return "Reporte{idReporte=" + idReporte + ", nombreReporte='" + nombreReporte +
                "', formato='" + formato + "', tipoPeriodicidad='" + tipoPeriodicidad +
                "', fechaCreacion=" + fechaCreacion + "}";
    }
}
