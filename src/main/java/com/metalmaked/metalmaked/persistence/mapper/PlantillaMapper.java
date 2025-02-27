package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PlantillaDTO;
import com.metalmaked.metalmaked.persistence.entity.Plantilla;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantillaMapper {

    // Mapeo de Plantilla a PlantillaDTO
    PlantillaDTO toDto(Plantilla plantilla);

    // Mapeo inverso de PlantillaDTO a Plantilla
    Plantilla toEntity(PlantillaDTO plantillaDTO);
}
