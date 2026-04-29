package com.agrotech.controller;

import com.agrotech.dto.request.SiembraEstadoCultivoRequest;
import com.agrotech.dto.response.SiembraEstadoCultivoResponse;
import com.agrotech.servicio.SiembraEstadoCultivoServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siembras-estados")
public class SiembraEstadoCultivoController {

    private final SiembraEstadoCultivoServicio siembraEstadoCultivoServicio;

    public SiembraEstadoCultivoController(SiembraEstadoCultivoServicio siembraEstadoCultivoServicio) {
        this.siembraEstadoCultivoServicio = siembraEstadoCultivoServicio;
    }

    // POST /api/siembras-estados
    @PostMapping
    public ResponseEntity<SiembraEstadoCultivoResponse> registrarEstadoCultivo(@Valid @RequestBody SiembraEstadoCultivoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(siembraEstadoCultivoServicio.registrarEstadoCultivo(request));
    }

    // GET /api/siembras-estados/siembra/{idSiembra}
    @GetMapping("/siembra/{idSiembra}")
    public ResponseEntity<List<SiembraEstadoCultivoResponse>> listarPorSiembra(@PathVariable Integer idSiembra) {
        return ResponseEntity.ok(siembraEstadoCultivoServicio.listarPorSiembra(idSiembra));
    }

    // GET /api/siembras-estados/siembra/{idSiembra}/actual
    @GetMapping("/siembra/{idSiembra}/actual")
    public ResponseEntity<SiembraEstadoCultivoResponse> obtenerEstadoCultivoActual(@PathVariable Integer idSiembra) {
        return ResponseEntity.ok(siembraEstadoCultivoServicio.obtenerEstadoCultivoActual(idSiembra));
    }

    // GET /api/siembras-estados/estado/{idEstadoCultivo}
    @GetMapping("/estado/{idEstadoCultivo}")
    public ResponseEntity<List<SiembraEstadoCultivoResponse>> listarPorEstadoCultivo(@PathVariable Integer idEstadoCultivo) {
        return ResponseEntity.ok(siembraEstadoCultivoServicio.listarPorEstadoCultivo(idEstadoCultivo));
    }

    // DELETE /api/siembras-estados/siembra/{idSiembra}/estado/{idEstadoCultivo}
    @DeleteMapping("/siembra/{idSiembra}/estado/{idEstadoCultivo}")
    public ResponseEntity<Void> eliminarEstadoCultivo(@PathVariable Integer idSiembra, @PathVariable Integer idEstadoCultivo) {
        siembraEstadoCultivoServicio.eliminarEstadoCultivo(idSiembra, idEstadoCultivo);
        return ResponseEntity.noContent().build();
    }
}
