package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.ComposicionPlantillaDTO;
import com.metalmaked.metalmaked.persistence.entity.ComposicionPlantilla;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComposicionPlantillaMapper {

    @Mapping(source = "plantilla.idPlantilla", target = "idPlantilla") // Ajustado
    @Mapping(source = "material.idMaterial", target = "idMaterial") // Ajustado
    ComposicionPlantillaDTO toDto(ComposicionPlantilla composicionPlantilla);

    @Mapping(source = "idPlantilla", target = "plantilla.idPlantilla") // Ajustado
    @Mapping(source = "idMaterial", target = "material.idMaterial") // Ajustado
    ComposicionPlantilla toEntity(ComposicionPlantillaDTO composicionPlantillaDTO);
}