package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;
import com.metalmaked.metalmaked.domain.repository.PersonalizacionPlantillaRepository;
import com.metalmaked.metalmaked.persistence.crud.PersonalizacionPlantillaCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.PersonalizacionPlantilla;
import com.metalmaked.metalmaked.persistence.mapper.PersonalizacionPlantillaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonalizacionPlantillaRepositoryImpl implements PersonalizacionPlantillaRepository {

    @Autowired
    private PersonalizacionPlantillaCrudRepository personalizacionPlantillaCrudRepository;

    @Autowired
    private PersonalizacionPlantillaMapper personalizacionPlantillaMapper;

    @Override
    public Iterable<PersonalizacionPlantillaDTO> findAll() {
        List<PersonalizacionPlantilla> personalizacionPlantillaList = (List<PersonalizacionPlantilla>) personalizacionPlantillaCrudRepository.findAll();
        return personalizacionPlantillaList.stream().map(personalizacionPlantillaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PersonalizacionPlantillaDTO> findById(Integer id) {
        return personalizacionPlantillaCrudRepository.findById(id).map(personalizacionPlantillaMapper::toDto);
    }

    @Override
    public PersonalizacionPlantillaDTO save(PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        PersonalizacionPlantilla personalizacionPlantilla = personalizacionPlantillaMapper.toEntity(personalizacionPlantillaDTO);
        PersonalizacionPlantilla savedPersonalizacionPlantilla = personalizacionPlantillaCrudRepository.save(personalizacionPlantilla);
        return personalizacionPlantillaMapper.toDto(savedPersonalizacionPlantilla);
    }

    @Override
    public PersonalizacionPlantillaDTO update(PersonalizacionPlantillaDTO personalizacionPlantillaDTO) {
        if (existsById(personalizacionPlantillaDTO.getIdPersona())) {
            PersonalizacionPlantilla personalizacionPlantilla = personalizacionPlantillaMapper.toEntity(personalizacionPlantillaDTO);
            PersonalizacionPlantilla updatedPersonalizacionPlantilla = personalizacionPlantillaCrudRepository.save(personalizacionPlantilla);
            return personalizacionPlantillaMapper.toDto(updatedPersonalizacionPlantilla);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            personalizacionPlantillaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return personalizacionPlantillaCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return personalizacionPlantillaCrudRepository.count();
    }
}
