package com.example.lab520200825gtics.repositorios;

import com.example.lab520200825gtics.entidades.Persona;
import com.example.lab520200825gtics.entidades.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
