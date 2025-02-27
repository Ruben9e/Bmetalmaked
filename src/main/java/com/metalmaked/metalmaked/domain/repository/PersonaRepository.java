package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.PersonaDTO;

import java.util.Optional;

public interface PersonaRepository {

    Iterable<PersonaDTO> findAll();

    Optional<PersonaDTO> findById(Integer id);

    PersonaDTO save(PersonaDTO personaRolesDTO);

    PersonaDTO update(PersonaDTO personaDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
