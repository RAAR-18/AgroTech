package com.agrotech.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado_tareas")
public class EstadoTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado_tareas")
    private Integer idEstadoTareas;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @OneToMany(mappedBy = "estadoTarea", fetch = FetchType.LAZY)
    private List<EjecucionTarea> ejecucionesTareas;

    public EstadoTarea() {}

    public EstadoTarea(Integer idEstadoTareas, String nombre) {
        this.idEstadoTareas = idEstadoTareas;
        this.nombre = nombre;
    }

    public Integer getIdEstadoTareas() { return idEstadoTareas; }
    public void setIdEstadoTareas(Integer idEstadoTareas) { this.idEstadoTareas = idEstadoTareas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<EjecucionTarea> getEjecucionesTareas() { return ejecucionesTareas; }
    public void setEjecucionesTareas(List<EjecucionTarea> ejecucionesTareas) {
        this.ejecucionesTareas = ejecucionesTareas;
    }

    @Override
    public String toString() {
        return "EstadoTarea{idEstadoTareas=" + idEstadoTareas + ", nombre='" + nombre + "'}";
    }
}
