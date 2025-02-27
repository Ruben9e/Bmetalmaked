package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.RolesDTO;

import java.util.Optional;

public interface RolesRepository {

    Iterable<RolesDTO> findAll();

    Optional<RolesDTO> findById(Integer id);

    RolesDTO save(RolesDTO rolesDTO);

    RolesDTO update(RolesDTO rolesDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
