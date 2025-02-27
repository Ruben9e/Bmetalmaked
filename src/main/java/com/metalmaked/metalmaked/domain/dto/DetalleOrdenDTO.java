package com.metalmaked.metalmaked.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class DetalleOrdenDTO {

    private Integer idDetalle;
    private Integer idOrden;
    private Integer idPlantilla;
    private Integer cantidad;
    private Integer precioUnitario;
    private Integer precioTotal;

    // Constructor
    public DetalleOrdenDTO(Integer idDetalle, Integer idOrden, Integer idPlantilla, Integer cantidad,
                           Integer precioUnitario, Integer precioTotal) {
        this.idDetalle = idDetalle;
        this.idOrden = idOrden;
        this.idPlantilla = idPlantilla;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }
}
