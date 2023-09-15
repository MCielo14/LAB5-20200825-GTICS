package com.example.lab520200825gtics.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mascotas", schema = "lab5gtics")
public class Mascota {
    @Id
    @Column(name = "idMascotas", nullable = false)
    private Integer id;

    @Column(name = "nombre_mascota", length = 45)
    private String nombreMascota;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "edad", length = 45)
    private String edad;

    @Column(name = "fecha_nacimiento", length = 45)
    private String fechaNacimiento;

    @Column(name = "Vacunado", length = 45)
    private String vacunado;

    @Column(name = "Desparasitado", length = 45)
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona", nullable = false)
    private Persona personaIdpersona;

}