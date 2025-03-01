package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.PersonaRolesDTO;
import com.metalmaked.metalmaked.domain.service.PersonaRolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/persona-roles")
public class PersonaRolesController {

    @Autowired
    private PersonaRolesService personaRolesService;

    // Obtener todos los registros
    @Operation(summary = "Obtener todas las relaciones Persona-Rol", description = "Retorna una lista de todas las relaciones persona-rol registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<PersonaRolesDTO>> getAllPersonaRoles() {
        Iterable<PersonaRolesDTO> personaRoles = personaRolesService.findAll();
        return new ResponseEntity<>(personaRoles, HttpStatus.OK);
    }

    // Obtener por ID
    @Operation(summary = "Obtener una relación Persona-Rol por ID", description = "Retorna la relación persona-rol correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación encontrada"),
            @ApiResponse(responseCode = "404", description = "Relación no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonaRolesDTO> getPersonaRolById(@PathVariable Integer id) {
        Optional<PersonaRolesDTO> personaRol = personaRolesService.findById(id);
        return personaRol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una nueva relación
    @Operation(summary = "Guardar nueva relación Persona-Rol", description = "Guarda una nueva relación persona-rol en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relación creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la relación")
    })
    @PostMapping("/save")
    public ResponseEntity<PersonaRolesDTO> createPersonaRol(@RequestBody PersonaRolesDTO personaRolesDTO) {
        PersonaRolesDTO savedPersonaRol = personaRolesService.save(personaRolesDTO);
        return new ResponseEntity<>(savedPersonaRol, HttpStatus.CREATED);
    }

    // Actualizar una relación existente
    @Operation(summary = "Actualizar relación Persona-Rol", description = "Actualiza los datos de una relación persona-rol existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la relación"),
            @ApiResponse(responseCode = "404", description = "Relación no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaRolesDTO> updatePersonaRol(@PathVariable Integer id, @RequestBody PersonaRolesDTO personaRolesDTO) {
        PersonaRolesDTO updatedPersonaRol = personaRolesService.update(personaRolesDTO);
        return ResponseEntity.ok(updatedPersonaRol);
    }

    // Eliminar una relación por ID
    @Operation(summary = "Eliminar relación Persona-Rol", description = "Elimina la relación persona-rol correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Relación no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonaRol(@PathVariable Integer id) {
        personaRolesService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de relaciones
    @Operation(summary = "Contar relaciones Persona-Rol", description = "Retorna el número total de relaciones persona-rol registradas")
    @ApiResponse(responseCode = "200", description = "Número total de relaciones")
    @GetMapping("/count")
    public ResponseEntity<Long> countPersonaRoles() {
        long count = personaRolesService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
