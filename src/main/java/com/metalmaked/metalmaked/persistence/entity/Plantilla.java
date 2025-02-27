package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plantilla")
public class Plantilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plantilla")
    private Integer idPlantilla;

    @Column(name = "nombre_plantilla", nullable = false, length = 50)
    private String nombrePlantilla;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
}
