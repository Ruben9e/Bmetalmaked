package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;

import java.util.Optional;

public interface EnvioPlanoRepository {

    Iterable<EnvioPlanoDTO> findAll();

    Optional<EnvioPlanoDTO> findById(Integer id);

    EnvioPlanoDTO save(EnvioPlanoDTO envioPlanoDTO);

    EnvioPlanoDTO update(EnvioPlanoDTO envioPlanoDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
