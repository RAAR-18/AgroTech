package com.agrotech.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ejecuciones_tareas")
public class EjecucionTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejecucion_tarea")
    private Integer idEjecucionTarea;

    @Column(name = "fecha_estado")
    private LocalDateTime fechaEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoTarea estadoTarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_auxiliar")
    private Auxiliar auxiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operativo")
    private Operario operario;

    public EjecucionTarea() {}

    public EjecucionTarea(Integer idEjecucionTarea, LocalDateTime fechaEstado,
                          EstadoTarea estadoTarea, Tarea tarea,
                          Auxiliar auxiliar, Operario operario) {
        this.idEjecucionTarea = idEjecucionTarea;
        this.fechaEstado = fechaEstado;
        this.estadoTarea = estadoTarea;
        this.tarea = tarea;
        this.auxiliar = auxiliar;
        this.operario = operario;
    }

    public Integer getIdEjecucionTarea() { return idEjecucionTarea; }
    public void setIdEjecucionTarea(Integer idEjecucionTarea) { this.idEjecucionTarea = idEjecucionTarea; }

    public LocalDateTime getFechaEstado() { return fechaEstado; }
    public void setFechaEstado(LocalDateTime fechaEstado) { this.fechaEstado = fechaEstado; }

    public EstadoTarea getEstadoTarea() { return estadoTarea; }
    public void setEstadoTarea(EstadoTarea estadoTarea) { this.estadoTarea = estadoTarea; }

    public Tarea getTarea() { return tarea; }
    public void setTarea(Tarea tarea) { this.tarea = tarea; }

    public Auxiliar getAuxiliar() { return auxiliar; }
    public void setAuxiliar(Auxiliar auxiliar) { this.auxiliar = auxiliar; }

    public Operario getOperario() { return operario; }
    public void setOperario(Operario operario) { this.operario = operario; }

    @Override
    public String toString() {
        return "EjecucionTarea{idEjecucionTarea=" + idEjecucionTarea +
                ", fechaEstado=" + fechaEstado + "}";
    }
}
