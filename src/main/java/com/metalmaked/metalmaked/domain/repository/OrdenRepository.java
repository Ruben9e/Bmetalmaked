package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.OrdenDTO;

import java.util.Optional;

public interface OrdenRepository {

    Iterable<OrdenDTO> findAll();

    Optional<OrdenDTO> findById(Integer id);

    OrdenDTO save(OrdenDTO ordenDTO);

    OrdenDTO update(OrdenDTO ordenDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
