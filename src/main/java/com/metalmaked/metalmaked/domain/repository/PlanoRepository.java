package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.PlanoDTO;

import java.util.Optional;

public interface PlanoRepository {

    Iterable<PlanoDTO> findAll();

    Optional<PlanoDTO> findById(Integer id);

    PlanoDTO save(PlanoDTO planoDTO);

    PlanoDTO update(PlanoDTO planoDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
