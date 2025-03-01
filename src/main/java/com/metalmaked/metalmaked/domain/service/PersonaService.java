package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.PersonaDTO;
import com.metalmaked.metalmaked.domain.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Obtener todas las personas
    public Iterable<PersonaDTO> findAll() {
        return personaRepository.findAll();
    }

    // Obtener una persona por ID
    public Optional<PersonaDTO> findById(Integer id) {
        return personaRepository.findById(id);
    }

    // Guardar una nueva persona
    public PersonaDTO save(PersonaDTO personaDTO) {
        return personaRepository.save(personaDTO);
    }

    // Actualizar una persona existente
    public PersonaDTO update(PersonaDTO personaDTO) {
        return personaRepository.update(personaDTO);
    }

    // Eliminar una persona por ID
    public void delete(Integer id) {
        personaRepository.delete(id);
    }

    // Verificar si una persona existe por ID
    public boolean existsById(Integer id) {
        return personaRepository.existsById(id);
    }

    // Contar el número total de personas registradas
    public long count() {
        return personaRepository.count();
    }
}
