package com.example.lab520200825gtics.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "lugares", schema = "lab5gtics")
public class Lugare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares", nullable = false)
    private Integer id;

    @Column(name = "nombre_lugar", length = 45)
    private String nombreLugar;

    @Column(name = "descrip_lugar", length = 45)
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private LocalDate fechaLugar;


}