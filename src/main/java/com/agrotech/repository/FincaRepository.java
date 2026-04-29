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

    List<Finca> findByProductor_IdUsuario(Integer idProductor);

    List<Finca> findByUbicacion_IdUbicacion(Integer idUbicacion);

    List<Finca> findByNombreFincaContainingIgnoreCase(String nombre);

    List<Finca> findByHectareasGreaterThanEqual(BigDecimal hectareas);

    @Query("SELECT f FROM Finca f WHERE f.productor.idUsuario = :idProductor " +
           "AND f.hectareas >= :minHectareas")
    List<Finca> findByProductorAndMinHectareas(@Param("idProductor") Integer idProductor,
                                                @Param("minHectareas") BigDecimal minHectareas);
}
