package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PersonaRolesDTO {

    private Integer idPersona;
    private Integer idRol;

    // Constructor
    public PersonaRolesDTO(Integer idPersona, Integer idRol) {
        this.idPersona = idPersona;
        this.idRol = idRol;
    }
}
