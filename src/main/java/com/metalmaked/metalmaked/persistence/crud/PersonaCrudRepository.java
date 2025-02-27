package com.metalmaked.metalmaked.persistence.crud;

import com.metalmaked.metalmaked.persistence.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaCrudRepository extends CrudRepository<Persona, Integer> {
}
