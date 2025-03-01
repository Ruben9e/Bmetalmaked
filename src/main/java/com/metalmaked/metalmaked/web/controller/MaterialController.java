package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.MaterialDTO;
import com.metalmaked.metalmaked.domain.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    // Consultar todos los materiales
    @Operation(summary = "Obtener todos los materiales", description = "Retorna una lista de todos los materiales registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de materiales obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<MaterialDTO>> getAllMaterials() {
        Iterable<MaterialDTO> materiales = materialService.findAll();
        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }

    // Consultar por ID
    @Operation(summary = "Obtener material por ID", description = "Retorna el material correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material encontrado"),
            @ApiResponse(responseCode = "404", description = "Material no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> getMaterialById(@PathVariable Integer id) {
        Optional<MaterialDTO> material = materialService.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo material
    @Operation(summary = "Guardar nuevo material", description = "Guarda un nuevo material en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Material creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el material")
    })
    @PostMapping("/save")
    public ResponseEntity<MaterialDTO> createMaterial(@RequestBody MaterialDTO materialDTO) {
        MaterialDTO savedMaterial = materialService.save(materialDTO);
        return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
    }

    // Actualizar un material existente
    @Operation(summary = "Actualizar material", description = "Actualiza los datos de un material existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el material"),
            @ApiResponse(responseCode = "404", description = "Material no encontrado")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<MaterialDTO> updateMaterial(@PathVariable Integer id, @RequestBody MaterialDTO materialDTO) {
        materialDTO.setIdMaterial(id); // Asegurar que el ID es el correcto
        MaterialDTO updatedMaterial = materialService.update(materialDTO);
        return ResponseEntity.ok(updatedMaterial);
    }

    // Eliminar un material por ID
    @Operation(summary = "Eliminar material", description = "Elimina el material correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Material no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Integer id) {
        materialService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de materiales
    @Operation(summary = "Contar materiales", description = "Retorna el número total de materiales registrados")
    @ApiResponse(responseCode = "200", description = "Número total de materiales")
    @GetMapping("/count")
    public ResponseEntity<Long> countMaterials() {
        long count = materialService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
