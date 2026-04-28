package com.agrotech.repository;

import com.agrotech.Entity.Anomalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnomaliaRepository extends JpaRepository<Anomalia, Integer> {

    List<Anomalia> findByFinca_IdFinca(Integer idFinca);

    List<Anomalia> findByUsuario_IdUsuario(Integer idUsuario);

    List<Anomalia> findByTipoIgnoreCase(String tipo);

    List<Anomalia> findByEstadoIgnoreCase(String estado);

    List<Anomalia> findByNivelSeveridadIgnoreCase(String nivelSeveridad);

    List<Anomalia> findByFechaDeteccionBetween(LocalDateTime desde, LocalDateTime hasta);

    @Query("SELECT a FROM Anomalia a WHERE a.finca.idFinca = :idFinca " +
           "AND a.estado = :estado ORDER BY a.fechaDeteccion DESC")
    List<Anomalia> findByFincaAndEstado(@Param("idFinca") Integer idFinca,
                                         @Param("estado") String estado);

    @Query("SELECT a FROM Anomalia a WHERE a.finca.idFinca = :idFinca " +
           "AND a.nivelSeveridad = :nivel")
    List<Anomalia> findByFincaAndNivelSeveridad(@Param("idFinca") Integer idFinca,
                                                 @Param("nivel") String nivel);
}
