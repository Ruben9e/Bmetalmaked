package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.PersonaDTO;
import com.metalmaked.metalmaked.domain.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // Obtener todas las personas
    @Operation(summary = "Obtener todas las personas", description = "Retorna una lista de todas las personas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de personas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<PersonaDTO>> getAllPersonas() {
        Iterable<PersonaDTO> personas = personaService.findAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    // Obtener persona por ID
    @Operation(summary = "Obtener persona por ID", description = "Retorna la persona correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona encontrada"),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersonaById(@PathVariable Integer id) {
        Optional<PersonaDTO> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva persona
    @Operation(summary = "Guardar nueva persona", description = "Guarda una nueva persona en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Persona creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la persona")
    })
    @PostMapping("/save")
    public ResponseEntity<PersonaDTO> createPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO savedPersona = personaService.save(personaDTO);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }

    // Actualizar una persona existente
    @Operation(summary = "Actualizar persona", description = "Actualiza los datos de una persona existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la persona"),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) {
        personaDTO.setIdPersona(id); // Asegurar que el ID es correcto
        PersonaDTO updatedPersona = personaService.update(personaDTO);
        return ResponseEntity.ok(updatedPersona);
    }

    // Eliminar una persona por ID
    @Operation(summary = "Eliminar persona", description = "Elimina la persona correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de personas
    @Operation(summary = "Contar personas", description = "Retorna el número total de personas registradas")
    @ApiResponse(responseCode = "200", description = "Número total de personas")
    @GetMapping("/count")
    public ResponseEntity<Long> countPersonas() {
        long count = personaService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
