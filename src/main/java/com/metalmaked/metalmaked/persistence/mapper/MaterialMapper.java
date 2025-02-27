package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.MaterialDTO;
import com.metalmaked.metalmaked.persistence.entity.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    // Mapeo de Material a MaterialDTO
    MaterialDTO toDto(Material material);

    // Mapeo inverso de MaterialDTO a Material
    Material toEntity(MaterialDTO materialDTO);
}
