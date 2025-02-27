package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;

import java.util.Optional;

public interface PersonalizacionPlantillaRepository {

    Iterable<PersonalizacionPlantillaDTO> findAll();

    Optional<PersonalizacionPlantillaDTO> findById(Integer id);

    PersonalizacionPlantillaDTO save(PersonalizacionPlantillaDTO personalizacionPlantillaDTO);

    PersonalizacionPlantillaDTO update(PersonalizacionPlantillaDTO personalizacionPlantillaDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
