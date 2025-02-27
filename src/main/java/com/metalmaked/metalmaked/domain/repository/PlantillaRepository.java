package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.PlantillaDTO;

import java.util.Optional;

public interface PlantillaRepository {

    Iterable<PlantillaDTO> findAll();

    Optional<PlantillaDTO> findById(Integer id);

    PlantillaDTO save(PlantillaDTO plantillaDTO);

    PlantillaDTO update(PlantillaDTO plantillaDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
