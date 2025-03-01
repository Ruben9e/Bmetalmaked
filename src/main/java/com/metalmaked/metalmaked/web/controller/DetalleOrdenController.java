package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.DetalleOrdenDTO;
import com.metalmaked.metalmaked.domain.service.DetalleOrdenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-orden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    // Consultar todos los detalles de órdenes
    @Operation(summary = "Obtener todos los detalles de órdenes", description = "Retorna una lista de todos los detalles de órdenes registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de detalles obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<DetalleOrdenDTO>> getAllDetalles() {
        Iterable<DetalleOrdenDTO> detalles = detalleOrdenService.findAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    // Consultar detalle de orden por ID
    @Operation(summary = "Obtener detalle de orden por ID", description = "Retorna el detalle correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalle de orden encontrado"),
            @ApiResponse(responseCode = "404", description = "Detalle de orden no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenDTO> getDetalleById(@PathVariable Integer id) {
        Optional<DetalleOrdenDTO> detalle = detalleOrdenService.findById(id);
        return detalle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo detalle de orden
    @Operation(summary = "Guardar nuevo detalle de orden", description = "Guarda un nuevo detalle de orden en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Detalle de orden creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el detalle de orden")
    })
    @PostMapping("/save")
    public ResponseEntity<DetalleOrdenDTO> createDetalle(@RequestBody DetalleOrdenDTO detalleOrdenDTO) {
        DetalleOrdenDTO savedDetalle = detalleOrdenService.save(detalleOrdenDTO);
        return new ResponseEntity<>(savedDetalle, HttpStatus.CREATED);
    }

    // Actualizar un detalle de orden existente
    @Operation(summary = "Actualizar detalle de orden", description = "Actualiza los datos de un detalle de orden existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalle de orden actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el detalle de orden"),
            @ApiResponse(responseCode = "404", description = "Detalle de orden no encontrado")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<DetalleOrdenDTO> updateDetalle(@PathVariable Integer id, @RequestBody DetalleOrdenDTO detalleOrdenDTO) {
        detalleOrdenDTO.setIdDetalle(id);
        DetalleOrdenDTO updatedDetalle = detalleOrdenService.update(detalleOrdenDTO);
        return ResponseEntity.ok(updatedDetalle);
    }

    // Eliminar un detalle de orden por ID
    @Operation(summary = "Eliminar detalle de orden", description = "Elimina el detalle de orden correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalle de orden eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Detalle de orden no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Integer id) {
        detalleOrdenService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de detalles de órdenes
    @Operation(summary = "Contar detalles de órdenes", description = "Retorna el número total de detalles de órdenes registrados")
    @ApiResponse(responseCode = "200", description = "Número total de detalles de órdenes")
    @GetMapping("/count")
    public ResponseEntity<Long> countDetalles() {
        long count = detalleOrdenService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
