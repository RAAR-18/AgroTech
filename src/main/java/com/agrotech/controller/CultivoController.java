package com.agrotech.controller;

import com.agrotech.dto.request.CultivoRequest;
import com.agrotech.dto.response.CultivoResponse;
import com.agrotech.servicio.CultivoServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
public class CultivoController {

    private final CultivoServicio cultivoServicio;

    public CultivoController(CultivoServicio cultivoServicio) {
        this.cultivoServicio = cultivoServicio;
    }

    // Crear Cultivo
    // /api/cultivos
    @PostMapping
    public ResponseEntity<CultivoResponse> crearCultivo(@Valid @RequestBody CultivoRequest cultivoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cultivoServicio.crear(cultivoRequest));
    }

    // Listar Cultivos
    // /api/cultivos
    @GetMapping
    public ResponseEntity<List<CultivoResponse>> listarCultivos() {
        return ResponseEntity.ok(cultivoServicio.listarTodos());
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
    public ResponseEntity<CultivoResponse> actualizarCultivo(@PathVariable Integer id, @Valid @RequestBody CultivoRequest cultivoRequest) {
        return ResponseEntity.ok(cultivoServicio.actualizar(id, cultivoRequest));
    }

    // Eliminar cultivo
    // /api/cultivos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCultivo(@PathVariable Integer id) {
        cultivoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
