package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class OrdenDTO {

    private Integer idOrden;
    private String fechaOrden;
    private String estadoOrden;
    private Integer idPersona;

    // Constructor
    public OrdenDTO(Integer idOrden, String fechaOrden, String estadoOrden, Integer idPersona) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.estadoOrden = estadoOrden;
        this.idPersona = idPersona;
    }
}
