package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;
import com.metalmaked.metalmaked.domain.service.PersonalizacionPlantillaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/personalizacion-plantilla")
public class PersonalizacionPlantillaController {

    @Autowired
    private PersonalizacionPlantillaService personalizacionPlantillaService;

    // Obtener todas las personalizaciones
    @Operation(summary = "Obtener todas las personalizaciones", description = "Retorna una lista de todas las personalizaciones registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de personalizaciones obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<PersonalizacionPlantillaDTO>> getAllPersonalizaciones() {
        Iterable<PersonalizacionPlantillaDTO> personalizaciones = personalizacionPlantillaService.findAll();
        return new ResponseEntity<>(personalizaciones, HttpStatus.OK);
    }

    // Obtener personalización por ID
    @Operation(summary = "Obtener personalización por ID", description = "Retorna la personalización correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalización encontrada"),
            @ApiResponse(responseCode = "404", description = "Personalización no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonalizacionPlantillaDTO> getPersonalizacionById(@PathVariable Integer id) {
        Optional<PersonalizacionPlantillaDTO> personalizacion = personalizacionPlantillaService.findById(id);
        return personalizacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva personalización
    @Operation(summary = "Guardar nueva personalización", description = "Guarda una nueva personalización en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Personalización creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la personalización")
    })
    @PostMapping("/save")
    public ResponseEntity<PersonalizacionPlantillaDTO> createPersonalizacion(@RequestBody PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        PersonalizacionPlantillaDTO savedPersonalizacion = personalizacionPlantillaService.save(personalizacionPlantillaDTO);
        return new ResponseEntity<>(savedPersonalizacion, HttpStatus.CREATED);
    }

    // Actualizar una personalización existente
    @Operation(summary = "Actualizar personalización", description = "Actualiza los datos de una personalización existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalización actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la personalización"),
            @ApiResponse(responseCode = "404", description = "Personalización no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonalizacionPlantillaDTO> updatePersonalizacion(@PathVariable Integer id, @RequestBody PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        personalizacionPlantillaDTO.setIdPersona(id); // Asegurar que el ID es correcto
        PersonalizacionPlantillaDTO updatedPersonalizacion = personalizacionPlantillaService.update(personalizacionPlantillaDTO);
        return ResponseEntity.ok(updatedPersonalizacion);
    }

    // Eliminar una personalización por ID
    @Operation(summary = "Eliminar personalización", description = "Elimina la personalización correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalización eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Personalización no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonalizacion(@PathVariable Integer id) {
        personalizacionPlantillaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de personalizaciones
    @Operation(summary = "Contar personalizaciones", description = "Retorna el número total de personalizaciones registradas")
    @ApiResponse(responseCode = "200", description = "Número total de personalizaciones")
    @GetMapping("/count")
    public ResponseEntity<Long> countPersonalizaciones() {
        long count = personalizacionPlantillaService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
