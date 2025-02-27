package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.domain.dto.DetalleOrdenDTO;

import java.util.Optional;

public interface DetalleOrdenRepository {

    Iterable<DetalleOrdenDTO> findAll();

    Optional<DetalleOrdenDTO> findById(Integer id);

    DetalleOrdenDTO save(DetalleOrdenDTO detalleOrdenDTO);

    DetalleOrdenDTO update(DetalleOrdenDTO detalleOrdenDTO);

    void delete(Integer id);

    boolean existsById(Integer id);

    long count();
}
