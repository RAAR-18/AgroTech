package com.agrotech.controller;

import com.agrotech.dto.request.CultivoRequestDTO;
import com.agrotech.dto.response.CultivoResponseDTO;
import com.agrotech.service.CultivoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
public class CultivoController {

    private final CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService) {
        this.cultivoService = cultivoService;
    }

    // Crear Cultivo
    // /api/cultivos
    @PostMapping
    public ResponseEntity<CultivoResponseDTO> crearCultivo(@Valid @RequestBody CultivoRequestDTO cultivoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cultivoService.crear(cultivoRequestDTO));
    }

    // Listar Cultivos
    // /api/cultivos
    @GetMapping
    public ResponseEntity<List<CultivoResponseDTO>> listarCultivos() {
        return ResponseEntity.ok(cultivoService.listarTodos());
    }

    /*
    // Buscar por Tipo de Cultivo
    // /api/cultivos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<List<CultivoResponse>> buscarCultivoPorTipoCultivo(@PathVariable Integer idTipoCultivo) {
        return ResponseEntity.ok(cultivoServicio.buscarPorTipo(idTipoCultivo));
    }


    // Buscar por nombre
    // /api/cultivos?nombre=maiz
    @GetMapping("/buscar")
    public ResponseEntity<List<CultivoResponse>> buscarCultivoPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(cultivoServicio.buscarPorNombre(nombre));
    }

     */

    // Editar cultivo
    // /api/cultivos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CultivoResponseDTO> actualizarCultivo(@PathVariable Integer id, @Valid @RequestBody CultivoRequestDTO cultivoRequestDTO) {
        return ResponseEntity.ok(cultivoService.actualizar(id, cultivoRequestDTO));
    }

    // Eliminar cultivo
    // /api/cultivos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCultivo(@PathVariable Integer id) {
        cultivoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
