package com.agrotech.repository;

import com.agrotech.Entity.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Integer> {

    List<Recomendacion> findByTipoIgnoreCase(String tipo);

    List<Recomendacion> findByClima_IdClima(Integer idClima);

    List<Recomendacion> findByFechaGeneracionBetween(LocalDateTime desde, LocalDateTime hasta);

    @Query("SELECT r FROM Recomendacion r WHERE r.descripcion LIKE %:texto%")
    List<Recomendacion> findByDescripcionContaining(@Param("texto") String texto);

    @Query("SELECT r FROM Recomendacion r ORDER BY r.fechaGeneracion DESC")
    List<Recomendacion> findAllOrderByFechaDesc();
}
