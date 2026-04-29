package com.agrotech.repository;

import com.agrotech.Entity.Productor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductorRepository extends JpaRepository<Productor, Integer> {

    @Query("SELECT p FROM Productor p WHERE p.nombre LIKE %:nombre%")
    List<Productor> findByNombreContaining(String nombre);

    @Query("SELECT p FROM Productor p JOIN p.fincas f WHERE f.idFinca = :idFinca")
    List<Productor> findByFincaId(Integer idFinca);
}
