package com.agrotech.repository;

import com.agrotech.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    List<Tarea> findByUsuarioProductor_IdUsuario(Integer idProductor);

    List<Tarea> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT t FROM Tarea t JOIN t.ejecucionesTareas e " +
           "WHERE e.auxiliar.idUsuario = :idAuxiliar")
    List<Tarea> findByAuxiliar(@Param("idAuxiliar") Integer idAuxiliar);

    @Query("SELECT t FROM Tarea t JOIN t.ejecucionesTareas e " +
           "WHERE e.operario.idUsuario = :idOperario")
    List<Tarea> findByOperario(@Param("idOperario") Integer idOperario);

    @Query("SELECT t FROM Tarea t JOIN t.ejecucionesTareas e " +
           "WHERE e.estadoTarea.idEstadoTareas = :idEstado")
    List<Tarea> findByEstado(@Param("idEstado") Integer idEstado);

    @Query("SELECT t FROM Tarea t WHERE t.usuarioProductor.idUsuario = :idProductor " +
           "ORDER BY t.nombre ASC")
    List<Tarea> findByProductorOrderByNombre(@Param("idProductor") Integer idProductor);
}
