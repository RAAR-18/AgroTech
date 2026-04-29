package com.agrotech.repository;

import com.agrotech.Entity.Siembra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiembraRepository extends JpaRepository<Siembra, Integer> {

    List<Siembra> findByCultivo_IdCultivo(Integer idCultivo);

    List<Siembra> findByFinca_IdFinca(Integer idFinca);

    @Query("SELECT s FROM Siembra s WHERE s.finca.idFinca = :idFinca " +
           "AND s.cultivo.idCultivo = :idCultivo")
    List<Siembra> findByFincaAndCultivo(@Param("idFinca") Integer idFinca,
                                         @Param("idCultivo") Integer idCultivo);

    @Query("SELECT s FROM Siembra s JOIN s.estadosCultivo sec " +
           "WHERE sec.estadoCultivo.idEstadoCultivo = :idEstado")
    List<Siembra> findByEstadoCultivo(@Param("idEstado") Integer idEstado);
}
