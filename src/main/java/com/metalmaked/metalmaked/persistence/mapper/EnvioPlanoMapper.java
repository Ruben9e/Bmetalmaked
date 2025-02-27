package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;
import com.metalmaked.metalmaked.persistence.entity.EnvioPlano;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnvioPlanoMapper {
    EnvioPlanoDTO toDto(EnvioPlano envioPlano);
    EnvioPlano toEntity(EnvioPlanoDTO envioPlanoDTO);
}