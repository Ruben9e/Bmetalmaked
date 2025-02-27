package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.MaterialDTO;

import java.util.Optional;

public interface MaterialRepository {

    Iterable<MaterialDTO> findAll();

    Optional<MaterialDTO> findById(Integer id);

    MaterialDTO save(MaterialDTO materialDTO);

    MaterialDTO update(MaterialDTO materialDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
