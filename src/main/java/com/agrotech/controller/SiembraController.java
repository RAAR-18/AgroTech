package com.agrotech.controller;

import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;
import com.agrotech.service.SiembraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siembras")
public class SiembraController {

    private final SiembraService siembraService;

    public SiembraController(SiembraService siembraService) {
        this.siembraService = siembraService;
    }

    // crear
    @PostMapping("/crear")
    public ResponseEntity<SiembraResponseDTO> crearSiembra(@RequestBody SiembraRequestDTO siembraRequestDTO) {
        SiembraResponseDTO response = siembraService.crear(siembraRequestDTO);
        return ResponseEntity.ok(response);
    }

    // listar todas las siembras
    @GetMapping("/listar")
    public ResponseEntity<List<SiembraResponseDTO>> listarSiembras() {
        return ResponseEntity.ok(siembraService.listar());
    }

    // buscar por finca
    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorFinca(@PathVariable Integer idFinca) {
        return ResponseEntity.ok(siembraService.bucarPorFinca(idFinca));
    }

    // buscar por cultivo
    @GetMapping("/cultivo/{idCultivo}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorCultivo(@PathVariable Integer idCultivo) {
        return ResponseEntity.ok(siembraService.bucarPorCultivo(idCultivo));
    }

    // eliminar
    @DeleteMapping("/eliminar/{idSiembra}")
    public ResponseEntity<Void> eliminarSiembra(@PathVariable Integer idSiembra) {
        siembraService.eliminar(idSiembra);
        return ResponseEntity.noContent().build();
    }
}
