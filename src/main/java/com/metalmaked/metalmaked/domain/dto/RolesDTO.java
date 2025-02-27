package com.metalmaked.metalmaked.domain.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RolesDTO {

    private Integer idRol;
    private String nombreRol;

    // Constructor
    public RolesDTO(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
}
