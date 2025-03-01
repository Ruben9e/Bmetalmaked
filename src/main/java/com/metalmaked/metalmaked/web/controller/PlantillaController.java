package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.PlantillaDTO;
import com.metalmaked.metalmaked.domain.service.PlantillaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/plantillas")
public class PlantillaController {

    @Autowired
    private PlantillaService plantillaService;

    // Consultar todas las plantillas
    @Operation(summary = "Obtener todas las plantillas", description = "Retorna una lista de todas las plantillas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de plantillas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<PlantillaDTO>> getAllPlantillas() {
        Iterable<PlantillaDTO> plantillas = plantillaService.findAll();
        return new ResponseEntity<>(plantillas, HttpStatus.OK);
    }

    // Consultar plantilla por ID
    @Operation(summary = "Obtener plantilla por ID", description = "Retorna la plantilla correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plantilla encontrada"),
            @ApiResponse(responseCode = "404", description = "Plantilla no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlantillaDTO> getPlantillaById(@PathVariable Integer id) {
        Optional<PlantillaDTO> plantilla = plantillaService.findById(id);
        return plantilla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una nueva plantilla
    @Operation(summary = "Guardar nueva plantilla", description = "Guarda una nueva plantilla en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plantilla creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la plantilla")
    })
    @PostMapping("/save")
    public ResponseEntity<PlantillaDTO> createPlantilla(@RequestBody PlantillaDTO plantillaDTO) {
        PlantillaDTO savedPlantilla = plantillaService.save(plantillaDTO);
        return new ResponseEntity<>(savedPlantilla, HttpStatus.CREATED);
    }

    // Actualizar una plantilla existente
    @Operation(summary = "Actualizar plantilla", description = "Actualiza los datos de una plantilla existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plantilla actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la plantilla"),
            @ApiResponse(responseCode = "404", description = "Plantilla no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<PlantillaDTO> updatePlantilla(@PathVariable Integer id, @RequestBody PlantillaDTO plantillaDTO) {
        plantillaDTO.setIdPlantilla(id); // Asegurarse de que el ID es el correcto
        PlantillaDTO updatedPlantilla = plantillaService.update(plantillaDTO);
        return ResponseEntity.ok(updatedPlantilla);
    }

    // Eliminar una plantilla por ID
    @Operation(summary = "Eliminar plantilla", description = "Elimina la plantilla correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plantilla eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Plantilla no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlantilla(@PathVariable Integer id) {
        plantillaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de plantillas
    @Operation(summary = "Contar plantillas", description = "Retorna el número total de plantillas registradas")
    @ApiResponse(responseCode = "200", description = "Número total de plantillas")
    @GetMapping("/count")
    public ResponseEntity<Long> countPlantillas() {
        long count = plantillaService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
