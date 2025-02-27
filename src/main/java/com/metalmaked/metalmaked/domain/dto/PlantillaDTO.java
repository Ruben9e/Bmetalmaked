package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PlantillaDTO {

    private Integer idPlantilla;
    private String nombrePlantilla;
    private String descripcion;
    private Integer idPersona;

    // Constructor
    public PlantillaDTO(Integer idPlantilla, String nombrePlantilla, String descripcion, Integer idPersona) {
        this.idPlantilla = idPlantilla;
        this.nombrePlantilla = nombrePlantilla;
        this.descripcion = descripcion;
        this.idPersona = idPersona;
    }
}
