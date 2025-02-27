package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.ComposicionPlantillaDTO;

import java.util.Optional;

public interface ComposicionPlantillaRepository {

    Iterable<ComposicionPlantillaDTO> findAll();

    Optional<ComposicionPlantillaDTO> findById(Integer id);

    ComposicionPlantillaDTO save(ComposicionPlantillaDTO composicionPlantillaDTO);

    ComposicionPlantillaDTO update(ComposicionPlantillaDTO composicionPlantillaDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
