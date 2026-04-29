package com.agrotech.repositorio;

import com.agrotech.Entity.SiembraEstadoCultivo;
import com.agrotech.Entity.SiembraEstadoCultivoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiembraEstadoCultivoRepositorio extends JpaRepository<SiembraEstadoCultivo, SiembraEstadoCultivoId> {

    // Buscar por estado
    List<SiembraEstadoCultivo> findByEstadoCultivo_IdEstadoCultivo(Integer idEstadoCultivo);
}
