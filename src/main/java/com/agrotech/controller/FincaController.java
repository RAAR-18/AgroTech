package com.agrotech.controller;

import com.agrotech.dto.request.FincaRequest;
import com.agrotech.dto.request.FincaUpdateRequest;
import com.agrotech.dto.response.FincaResponse;
import com.agrotech.servicio.FincaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class FincaController {

    private final FincaServicio fincaService;

    public FincaController(FincaServicio fincaService) {
        this.fincaService = fincaService;
    }

    // Listar fincas por productor
    // GET /api/fincas/productor/{idProductor}
    @GetMapping("/productor/{idProductor}")
    public ResponseEntity<List<FincaResponse>> listarPorProductor(@PathVariable Integer idProductor) {
        List<FincaResponse> fincas = fincaService.listarPorProductor(idProductor);
        return ResponseEntity.ok(fincas);
    }

    // Buscar finca por ID
    // GET /api/fincas/{idFinca}
    @GetMapping("/{idFinca}")
    public ResponseEntity<FincaResponse> buscarPorId(@PathVariable Integer idFinca) {
        FincaResponse finca = fincaService.buscarPorId(idFinca);
        return ResponseEntity.ok(finca);
    }

    // Crear finca
    // POST /api/fincas/productor/{idProductor}
    @PostMapping("/productor/{idProductor}")
    public ResponseEntity<FincaResponse> crear(@PathVariable Integer idProductor, @RequestBody FincaRequest fincaRequest) {
        FincaResponse nuevaFinca = fincaService.crear(idProductor, fincaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFinca);
    }

    // Editar finca
    // PUT /api/fincas/{idFinca}/productor/{idProductor
    @PutMapping("/{idFinca}/productor/{idProductor}")
    public ResponseEntity<FincaResponse> actualizar(@PathVariable Integer idFinca, @PathVariable Integer idProductor, @RequestBody FincaUpdateRequest fincaUpdateRequest) {
        FincaResponse fincaActualizada = fincaService.actualizar(idFinca, idProductor, fincaUpdateRequest);
        return ResponseEntity.ok(fincaActualizada);
    }

    // Eliminar finca
    // DELETE /api/fincas/{idFinca}
    @DeleteMapping("/{idFinca}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idFinca) {
        fincaService.eliminar(idFinca);
        return ResponseEntity.noContent().build();
    }

}
