package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PersonalizacionPlantillaDTO;
import com.metalmaked.metalmaked.persistence.entity.PersonalizacionPlantilla;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalizacionPlantillaMapper {

    @Mapping(source = "persona.idPersona", target = "idPersona")
    @Mapping(source = "plantilla.idPlantilla", target = "idPlantilla")
    @Mapping(source = "diseño", target = "diseno") // Asegura la conversión
    PersonalizacionPlantillaDTO toDto(PersonalizacionPlantilla personalizacionPlantilla);

    @Mapping(source = "idPersona", target = "persona.idPersona")
    @Mapping(source = "idPlantilla", target = "plantilla.idPlantilla")
    @Mapping(source = "diseno", target = "diseño") // Asegura la conversión
    PersonalizacionPlantilla toEntity(PersonalizacionPlantillaDTO personalizacionPlantillaDTO);
}
