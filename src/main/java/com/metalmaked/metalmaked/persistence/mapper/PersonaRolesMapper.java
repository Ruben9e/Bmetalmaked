package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PersonaRolesDTO;
import com.metalmaked.metalmaked.persistence.entity.PersonaRoles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaRolesMapper {
    PersonaRolesDTO toDto(PersonaRoles personaRoles);
    PersonaRoles toEntity(PersonaRolesDTO personaRolesDTO);
}