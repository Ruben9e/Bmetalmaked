package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true, length = 50)
    private String correo;

    @Column(nullable = false, length = 50)
    private String contraseña;

    @Column(length = 50)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @OneToMany(mappedBy = "persona")
    private Set<Plantilla> plantillas;

    @OneToMany(mappedBy = "persona")
    private Set<Orden> ordenes;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "persona_roles",
            joinColumns = @JoinColumn(name = "id_persona"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Roles> roles;
}
