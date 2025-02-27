package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer idOrden;

    @Column(name = "fecha_orden", nullable = false)
    private LocalDateTime fechaOrden;

    @Column(name = "estado_orden", nullable = false, length = 50)
    private String estadoOrden;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
}
