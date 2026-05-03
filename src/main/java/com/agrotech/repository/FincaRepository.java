package com.agrotech.repository;

import com.agrotech.Entity.Finca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FincaRepository extends JpaRepository<Finca, Integer> {

    // Buscar fincas de un productor
    List<Finca> findByProductor_IdUsuario(Integer idProductor);

    // Buscar por ubicación
    List<Finca> findByUbicacion_IdUbicacion(Integer idUbicacion);

    // Buscar por nombre
    List<Finca> findByNombreFincaContainingIgnoreCase(String nombre);

    List<Finca> findByHectareasGreaterThanEqual(BigDecimal hectareas);

    boolean existsByNombreFincaAndProductor_IdUsuario(String nombreFinca, Integer idProductor);
}
