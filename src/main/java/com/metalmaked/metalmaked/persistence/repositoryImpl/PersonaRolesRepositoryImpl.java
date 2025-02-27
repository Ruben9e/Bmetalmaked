package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.PersonaRolesDTO;
import com.metalmaked.metalmaked.domain.repository.PersonaRepository;
import com.metalmaked.metalmaked.persistence.crud.PersonaRolesCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.PersonaRoles;
import com.metalmaked.metalmaked.persistence.mapper.PersonaRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonaRolesRepositoryImpl implements PersonaRepository {

    @Autowired
    private PersonaRolesCrudRepository personaRolesCrudRepository;

    @Autowired
    private PersonaRolesMapper personaRolesMapper;

    @Override
    public Iterable<PersonaRolesDTO> findAll() {
        List<PersonaRoles> personaRolesList = (List<PersonaRoles>) personaRolesCrudRepository.findAll();
        return personaRolesList.stream().map(personaRolesMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PersonaRolesDTO> findById(Integer id) {
        return personaRolesCrudRepository.findById(id).map(personaRolesMapper::toDto);
    }

    @Override
    public PersonaRolesDTO save(PersonaRolesDTO personaRolesDTO) {
        PersonaRoles personaRoles = personaRolesMapper.toEntity(personaRolesDTO);
        PersonaRoles savedPersonaRoles = personaRolesCrudRepository.save(personaRoles);
        return personaRolesMapper.toDto(savedPersonaRoles);
    }

    @Override
    public PersonaRolesDTO update(PersonaRolesDTO personaRolesDTO) {
        if (existsById(personaRolesDTO.getIdPersona())) {
            PersonaRoles personaRoles = personaRolesMapper.toEntity(personaRolesDTO);
            PersonaRoles updatedPersonaRoles = personaRolesCrudRepository.save(personaRoles);
            return personaRolesMapper.toDto(updatedPersonaRoles);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            personaRolesCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return personaRolesCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return personaRolesCrudRepository.count();
    }
}
