package com.agrotech.repositorio;

import com.agrotech.Entity.Siembra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiembraRepositorio extends JpaRepository<Siembra, Integer> {

    // Buscar siembra por finca
    List<Siembra> findByFinca_IdFinca(Integer idFinca);

    // Buscar siembra por cultivo
    List<Siembra> findByCultivo_IdCultivo(Integer idCultivo);
}
