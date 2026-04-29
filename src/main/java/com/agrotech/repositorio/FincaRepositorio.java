package com.agrotech.repositorio;

import com.agrotech.Entity.Finca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FincaRepositorio extends JpaRepository<Finca, Integer> {

    // Buscar fincas de un productor
    List<Finca> findByProductor_IdUsuario(Integer idProductor);

    // Buscar por nombre
    List<Finca> findByNombreFincaContainingIgnoreCase(String nombre);

    // Buscar por ubicación
    List<Finca> findByUbicacion_IdUbicacion(Integer idUbicacion);
}
