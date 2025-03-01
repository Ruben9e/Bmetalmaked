package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.RolesDTO;
import com.metalmaked.metalmaked.domain.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    // Consultar todos los registros
    @Operation(summary = "Obtener todos los roles", description = "Retorna una lista de todos los roles registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<RolesDTO>> getAllRoles() {
        Iterable<RolesDTO> roles = rolesService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Consultar por ID
    @Operation(summary = "Obtener rol por ID", description = "Retorna el rol correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol encontrado"),
            @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> getRoleById(@PathVariable Integer id) {
        Optional<RolesDTO> role = rolesService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo rol
    @Operation(summary = "Guardar nuevo rol", description = "Guarda un nuevo rol en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rol creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el rol")
    })
    @PostMapping("/save")
    public ResponseEntity<RolesDTO> createRole(@RequestBody RolesDTO rolesDTO) {
        RolesDTO savedRole = rolesService.save(rolesDTO);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    // Actualizar un rol existente
    @Operation(summary = "Actualizar rol", description = "Actualiza los datos de un rol existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el rol"),
            @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<RolesDTO> updateRole(@PathVariable Integer id, @RequestBody RolesDTO rolesDTO) {
        rolesDTO.setIdRol(id); // Asegurarse de que el ID es el correcto
        RolesDTO updatedRole = rolesService.update(rolesDTO);
        return ResponseEntity.ok(updatedRole);
    }

    // Eliminar un rol por ID
    @Operation(summary = "Eliminar rol", description = "Elimina el rol correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        rolesService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de roles
    @Operation(summary = "Contar roles", description = "Retorna el número total de roles registrados")
    @ApiResponse(responseCode = "200", description = "Número total de roles")
    @GetMapping("/count")
    public ResponseEntity<Long> countRoles() {
        long count = rolesService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
