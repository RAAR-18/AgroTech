package com.agrotech.controller;

import com.agrotech.dto.request.SiembraRequest;
import com.agrotech.dto.response.SiembraResponse;
import com.agrotech.servicio.SiembraServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siembras")
public class SiembraController {

    private final SiembraServicio siembraServicio;

    public SiembraController(SiembraServicio siembraServicio) {
        this.siembraServicio = siembraServicio;
    }

    // crear
    @PostMapping("/crear")
    public ResponseEntity<SiembraResponse> crearSiembra(@RequestBody SiembraRequest siembraRequest) {
        SiembraResponse response = siembraServicio.crear(siembraRequest);
        return ResponseEntity.ok(response);
    }

    // listar todas las siembras
    @GetMapping("/listar")
    public ResponseEntity<List<SiembraResponse>> listarSiembras() {
        return ResponseEntity.ok(siembraServicio.listar());
    }

    // buscar por finca
    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<SiembraResponse>> buscarPorFinca(@PathVariable Integer idFinca) {
        return ResponseEntity.ok(siembraServicio.bucarPorFinca(idFinca));
    }

    // buscar por cultivo
    @GetMapping("/cultivo/{idCultivo}")
    public ResponseEntity<List<SiembraResponse>> buscarPorCultivo(@PathVariable Integer idCultivo) {
        return ResponseEntity.ok(siembraServicio.bucarPorCultivo(idCultivo));
    }

    // eliminar
    @DeleteMapping("/eliminar/{idSiembra}")
    public ResponseEntity<Void> eliminarSiembra(@PathVariable Integer idSiembra) {
        siembraServicio.eliminar(idSiembra);
        return ResponseEntity.noContent().build();
    }
}
