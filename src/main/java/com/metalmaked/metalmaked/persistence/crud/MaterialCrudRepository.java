package com.metalmaked.metalmaked.persistence.crud;

import com.metalmaked.metalmaked.persistence.entity.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialCrudRepository extends CrudRepository<Material, Integer> {
}
