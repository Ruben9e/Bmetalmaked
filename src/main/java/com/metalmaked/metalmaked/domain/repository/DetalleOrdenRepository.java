
package com.metalmaked.metalmaked.domain.repository;

import com.metalmaked.metalmaked.persistence.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {
}

