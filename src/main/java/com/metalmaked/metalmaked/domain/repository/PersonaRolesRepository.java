package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.PersonaRolesDTO;

import java.util.Optional;

public interface PersonaRolesRepository {

    Iterable<PersonaRolesDTO> findAll();

    Optional<PersonaRolesDTO> findById(Integer id);

    PersonaRolesDTO save(PersonaRolesDTO personaRolesDTO);

    PersonaRolesDTO update(PersonaRolesDTO personaRolesDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
