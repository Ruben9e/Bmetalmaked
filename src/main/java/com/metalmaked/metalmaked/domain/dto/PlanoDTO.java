package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PlanoDTO {

    private Integer idPlano;
    private String nombrePlano;

    // Constructor
    public PlanoDTO(Integer idPlano, String nombrePlano) {
        this.idPlano = idPlano;
        this.nombrePlano = nombrePlano;
    }
}
