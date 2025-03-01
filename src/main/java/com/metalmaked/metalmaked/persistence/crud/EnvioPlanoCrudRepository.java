package com.metalmaked.metalmaked.persistence.crud;

import com.metalmaked.metalmaked.persistence.entity.EnvioPlano;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EnvioPlanoCrudRepository extends CrudRepository<EnvioPlano, Integer> {

    // Buscar por idOrden e idPlano
    Optional<EnvioPlano> findByIdOrdenAndIdPlano(Integer idOrden, Integer idPlano);

    // Eliminar por idOrden e idPlano
    void deleteByIdOrdenAndIdPlano(Integer idOrden, Integer idPlano);

    // Verificar si existe
    boolean existsByIdOrdenAndIdPlano(Integer idOrden, Integer idPlano);
}
