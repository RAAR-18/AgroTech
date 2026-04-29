package com.agrotech.repository;

import com.agrotech.Entity.Finanza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FinanzaRepository extends JpaRepository<Finanza, Integer> {

    List<Finanza> findByUsuarioProductor_IdUsuario(Integer idProductor);

    List<Finanza> findByTipoTransaccionIgnoreCase(String tipoTransaccion);

    List<Finanza> findByCategoriaIgnoreCase(String categoria);

    List<Finanza> findByFechaRegistroBetween(LocalDateTime desde, LocalDateTime hasta);

    @Query("SELECT f FROM Finanza f WHERE f.usuarioProductor.idUsuario = :idProductor " +
           "AND f.tipoTransaccion = :tipo ORDER BY f.fechaRegistro DESC")
    List<Finanza> findByProductorAndTipo(@Param("idProductor") Integer idProductor,
                                          @Param("tipo") String tipo);

    @Query("SELECT SUM(f.monto) FROM Finanza f WHERE f.usuarioProductor.idUsuario = :idProductor " +
           "AND f.tipoTransaccion = :tipo")
    Float sumMontoByProductorAndTipo(@Param("idProductor") Integer idProductor,
                                      @Param("tipo") String tipo);

    @Query("SELECT f FROM Finanza f WHERE f.usuarioProductor.idUsuario = :idProductor " +
           "AND f.categoria = :categoria AND f.fechaRegistro BETWEEN :desde AND :hasta")
    List<Finanza> findByProductorCategoriaYRango(@Param("idProductor") Integer idProductor,
                                                  @Param("categoria") String categoria,
                                                  @Param("desde") LocalDateTime desde,
                                                  @Param("hasta") LocalDateTime hasta);
}
