package com.agrotech.repository;

import com.agrotech.Entity.Operario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperarioRepository extends JpaRepository<Operario, Integer> {

    @Query("SELECT o FROM Operario o WHERE o.nombre LIKE %:nombre%")
    List<Operario> findByNombreContaining(String nombre);

    @Query("SELECT o FROM Operario o JOIN o.ejecucionesTareas e WHERE e.tarea.idTarea = :idTarea")
    List<Operario> findByTareaId(Integer idTarea);
}
