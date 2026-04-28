package com.agrotech.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "auxiliares")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Auxiliar extends Usuario{
    @OneToMany(mappedBy = "auxiliar", fetch = FetchType.LAZY)
    private List<EjecucionTarea> ejecucionesTareas;

    public Auxiliar() {}

    public List<EjecucionTarea> getEjecucionesTareas() { return ejecucionesTareas; }
    public void setEjecucionesTareas(List<EjecucionTarea> ejecucionesTareas) {
        this.ejecucionesTareas = ejecucionesTareas;
    }

    @Override
    public String toString() {
        return "Auxiliar{idUsuario=" + getIdUsuario() + ", nombre='" + getNombre() + "'}";
    }
}
