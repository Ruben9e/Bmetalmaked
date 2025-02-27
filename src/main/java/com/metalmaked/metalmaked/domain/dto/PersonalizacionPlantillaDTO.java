package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PersonalizacionPlantillaDTO {

    private Integer idPersona;
    private Integer idPlantilla;
    private String nombreArchivo;
    private String color;
    private Integer largo;
    private Integer ancho;
    private Integer alto;
    private String diseno;

    // Constructor
    public PersonalizacionPlantillaDTO(Integer idPersona, Integer idPlantilla, String nombreArchivo, String color,
                                       Integer largo, Integer ancho, Integer alto, String diseno) {
        this.idPersona = idPersona;
        this.idPlantilla = idPlantilla;
        this.nombreArchivo = nombreArchivo;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.diseno = diseno;
    }
}
