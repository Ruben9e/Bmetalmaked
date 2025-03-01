package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;
import com.metalmaked.metalmaked.domain.repository.PersonalizacionPlantillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalizacionPlantillaService {

    @Autowired
    private PersonalizacionPlantillaRepository personalizacionPlantillaRepository;

    // Consultar todas las personalizaciones
    public Iterable<PersonalizacionPlantillaDTO> findAll() {
        return personalizacionPlantillaRepository.findAll();
    }

    // Consultar personalización por ID
    public Optional<PersonalizacionPlantillaDTO> findById(Integer id) {
        return personalizacionPlantillaRepository.findById(id);
    }

    // Guardar una nueva personalización
    public PersonalizacionPlantillaDTO save(PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        return personalizacionPlantillaRepository.save(personalizacionPlantillaDTO);
    }

    // Actualizar una personalización existente
    public PersonalizacionPlantillaDTO update(PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        return personalizacionPlantillaRepository.update(personalizacionPlantillaDTO);
    }

    // Eliminar una personalización
    public void delete(Integer id) {
        personalizacionPlantillaRepository.delete(id);
    }

    // Verificar si existe una personalización por ID
    public boolean existsById(Integer id) {
        return personalizacionPlantillaRepository.existsById(id);
    }

    // Contar el total de personalizaciones registradas
    public long count() {
        return personalizacionPlantillaRepository.count();
    }
}
