package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;
import com.metalmaked.metalmaked.persistence.entity.EnvioPlano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnvioPlanoMapper {

    @Mapping(source = "orden.idOrden", target = "idOrden")  // Corregido
    @Mapping(source = "plano.idPlano", target = "idPlano")  // Corregido
    EnvioPlanoDTO toDto(EnvioPlano envioPlano);

    @Mapping(source = "idOrden", target = "orden.idOrden")  // Corregido
    @Mapping(source = "idPlano", target = "plano.idPlano")  // Corregido
    EnvioPlano toEntity(EnvioPlanoDTO envioPlanoDTO);
}
