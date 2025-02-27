package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "id_plantilla", nullable = false)
    private Plantilla plantilla;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Integer precioUnitario;

    @Column(name = "precio_total", nullable = false)
    private Integer precioTotal;
}
