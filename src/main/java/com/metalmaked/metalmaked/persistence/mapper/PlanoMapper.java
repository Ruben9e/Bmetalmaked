package com.metalmaked.metalmaked.persistence.mapper;

import com.metalmaked.metalmaked.domain.dto.PlanoDTO;
import com.metalmaked.metalmaked.persistence.entity.Plano;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanoMapper {
    PlanoDTO toDto(Plano plano);
    Plano toEntity(PlanoDTO planoDTO);
}
