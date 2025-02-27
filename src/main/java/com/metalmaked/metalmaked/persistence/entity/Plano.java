package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Integer idPlano;

    @Column(name = "nombre_plano", nullable = false, length = 50)
    private String nombrePlano;
}
