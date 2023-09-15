package com.example.lab520200825gtics.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "viajes", schema = "lab5gtics")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes", nullable = false)
    private Integer id;

    @Column(name = "punto_recojo", length = 45)
    private String puntoRecojo;

    @Column(name = "cant_personas", length = 45)
    private String cantPersonas;

    @Column(name = "cant_perros", length = 45)
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona", nullable = false)
    private Persona personaIdpersona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares", nullable = false)
    private Lugare lugaresIdlugares;

}