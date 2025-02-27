package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class EnvioPlanoDTO {

    private Integer idOrden;
    private Integer idPlano;
    private String fechaEnvio;

    // Constructor
    public EnvioPlanoDTO(Integer idOrden, Integer idPlano, String fechaEnvio) {
        this.idOrden = idOrden;
        this.idPlano = idPlano;
        this.fechaEnvio = fechaEnvio;
    }
}
