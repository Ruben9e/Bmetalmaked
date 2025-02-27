package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ComposicionPlantillaDTO {

    private Integer idPlantilla;
    private Integer idMaterial;
    private Integer cantidad;

    // Constructor
    public ComposicionPlantillaDTO(Integer idPlantilla, Integer idMaterial, Integer cantidad) {
        this.idPlantilla = idPlantilla;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
    }
}
