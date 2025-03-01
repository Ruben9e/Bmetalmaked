package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;

import java.util.Optional;

public interface EnvioPlanoRepository {

    Iterable<EnvioPlanoDTO> findAll();

    Optional<EnvioPlanoDTO> findById(Integer id, Integer idPlano);

    EnvioPlanoDTO save(EnvioPlanoDTO envioPlanoDTO);

    EnvioPlanoDTO update(EnvioPlanoDTO envioPlanoDTO);

    void delete(Integer id, Integer idPlano);

    boolean existsById(Integer idOrden, Integer id);

    long count();
}
