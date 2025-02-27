package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false, length = 20)
    private String nombreRol;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "roles")
    private Set<Persona> personas;
}
