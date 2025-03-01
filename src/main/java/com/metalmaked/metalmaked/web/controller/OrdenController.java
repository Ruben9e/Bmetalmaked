package com.metalmaked.metalmaked.web.controller;

import com.metalmaked.metalmaked.domain.dto.OrdenDTO;
import com.metalmaked.metalmaked.domain.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orden")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<OrdenDTO>> getAllOrdenes() {
        return ResponseEntity.ok(ordenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDTO> getOrdenById(@PathVariable Integer id) {
        Optional<OrdenDTO> orden = ordenService.findById(id);
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<OrdenDTO> createOrden(@RequestBody OrdenDTO ordenDTO) {
        return ResponseEntity.ok(ordenService.save(ordenDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrdenDTO> updateOrden(@PathVariable Integer id, @RequestBody OrdenDTO ordenDTO) {
        ordenDTO.setIdOrden(id);
        return ResponseEntity.ok(ordenService.update(ordenDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Integer id) {
        ordenService.delete(id);
        return ResponseEntity.ok().build();
    }
}
