package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona_roles")
@IdClass(PersonaRoles.class)
public class PersonaRoles {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Roles rol;
}
