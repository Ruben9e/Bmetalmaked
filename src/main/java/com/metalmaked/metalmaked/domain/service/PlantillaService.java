package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.PlantillaDTO;
import com.metalmaked.metalmaked.domain.repository.PlantillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantillaService {

    @Autowired
    private PlantillaRepository plantillaRepository;

    // Consultar todos los registros
    public Iterable<PlantillaDTO> findAll() {
        return plantillaRepository.findAll();
    }

    // Consultar por ID
    public Optional<PlantillaDTO> findById(Integer id) {
        return plantillaRepository.findById(id);
    }

    // Guardar una nueva plantilla
    public PlantillaDTO save(PlantillaDTO plantillaDTO) {
        return plantillaRepository.save(plantillaDTO);
    }

    // Actualizar una plantilla existente
    public PlantillaDTO update(PlantillaDTO plantillaDTO) {
        return plantillaRepository.update(plantillaDTO);
    }

    // Eliminar una plantilla por ID
    public void delete(Integer id) {
        plantillaRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return plantillaRepository.existsById(id);
    }

    // Contar el número total de plantillas
    public long count() {
        return plantillaRepository.count();
    }
}
