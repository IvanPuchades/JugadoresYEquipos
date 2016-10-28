package com.example.repository;

import com.example.domain.Jugador;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * Created by usu32 on 24/10/2016.
 */

//hacemos el Extends con el repositorio "Default" de Spring
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

    //Buscar Jugadores por nombre de manera que no sea necesario introducir el nombre completo
    List<Jugador> findByNombreContaining(String nombre);

    //Buscar jugadores que hayan conseguido un numero mayor o igual a un numero de canastas especificado como parametro
    @Query("SELECT jugador FROM Jugador jugador WHERE jugador.canastas > 8")
    List<Jugador> findJugadorByCanastasGreaterThan(
            @Param("canastas") int canastas
    );

    //Buscar Jugadores que hayan efectuado un numero de asistencias dentro de un rango especigicado como parametro

    List<Jugador> findByAsistenciasBetween(Integer minAsistencias, Integer maxAsistencias);

    //@Query("SELECT jugador FROM Jugador jugador WHERE jugador.asistencias between :minAsistencias and :maxAsistencias")
    //List<Jugador> findJugadorByAsistenciasBetween(
    //        @Param("minAsistencias") Integer minAsistencias,
    //        @Param("maxAsistencias") Integer maxAsistencias
    //);

    //Buscar jugadores que pertenezcan a una posicion especifica, por ejemplo: base
    @Query("SELECT jugador FROM Jugador jugador WHERE jugador.posicion like 'base'")
    List<Jugador> FindJugadorByPosicion(
            @Param("posicion") Jugador posicion
    );

    //Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parametro
    List<Jugador> findByCumpleañosAfter(LocalDate localDate);

    //Agrupar los jugadores por la posicion del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes
    @Query("SELECT AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AVGCanastasANDAsistenciasANDRebotes();


    //


}
