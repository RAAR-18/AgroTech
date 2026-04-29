package com.agrotech.repositorio;

import com.agrotech.Entity.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultivoRepositorio extends JpaRepository<Cultivo, Integer> {

    // Buscar cultivo por nombre sin distición de mayúscula
    List<Cultivo> findByNombreContainingIgnoreCase(String nombre);

    // Buscar cultivo por número de lote
    List<Cultivo> findByNumeroLote(Integer numeroLote);

    // Buscar cultivos por tipo de cultivo
    List<Cultivo> findByTiposCultivos_IdTipoCultivo(Integer idTipoCultivo);
}
