package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personalizacion_plantilla")
public class PersonalizacionPlantilla {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_plantilla", nullable = false)
    private Plantilla plantilla;

    @Column(name = "nombre_archivo", nullable = false, length = 20)
    private String nombreArchivo;

    @Column(nullable = false, length = 20)
    private String color;

    @Column(nullable = false)
    private Integer largo;

    @Column(nullable = false)
    private Integer ancho;

    @Column(nullable = false)
    private Integer alto;

    @Column(nullable = false, length = 20)
    private String diseño;
}
