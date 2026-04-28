package com.agrotech.repository;

import com.agrotech.Entity.EstadoCultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoCultivoRepository extends JpaRepository<EstadoCultivo, Integer> {

    Optional<EstadoCultivo> findByNombre(String nombre);

    List<EstadoCultivo> findByNombreContainingIgnoreCase(String nombre);
}
