package com.agrotech.repository;

import com.agrotech.Entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {

    List<Reporte> findByUsuarioProductor_IdUsuario(Integer idProductor);

    List<Reporte> findByFormatoIgnoreCase(String formato);

    List<Reporte> findByTipoPeriodicidadIgnoreCase(String tipoPeriodicidad);

    List<Reporte> findByNombreReporteContainingIgnoreCase(String nombre);

    List<Reporte> findByFechaCreacionBetween(LocalDateTime desde, LocalDateTime hasta);

    @Query("SELECT r FROM Reporte r WHERE r.usuarioProductor.idUsuario = :idProductor " +
           "ORDER BY r.fechaCreacion DESC")
    List<Reporte> findByProductorOrderByFechaDesc(@Param("idProductor") Integer idProductor);

    @Query("SELECT r FROM Reporte r WHERE r.usuarioProductor.idUsuario = :idProductor " +
           "AND r.formato = :formato AND r.tipoPeriodicidad = :periodicidad")
    List<Reporte> findByProductorFormatoYPeriodicidad(@Param("idProductor") Integer idProductor,
                                                       @Param("formato") String formato,
                                                       @Param("periodicidad") String periodicidad);
}
