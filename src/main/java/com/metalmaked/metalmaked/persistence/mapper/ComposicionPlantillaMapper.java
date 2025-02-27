package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.ComposicionPlantillaDTO;
import com.metalmaked.metalmaked.persistence.entity.ComposicionPlantilla;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComposicionPlantillaMapper {

    // Mapeo de ComposicionPlantilla a ComposicionPlantillaDTO
    ComposicionPlantillaDTO toDto(ComposicionPlantilla composicionPlantilla);

    // Mapeo inverso de ComposicionPlantillaDTO a ComposicionPlantilla
    ComposicionPlantilla toEntity(ComposicionPlantillaDTO composicionPlantillaDTO);
}
