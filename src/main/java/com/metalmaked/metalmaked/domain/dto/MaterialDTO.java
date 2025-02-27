package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class MaterialDTO {

    private Integer idMaterial;
    private String nombreMaterial;
    private String unidadMedida;
    private Integer costoUnidad;

    // Constructor
    public MaterialDTO(Integer idMaterial, String nombreMaterial, String unidadMedida, Integer costoUnidad) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.unidadMedida = unidadMedida;
        this.costoUnidad = costoUnidad;
    }
}
