package com.example.repository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by usu32 on 24/10/2016.
 */

//hacemos el Extends con el repositorio "Default" de Spring
public interface JugadorRepository extends JpaRepository<Jugador, Long>{



}
