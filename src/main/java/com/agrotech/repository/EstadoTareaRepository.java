package com.agrotech.repository;

import com.agrotech.Entity.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Integer> {

    Optional<EstadoTarea> findByNombre(String nombre);

    List<EstadoTarea> findByNombreContainingIgnoreCase(String nombre);
}
