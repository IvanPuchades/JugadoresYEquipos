package com.example.repository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu32 on 24/10/2016.
 */

//hacemos el Extends con el repositorio "Default" de Spring
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

    List<Jugador>  findByEquipo(Equipo equipo);
    List<Jugador>  findByEquipoNombre(String equipo);

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
    List<Jugador> findByCumpleañosBefore(LocalDate localDate);

    //Agrupar los jugadores por la posicion del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes
    @Query("SELECT jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AVGCanastasANDAsistenciasANDRebotes();


    //Lo mismo que en el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes

    @Query("SELECT jugador.posicion, AVG(jugador.canastas), MIN(jugador.canastas), MAX(jugador.canastas), " +
            "AVG(jugador.asistencias), MIN(jugador.asistencias), MAX(jugador.asistencias)," +
            "AVG(jugador.rebotes), MIN(jugador.rebotes), MAX(jugador.rebotes) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion ")

    List<Object[]> AvgMinANDMaxOfCanastasANDAsistenciasANDRebotes();



    //Aqui empieza el apartado de Querys de Equipo

    //Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo

    @Query("SELECT jugador.nombre FROM Jugador jugador " +
            "GROUP BY jugador.equipo")
    List<Object[]> JugadoresPorEquipo();

    //Devuelve todos los jugadores de un equipo, que ademas jueguen en la misma posicion
    //(Parametro adicional de la consulta), por ejemplo, alero.
    @Query("SELECT jugador.nombre FROM Jugador jugador " +
            "WHERE jugador.posicion =:alero " +
            "GROUP BY jugador.equipo")
    List<Object[]> JugadoresPosicionPorEquipo();

    //Devuelve el jugador que mas canastas ha realizado de un equipo determinado como parametro.
    @Query("SELECT jugador.nombre, MAX(jugador.canastas) FROM Jugador jugador" +
            " GROUP BY jugador.equipo")
    List<Object[]> JugadorMaxCanastasPorEquipo();


}
