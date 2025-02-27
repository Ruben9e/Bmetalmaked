package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "composicion_plantilla")
@IdClass(ComposicionPlantillaId.class)
public class ComposicionPlantilla {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_plantilla", nullable = false)
    private Plantilla plantilla;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(nullable = false)
    private Integer cantidad;
}
