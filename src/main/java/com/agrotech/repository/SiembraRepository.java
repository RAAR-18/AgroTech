package com.agrotech.repository;

import com.agrotech.Entity.Siembra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SiembraRepository extends JpaRepository<Siembra, Integer> {

    // Buscar siembra por cultivo
    List<Siembra> findByCultivo_IdCultivo(Integer idCultivo);

    // Buscar siembra por finca
    List<Siembra> findByFinca_IdFinca(Integer idFinca);

    @Query("SELECT s FROM Siembra s JOIN s.estadosCultivo sec " +
           "WHERE sec.estadoCultivo.idEstadoCultivo = :idEstado")
    List<Siembra> findByEstadoCultivo(@Param("idEstado") Integer idEstado);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findAllConUltimoEstado();

    @Query("SELECT s FROM Siembra s " +
    "LEFT JOIN FETCH s.estadosCultivo sec " +
    "LEFT JOIN FETCH sec.estadoCultivo ec " +
    "WHERE s.finca.idFinca = :idFinca " +
    "AND s.cultivo.idCultivo = :idCultivo " +
    "AND sec.fechaEstado = (" +
    "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
    "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
    ")")
    List<Siembra> findByFincaCultivoYUltimoEstado(@Param("idFinca") Integer idFinca,
                                                  @Param("idCultivo") Integer idCultivo);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE s.finca.idFinca = :idFinca " +
            "AND s.numLote = :numLote " +
            "AND sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findByFincaAndNumLoteConUltimoEstado(@Param("idFinca") Integer idFinca,
                                                       @Param("numLote") Integer numLote);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE s.finca.idFinca = :idFinca " +
            "AND sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findByFincaConUltimoEstado(@Param("idFinca") Integer idFinca);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE s.cultivo.idCultivo = :idCultivo " +
            "AND sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findByCultivoConUltimoEstado(@Param("idCultivo") Integer idCultivo);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE sec.estadoCultivo.idEstadoCultivo = :idEstado " +
            "AND sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findByEstadoCultivoConUltimoEstado(@Param("idEstado") Integer idEstado);

    @Query("SELECT s FROM Siembra s " +
            "LEFT JOIN FETCH s.estadosCultivo sec " +
            "LEFT JOIN FETCH sec.estadoCultivo ec " +
            "WHERE sec.fechaEstado BETWEEN :desde AND :hasta " +
            "AND sec.fechaEstado = (" +
            "  SELECT MAX(sec2.fechaEstado) FROM SiembraEstadoCultivo sec2 " +
            "  WHERE sec2.siembra.idSiembra = s.idSiembra" +
            ")")
    List<Siembra> findByRangoFechaConUltimoEstado(@Param("desde") LocalDateTime desde,
                                                  @Param("hasta") LocalDateTime hasta);
}
