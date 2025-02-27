package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;
import com.metalmaked.metalmaked.persistence.entity.PersonalizacionPlantilla;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonalizacionPlantillaMapper {

    // Mapeo de PersonalizacionPlantilla a PersonalizacionPlantillaDTO
    PersonalizacionPlantillaDTO toDto(PersonalizacionPlantilla personalizacionPlantilla);

    // Mapeo inverso de PersonalizacionPlantillaDTO a PersonalizacionPlantilla
    PersonalizacionPlantilla toEntity(PersonalizacionPlantillaDTO personalizacionPlantillaDTO);
}
