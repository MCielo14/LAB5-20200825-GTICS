package com.example.lab520200825gtics.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "persona", schema = "lab5gtics")
public class Persona {
    @Id
    @Column(name = "idPersona", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "dni", length = 45)
    private String dni;

    @Column(name = "celular", length = 45)
    private String celular;

    @Column(name = "tipo_persona", length = 45)
    private String tipoPersona;



}