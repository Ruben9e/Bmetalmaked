package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.DetalleOrdenDTO;
import com.metalmaked.metalmaked.persistence.entity.DetalleOrden;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleOrdenMapper {

    // Mapeo de DetalleOrden a DetalleOrdenDTO
    DetalleOrdenDTO toDto(DetalleOrden detalleOrden);

    // Mapeo inverso de DetalleOrdenDTO a DetalleOrden
    DetalleOrden toEntity(DetalleOrdenDTO detalleOrdenDTO);
}
