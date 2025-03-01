package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;
import com.metalmaked.metalmaked.domain.service.EnvioPlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/envios-planos")
public class EnvioPlanoController {

    @Autowired
    private EnvioPlanoService envioPlanoService;

    // Consultar todos los envíos de planos
    @Operation(summary = "Obtener todos los envíos de planos", description = "Retorna una lista de todos los envíos de planos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de envíos obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<EnvioPlanoDTO>> getAllEnvios() {
        Iterable<EnvioPlanoDTO> envios = envioPlanoService.findAll();
        return new ResponseEntity<>(envios, HttpStatus.OK);
    }

    // Consultar por ID de orden y plano
    @Operation(summary = "Obtener envío de plano por ID de orden y plano", description = "Retorna el envío correspondiente al ID de orden y plano proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío de plano encontrado"),
            @ApiResponse(responseCode = "404", description = "Envío de plano no encontrado")
    })
    @GetMapping("/{idOrden}/{idPlano}")
    public ResponseEntity<EnvioPlanoDTO> getEnvioById(@PathVariable Integer idOrden, @PathVariable Integer idPlano) {
        Optional<EnvioPlanoDTO> envioPlano = envioPlanoService.findById(idOrden, idPlano);
        return envioPlano.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo envío de plano
    @Operation(summary = "Guardar nuevo envío de plano", description = "Guarda un nuevo envío de plano en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Envío de plano creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el envío de plano")
    })
    @PostMapping("/save")
    public ResponseEntity<EnvioPlanoDTO> createEnvio(@RequestBody EnvioPlanoDTO envioPlanoDTO) {
        EnvioPlanoDTO savedEnvio = envioPlanoService.save(envioPlanoDTO);
        return new ResponseEntity<>(savedEnvio, HttpStatus.CREATED);
    }

    // Actualizar un envío de plano existente
    @Operation(summary = "Actualizar envío de plano", description = "Actualiza los datos de un envío de plano existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío de plano actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el envío de plano"),
            @ApiResponse(responseCode = "404", description = "Envío de plano no encontrado")
    })
    @PutMapping("/update/{idOrden}/{idPlano}")
    public ResponseEntity<EnvioPlanoDTO> updateEnvio(@PathVariable Integer idOrden, @PathVariable Integer idPlano, @RequestBody EnvioPlanoDTO envioPlanoDTO) {
        envioPlanoDTO.setIdOrden(idOrden);
        envioPlanoDTO.setIdPlano(idPlano);
        EnvioPlanoDTO updatedEnvio = envioPlanoService.update(envioPlanoDTO);
        return ResponseEntity.ok(updatedEnvio);
    }

    // Eliminar un envío de plano por ID de orden y plano
    @Operation(summary = "Eliminar envío de plano", description = "Elimina el envío de plano correspondiente al ID de orden y plano proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío de plano eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Envío de plano no encontrado")
    })
    @DeleteMapping("/delete/{idOrden}/{idPlano}")
    public ResponseEntity<Void> deleteEnvio(@PathVariable Integer idOrden, @PathVariable Integer idPlano) {
        envioPlanoService.delete(idOrden, idPlano);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de envíos de planos
    @Operation(summary = "Contar envíos de planos", description = "Retorna el número total de envíos de planos registrados")
    @ApiResponse(responseCode = "200", description = "Número total de envíos de planos")
    @GetMapping("/count")
    public ResponseEntity<Long> countEnvios() {
        long count = envioPlanoService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
