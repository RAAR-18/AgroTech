package com.agrotech.repository;

import com.agrotech.Entity.Auxiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuxiliarRepository extends JpaRepository<Auxiliar, Integer> {

    @Query("SELECT a FROM Auxiliar a WHERE a.nombre LIKE %:nombre%")
    List<Auxiliar> findByNombreContaining(String nombre);

    @Query("SELECT a FROM Auxiliar a JOIN a.ejecucionesTareas e WHERE e.tarea.idTarea = :idTarea")
    List<Auxiliar> findByTareaId(Integer idTarea);
}
