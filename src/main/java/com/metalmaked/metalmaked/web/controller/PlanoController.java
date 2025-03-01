package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.PlanoDTO;
import com.metalmaked.metalmaked.domain.service.PlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    // Consultar todos los planos
    @Operation(summary = "Obtener todos los planos", description = "Retorna una lista de todos los planos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de planos obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<PlanoDTO>> getAllPlanos() {
        Iterable<PlanoDTO> planos = planoService.findAll();
        return new ResponseEntity<>(planos, HttpStatus.OK);
    }

    // Consultar plano por ID
    @Operation(summary = "Obtener plano por ID", description = "Retorna el plano correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano encontrado"),
            @ApiResponse(responseCode = "404", description = "Plano no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> getPlanoById(@PathVariable Integer id) {
        Optional<PlanoDTO> plano = planoService.findById(id);
        return plano.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo plano
    @Operation(summary = "Guardar nuevo plano", description = "Guarda un nuevo plano en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plano creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el plano")
    })
    @PostMapping("/save")
    public ResponseEntity<PlanoDTO> createPlano(@RequestBody PlanoDTO planoDTO) {
        PlanoDTO savedPlano = planoService.save(planoDTO);
        return new ResponseEntity<>(savedPlano, HttpStatus.CREATED);
    }

    // Actualizar un plano existente
    @Operation(summary = "Actualizar plano", description = "Actualiza los datos de un plano existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el plano"),
            @ApiResponse(responseCode = "404", description = "Plano no encontrado")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<PlanoDTO> updatePlano(@PathVariable Integer id, @RequestBody PlanoDTO planoDTO) {
        planoDTO.setIdPlano(id); // Asegurarse de que el ID es el correcto
        PlanoDTO updatedPlano = planoService.update(planoDTO);
        return ResponseEntity.ok(updatedPlano);
    }

    // Eliminar un plano por ID
    @Operation(summary = "Eliminar plano", description = "Elimina el plano correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Plano no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Integer id) {
        planoService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de planos
    @Operation(summary = "Contar planos", description = "Retorna el número total de planos registrados")
    @ApiResponse(responseCode = "200", description = "Número total de planos")
    @GetMapping("/count")
    public ResponseEntity<Long> countPlanos() {
        long count = planoService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
