package com.agrotech.repository;

import com.agrotech.Entity.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Integer> {

    List<Clima> findByUbicacion_IdUbicacion(Integer idUbicacion);

    List<Clima> findByCondicionIgnoreCase(String condicion);

    List<Clima> findByFechaMedicionBetween(LocalDate desde, LocalDate hasta);

    @Query("SELECT c FROM Clima c WHERE c.temperatura >= :min AND c.temperatura <= :max")
    List<Clima> findByRangoTemperatura(@Param("min") java.math.BigDecimal min,
                                       @Param("max") java.math.BigDecimal max);

    @Query("SELECT c FROM Clima c WHERE c.ubicacion.idUbicacion = :idUbicacion " +
           "ORDER BY c.fechaRegistro DESC")
    List<Clima> findUltimosRegistrosPorUbicacion(@Param("idUbicacion") Integer idUbicacion);
}
