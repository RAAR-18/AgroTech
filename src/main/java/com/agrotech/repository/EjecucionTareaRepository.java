package com.agrotech.repository;

import com.agrotech.Entity.EjecucionTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EjecucionTareaRepository extends JpaRepository<EjecucionTarea, Integer> {

    List<EjecucionTarea> findByTarea_IdTarea(Integer idTarea);

    List<EjecucionTarea> findByAuxiliar_IdUsuario(Integer idAuxiliar);

    List<EjecucionTarea> findByOperario_IdUsuario(Integer idOperario);

    List<EjecucionTarea> findByEstadoTarea_IdEstadoTareas(Integer idEstado);

    List<EjecucionTarea> findByFechaEstadoBetween(LocalDateTime desde, LocalDateTime hasta);

    @Query("SELECT e FROM EjecucionTarea e WHERE e.tarea.idTarea = :idTarea " +
           "ORDER BY e.fechaEstado DESC")
    List<EjecucionTarea> findHistorialByTarea(@Param("idTarea") Integer idTarea);

    @Query("SELECT e FROM EjecucionTarea e WHERE e.auxiliar.idUsuario = :idAuxiliar " +
           "AND e.estadoTarea.idEstadoTareas = :idEstado")
    List<EjecucionTarea> findByAuxiliarAndEstado(@Param("idAuxiliar") Integer idAuxiliar,
                                                  @Param("idEstado") Integer idEstado);

    @Query("SELECT e FROM EjecucionTarea e WHERE e.operario.idUsuario = :idOperario " +
           "AND e.estadoTarea.idEstadoTareas = :idEstado")
    List<EjecucionTarea> findByOperarioAndEstado(@Param("idOperario") Integer idOperario,
                                                  @Param("idEstado") Integer idEstado);

    @Query("SELECT COUNT(e) FROM EjecucionTarea e WHERE e.tarea.idTarea = :idTarea " +
           "AND e.estadoTarea.idEstadoTareas = :idEstado")
    Long countByTareaAndEstado(@Param("idTarea") Integer idTarea,
                                @Param("idEstado") Integer idEstado);
}
