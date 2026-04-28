package com.agrotech.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Integer idTarea;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_productor")
    private Productor usuarioProductor;

    @OneToMany(mappedBy = "tarea", fetch = FetchType.LAZY)
    private List<EjecucionTarea> ejecucionesTareas;

    public Tarea() {}

    public Tarea(Integer idTarea, String nombre, String descripcion, Productor usuarioProductor) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioProductor = usuarioProductor;
    }

    public Integer getIdTarea() { return idTarea; }
    public void setIdTarea(Integer idTarea) { this.idTarea = idTarea; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Productor getUsuarioProductor() { return usuarioProductor; }
    public void setUsuarioProductor(Productor usuarioProductor) { this.usuarioProductor = usuarioProductor; }

    public List<EjecucionTarea> getEjecucionesTareas() { return ejecucionesTareas; }
    public void setEjecucionesTareas(List<EjecucionTarea> ejecucionesTareas) {
        this.ejecucionesTareas = ejecucionesTareas;
    }

    @Override
    public String toString() {
        return "Tarea{idTarea=" + idTarea + ", nombre='" + nombre +
                "', descripcion='" + descripcion + "'}";
    }
}
