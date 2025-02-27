package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.OrdenDTO;
import com.metalmaked.metalmaked.persistence.entity.Orden;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    // Mapeo de Orden a OrdenDTO
    OrdenDTO toDto(Orden orden);

    // Mapeo inverso de OrdenDTO a Orden
    Orden toEntity(OrdenDTO ordenDTO);
}
