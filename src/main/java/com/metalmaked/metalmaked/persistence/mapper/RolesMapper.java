package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.RolesDTO;
import com.metalmaked.metalmaked.persistence.entity.Roles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    // Mapeo de Roles a RolesDTO
    RolesDTO toDto(Roles roles);

    // Mapeo inverso de RolesDTO a Roles
    Roles toEntity(RolesDTO rolesDTO);
}
