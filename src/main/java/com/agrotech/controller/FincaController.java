package com.agrotech.controller;

import com.agrotech.dto.request.FincaRequestDTO;
import com.agrotech.dto.request.FincaUpdateRequestDTO;
import com.agrotech.dto.response.FincaResponseDTO;
import com.agrotech.service.FincaServIce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class FincaController {

    private final FincaServIce fincaService;

    public FincaController(FincaServIce fincaService) {
        this.fincaService = fincaService;
    }

    // Listar fincas por productor
    // GET /api/fincas/productor/{idProductor}
    @GetMapping("/productor/{idProductor}")
    public ResponseEntity<List<FincaResponseDTO>> listarPorProductor(@PathVariable Integer idProductor) {
        List<FincaResponseDTO> fincas = fincaService.listarPorProductor(idProductor);
        return ResponseEntity.ok(fincas);
    }

    // Buscar finca por ID
    // GET /api/fincas/{idFinca}
    @GetMapping("/{idFinca}")
    public ResponseEntity<FincaResponseDTO> buscarPorId(@PathVariable Integer idFinca) {
        FincaResponseDTO finca = fincaService.buscarPorId(idFinca);
        return ResponseEntity.ok(finca);
    }

    // Crear finca
    // POST /api/fincas/productor/{idProductor}
    @PostMapping("/productor/{idProductor}")
    public ResponseEntity<FincaResponseDTO> crear(@PathVariable Integer idProductor, @RequestBody FincaRequestDTO fincaRequestDTO) {
        FincaResponseDTO nuevaFinca = fincaService.crear(idProductor, fincaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFinca);
    }

    // Editar finca
    // PUT /api/fincas/{idFinca}/productor/{idProductor
    @PutMapping("/{idFinca}/productor/{idProductor}")
    public ResponseEntity<FincaResponseDTO> actualizar(@PathVariable Integer idFinca, @PathVariable Integer idProductor, @RequestBody FincaUpdateRequestDTO fincaUpdateRequestDTO) {
        FincaResponseDTO fincaActualizada = fincaService.actualizar(idFinca, idProductor, fincaUpdateRequestDTO);
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
