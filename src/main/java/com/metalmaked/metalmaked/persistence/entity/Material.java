package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Integer idMaterial;

    @Column(name = "nombre_material", nullable = false, length = 50)
    private String nombreMaterial;

    @Column(name = "unidad_medida", length = 10)
    private String unidadMedida;

    @Column(name = "costo_unidad", nullable = false)
    private Integer costoUnidad;
}
