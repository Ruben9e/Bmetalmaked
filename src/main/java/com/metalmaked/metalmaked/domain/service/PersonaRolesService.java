package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.PersonaRolesDTO;
import com.metalmaked.metalmaked.domain.repository.PersonaRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaRolesService {

    @Autowired
    private PersonaRolesRepository personaRolesRepository;

    // Consultar todos los registros
    public Iterable<PersonaRolesDTO> findAll() {
        return personaRolesRepository.findAll();
    }

    // Consultar por ID
    public Optional<PersonaRolesDTO> findById(Integer id) {
        return personaRolesRepository.findById(id);
    }

    // Guardar un registro
    public PersonaRolesDTO save(PersonaRolesDTO personaRolesDTO) {
        return personaRolesRepository.save(personaRolesDTO);
    }

    // Actualizar un registro
    public PersonaRolesDTO update(PersonaRolesDTO personaRolesDTO) {
        return personaRolesRepository.update(personaRolesDTO);
    }

    // Eliminar un registro
    public void delete(Integer id) {
        personaRolesRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return personaRolesRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return personaRolesRepository.count();
    }
}
