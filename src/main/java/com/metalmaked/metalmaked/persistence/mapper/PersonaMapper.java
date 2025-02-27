package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PersonaDTO;
import com.metalmaked.metalmaked.persistence.entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    // Mapeo de Persona a PersonaDTO
    PersonaDTO toDto(Persona persona);

    // Mapeo inverso de PersonaDTO a Persona
    Persona toEntity(PersonaDTO personaDTO);

    // Métodos para listas
    List<PersonaDTO> toDtoList(List<Persona> personas);
    List<Persona> toEntityList(List<PersonaDTO> personaDTOs);
}
