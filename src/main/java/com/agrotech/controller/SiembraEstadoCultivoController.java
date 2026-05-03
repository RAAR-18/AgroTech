package com.agrotech.controller;

import com.agrotech.dto.request.SiembraEstadoCultivoRequestDTO;
import com.agrotech.dto.response.SiembraEstadoCultivoResponseDTO;
import com.agrotech.service.SiembraEstadoCultivoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siembras-estados")
public class SiembraEstadoCultivoController {

    private final SiembraEstadoCultivoService siembraEstadoCultivoService;

    public SiembraEstadoCultivoController(SiembraEstadoCultivoService siembraEstadoCultivoService) {
        this.siembraEstadoCultivoService = siembraEstadoCultivoService;
    }

    // POST /api/siembras-estados
    @PostMapping
    public ResponseEntity<SiembraEstadoCultivoResponseDTO> registrarEstadoCultivo(@Valid @RequestBody SiembraEstadoCultivoRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(siembraEstadoCultivoService.registrarEstadoCultivo(request));
    }

    // GET /api/siembras-estados/siembra/{idSiembra}
    @GetMapping("/siembra/{idSiembra}")
    public ResponseEntity<List<SiembraEstadoCultivoResponseDTO>> listarPorSiembra(@PathVariable Integer idSiembra) {
        return ResponseEntity.ok(siembraEstadoCultivoService.listarPorSiembra(idSiembra));
    }

    // GET /api/siembras-estados/siembra/{idSiembra}/actual
    @GetMapping("/siembra/{idSiembra}/actual")
    public ResponseEntity<SiembraEstadoCultivoResponseDTO> obtenerEstadoCultivoActual(@PathVariable Integer idSiembra) {
        return ResponseEntity.ok(siembraEstadoCultivoService.obtenerEstadoCultivoActual(idSiembra));
    }

    // GET /api/siembras-estados/estado/{idEstadoCultivo}
    @GetMapping("/estado/{idEstadoCultivo}")
    public ResponseEntity<List<SiembraEstadoCultivoResponseDTO>> listarPorEstadoCultivo(@PathVariable Integer idEstadoCultivo) {
        return ResponseEntity.ok(siembraEstadoCultivoService.listarPorEstadoCultivo(idEstadoCultivo));
    }

    // DELETE /api/siembras-estados/siembra/{idSiembra}/estado/{idEstadoCultivo}
    @DeleteMapping("/siembra/{idSiembra}/estado/{idEstadoCultivo}")
    public ResponseEntity<Void> eliminarEstadoCultivo(@PathVariable Integer idSiembra, @PathVariable Integer idEstadoCultivo) {
        siembraEstadoCultivoService.eliminarEstadoCultivo(idSiembra, idEstadoCultivo);
        return ResponseEntity.noContent().build();
    }
}
