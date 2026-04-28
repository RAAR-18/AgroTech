package com.agrotech.repository;

import com.agrotech.Entity.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Integer> {

    List<Cultivo> findByNombreContainingIgnoreCase(String nombre);

    List<Cultivo> findByNumeroLote(Integer numeroLote);

    @Query("SELECT c FROM Cultivo c JOIN c.tiposCultivos t WHERE t.idTiposCultivos = :idTipo")
    List<Cultivo> findByTipoCultivoId(@Param("idTipo") Integer idTipo);

    @Query("SELECT c FROM Cultivo c JOIN c.siembras s WHERE s.finca.idFinca = :idFinca")
    List<Cultivo> findByFincaId(@Param("idFinca") Integer idFinca);
}
