package com.metalmaked.metalmaked.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "envio_plano")
@IdClass(EnvioPlanoId.class)
public class EnvioPlano {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden orden;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;
}
