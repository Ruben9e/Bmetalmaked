package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.PersonaDTO;
import com.metalmaked.metalmaked.domain.repository.PersonaRepository;
import com.metalmaked.metalmaked.persistence.crud.PersonaCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Persona;
import com.metalmaked.metalmaked.persistence.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public Iterable<PersonaDTO> findAll() {
        List<Persona> personaList = (List<Persona>) personaCrudRepository.findAll();
        return personaList.stream().map(personaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PersonaDTO> findById(Integer id) {
        return personaCrudRepository.findById(id).map(personaMapper::toDto);
    }

    @Override
    public PersonaDTO save(PersonaDTO personaDTO) {
        Persona persona = personaMapper.toEntity(personaDTO);
        Persona savedPersona = personaCrudRepository.save(persona);
        return personaMapper.toDto(savedPersona);
    }

    @Override
    public PersonaDTO update(PersonaDTO personaDTO) {
        if (existsById(personaDTO.getIdPersona())) {
            Persona persona = personaMapper.toEntity(personaDTO);
            Persona updatedPersona = personaCrudRepository.save(persona);
            return personaMapper.toDto(updatedPersona);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            personaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return personaCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return personaCrudRepository.count();
    }
}
