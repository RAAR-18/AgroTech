package com.agrotech.repository;

import com.agrotech.Entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findByUsuario_IdUsuario(Integer idUsuario);

    List<Notificacion> findByEstadoIgnoreCase(String estado);

    List<Notificacion> findByPrioridadIgnoreCase(String prioridad);

    List<Notificacion> findByTipoIgnoreCase(String tipo);

    List<Notificacion> findByClima_IdClima(Integer idClima);

    @Query("SELECT n FROM Notificacion n WHERE n.usuario.idUsuario = :idUsuario " +
           "AND n.estado = :estado ORDER BY n.fechaCreacion DESC")
    List<Notificacion> findByUsuarioAndEstado(@Param("idUsuario") Integer idUsuario,
                                               @Param("estado") String estado);

    @Query("SELECT n FROM Notificacion n WHERE n.usuario.idUsuario = :idUsuario " +
           "ORDER BY n.fechaCreacion DESC")
    List<Notificacion> findByUsuarioOrderByFechaDesc(@Param("idUsuario") Integer idUsuario);
}
