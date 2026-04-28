package com.agrotech.repository;

import com.agrotech.Entity.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaccionRepository extends JpaRepository<Reaccion, Integer> {

    List<Reaccion> findByOperario_IdUsuario(Integer idOperario);

    List<Reaccion> findByProductor_IdUsuario(Integer idProductor);

    List<Reaccion> findByRecomendacion_IdRecomendacion(Integer idRecomendacion);

    List<Reaccion> findByTipoIgnoreCase(String tipo);

    @Query("SELECT r FROM Reaccion r WHERE r.recomendacion.idRecomendacion = :idRecomendacion " +
           "ORDER BY r.fechaReaccion DESC")
    List<Reaccion> findByRecomendacionOrderByFechaDesc(@Param("idRecomendacion") Integer idRecomendacion);

    @Query("SELECT COUNT(r) FROM Reaccion r WHERE r.recomendacion.idRecomendacion = :idRecomendacion " +
           "AND r.tipo = :tipo")
    Long countByRecomendacionAndTipo(@Param("idRecomendacion") Integer idRecomendacion,
                                      @Param("tipo") String tipo);
}
