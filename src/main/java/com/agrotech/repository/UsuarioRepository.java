package com.agrotech.repository;

import com.agrotech.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    List<Usuario> findByRol_IdRol(Integer idRol);

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.apellido = :apellido")
    List<Usuario> findByNombreAndApellido(@Param("nombre") String nombre,
                                          @Param("apellido") String apellido);
}
