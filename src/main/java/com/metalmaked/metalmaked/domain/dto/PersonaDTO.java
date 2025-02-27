package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {

    private Integer idPersona;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;

    // Constructor
    public PersonaDTO(Integer idPersona, String nombre, String correo, String direccion, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
