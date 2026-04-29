package com.agrotech.repository;

import com.agrotech.Entity.TipoCultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoCultivoRepository extends JpaRepository<TipoCultivo, Integer> {

    Optional<TipoCultivo> findByNombre(String nombre);

    List<TipoCultivo> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT t FROM TipoCultivo t JOIN t.cultivos c WHERE c.idCultivo = :idCultivo")
    List<TipoCultivo> findByCultivoId(Integer idCultivo);
}
