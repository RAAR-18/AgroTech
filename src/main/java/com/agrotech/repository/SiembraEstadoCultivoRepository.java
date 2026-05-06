package com.agrotech.repository;

import com.agrotech.Entity.SiembraEstadoCultivo;
import com.agrotech.Entity.SiembraEstadoCultivoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SiembraEstadoCultivoRepository
        extends JpaRepository<SiembraEstadoCultivo, SiembraEstadoCultivoId> {

    // Historial de estados de una siembra
    List<SiembraEstadoCultivo> findById_IdSiembra(Integer idSiembra);

    // Buscar por estado
    List<SiembraEstadoCultivo> findById_IdEstadoCultivo(Integer idEstadoCultivo);

    @Query("SELECT sec FROM SiembraEstadoCultivo sec " +
           "WHERE sec.fechaEstado BETWEEN :desde AND :hasta")
    List<SiembraEstadoCultivo> findByRangoFecha(@Param("desde") LocalDateTime desde,
                                                 @Param("hasta") LocalDateTime hasta);

    // Estado más reciente de una siembra
    @Query("SELECT sec FROM SiembraEstadoCultivo sec " +
           "WHERE sec.siembra.idSiembra = :idSiembra " +
           "ORDER BY sec.fechaEstado DESC")
    List<SiembraEstadoCultivo> findUltimoEstado(@Param("idSiembra") Integer idSiembra);

    @Query("SELECT sec FROM SiembraEstadoCultivo sec " +
            "WHERE sec.siembra.idSiembra = :idSiembra " +
            "ORDER BY sec.fechaEstado ASC")
    List<SiembraEstadoCultivo> findPrimerEstado(@Param("idSiembra") Integer idSiembra);

}
