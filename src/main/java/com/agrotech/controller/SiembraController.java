package com.agrotech.controller;

import com.agrotech.dto.request.SiembraRequestDTO;
import com.agrotech.dto.request.SiembraUpdateRequestDTO;
import com.agrotech.dto.response.SiembraResponseDTO;
import com.agrotech.service.SiembraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/siembras")
public class SiembraController {

    private final SiembraService siembraService;

    public SiembraController(SiembraService siembraService) {
        this.siembraService = siembraService;
    }

    @PostMapping("/crear")
    public ResponseEntity<SiembraResponseDTO> crearSiembra(@RequestBody SiembraRequestDTO siembraRequestDTO) {
        SiembraResponseDTO response = siembraService.crear(siembraRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SiembraResponseDTO>> listarSiembras() {
        return ResponseEntity.ok(siembraService.listar());
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorFinca(@PathVariable Integer idFinca) {
        return ResponseEntity.ok(siembraService.bucarPorFinca(idFinca));
    }

    @GetMapping("/cultivo/{idCultivo}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorCultivo(@PathVariable Integer idCultivo) {
        return ResponseEntity.ok(siembraService.bucarPorCultivo(idCultivo));
    }

    @GetMapping("/finca/{idFinca}/cultivo/{idCultivo}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorFincaYCultivo(@PathVariable Integer idFinca, @PathVariable Integer idCultivo) {
        return ResponseEntity.ok(siembraService.buscarPorFincaYCultivo(idFinca, idCultivo));
    }

    @GetMapping("/finca/{idFinca}/lote/{numLote}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorFincaYLote(@PathVariable Integer idFinca, @PathVariable Integer numLote) {
        return ResponseEntity.ok(siembraService.buscarPorFincaYLote(idFinca, numLote));
    }

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorEstado(@PathVariable Integer idEstado) {
        return ResponseEntity.ok(siembraService.buscarPorEstado(idEstado));
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<SiembraResponseDTO>> buscarPorRangoFechas(@RequestParam LocalDateTime desde, @RequestParam(required = false) LocalDateTime hasta) {

        LocalDateTime fechaHasta = hasta != null ? hasta : LocalDateTime.now();
        return ResponseEntity.ok(siembraService.buscarPorRangoFechas(desde, fechaHasta));
    }

    @PutMapping("/{idSiembra}")
    public ResponseEntity<SiembraResponseDTO> actualizar(@PathVariable Integer idSiembra, @RequestBody SiembraUpdateRequestDTO dto) {
        return ResponseEntity.ok(siembraService.actualizar(idSiembra, dto));
    }

    // eliminar: Elimina el historial completo
    @DeleteMapping("/eliminar/{idSiembra}")
    public ResponseEntity<Void> eliminarSiembra(@PathVariable Integer idSiembra) {
        siembraService.eliminar(idSiembra);
        return ResponseEntity.noContent().build();
    }
}
