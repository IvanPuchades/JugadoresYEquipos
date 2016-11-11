package com.example.services;

import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by dam on 21/10/16.
 */
@Service
public class jugadorServices {

    @Autowired
    private EquipoRepository EquipoRepository;

    @Autowired
    private JugadorRepository JugadorRepository;


    public void testJugador() {

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Ivan");
        jugador1.setApellido("Puchades");
        jugador1.setCanastas(5);
        jugador1.setAsistencias(7);
        jugador1.setPosicion("Pivote");
        jugador1.setRebotes(8);
        jugador1.setCumpleaños(LocalDate.of(1995,11,29));
        jugador1.setEquipo(EquipoRepository.findOne(1L));

        JugadorRepository.save(jugador1);


        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Sergi");
        jugador2.setApellido("Tirado");
        jugador2.setCanastas(6);
        jugador2.setAsistencias(4);
        jugador2.setPosicion("Centro");
        jugador2.setRebotes(9);
        jugador2.setCumpleaños(LocalDate.of(1996,2,5));
        jugador2.setEquipo(EquipoRepository.findOne(2L));
        JugadorRepository.save(jugador2);


        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Julen");
        jugador3.setApellido("Galindo");
        jugador3.setCanastas(9);
        jugador3.setAsistencias(14);
        jugador3.setPosicion("Lateral");
        jugador3.setRebotes(22);
        jugador3.setCumpleaños(LocalDate.of(1997,4,2));
        jugador3.setEquipo(EquipoRepository.findOne(3L));
        JugadorRepository.save(jugador3);


        Jugador jugador4 = new Jugador();
        jugador4.setNombre("Jordi");
        jugador4.setApellido("Batalla");
        jugador4.setCanastas(14);
        jugador4.setAsistencias(12);
        jugador4.setPosicion("Base");
        jugador4.setRebotes(15);
        jugador4.setCumpleaños(LocalDate.of(1995,12,12));
        jugador4.setEquipo(EquipoRepository.findOne(4L));
        JugadorRepository.save(jugador4);


        Jugador jugador5 = new Jugador();
        jugador5.setNombre("Sergi");
        jugador5.setApellido("Tennosuke");
        jugador5.setCanastas(14);
        jugador5.setAsistencias(12);
        jugador5.setPosicion("Base");
        jugador5.setRebotes(15);
        jugador5.setCumpleaños(LocalDate.of(1997,6,9));
        jugador5.setEquipo(EquipoRepository.findOne(5L));
        JugadorRepository.save(jugador5);

        //Busquedas por nombres de jugadores
        System.out.println("Buscamos los jugadores por nombre");
        System.out.println(JugadorRepository.findByNombreContaining("Ivan"));

        //Busquedas de canastas mayores o iguales a un numero
        System.out.println("Buscamos una cantidad de canastas mayores o igual a 7" );
        System.out.println(JugadorRepository.findJugadorByCanastasGreaterThan(7));

        //Busquedas de jugadores con un numero de asistencia de entre 5 y 10
        System.out.println("Buscamos jugadores con un numero de asistencias de entre 5 y 10");
        System.out.println(JugadorRepository.findByAsistenciasBetween(5,10));

        //Busquedas de jugadores que pertenezcan a la posicion base
        System.out.println("Buscamos jugadores que pertenezcan a la posicion Base");
        System.out.println(JugadorRepository.FindJugadorByPosicion("Base"));

        //Busquedas dejugadores que hayan nacido antes del 1 / 1 / 1996
        System.out.println("Buscamos jugadores cuya fecha de nacimiento sea anterior al 1/1/1996");
        System.out.println(JugadorRepository.findByCumpleañosBefore(LocalDate.of(1996,1,1)));

        //Obtener la media de canastas de asistencias y rebotes agrupado a los jugadores por posicion
        System.out.println("Agrupamos jugadores por la posicion devolviendo la media de canastas, asistencias y rebotes");
        AVGCanastasANDAsistenciasANDRebotes(JugadorRepository.AVGCanastasANDAsistenciasANDRebotes());

        //Igual que antes pero devolviendo la media el maximo y el minimo de canastas asistencias y rebotes
        System.out.println("Como el anterior pero devolviendo la media el maximo y el minimo de canastas asistencias y rebotes");
        AvgMinANDMaxOfCanastasANDAsistenciasANDRebotes(JugadorRepository.AvgMinANDMaxOfCanastasANDAsistenciasANDRebotes());

        //Apartado de Equipos

        //Devolvemos todos los jugadores del equipo de Madrid
        System.out.println("Mostramos los jugadores del equipo del Madrid");
        System.out.println(JugadorRepository.findByEquipoNombre("Madrid"));

        //Devolvemos todos los jugadores del equipo Sevilla que jueguen en la misma posicion, como alero
        System.out.println("Devolvemos todos los jugadores del equipo Sevilla que jueguen en la misma posicion, como alero");
        System.out.println(JugadorRepository.JugadoresPosicionPorEquipo("alero"));

        //Devolvemos el jugador que mas canastas ha realizado de el Equipo Sevilla
        System.out.println("Devolvemos el jugador que mas canastas ha realizado de el Equipo Sevilla");
        JugadorMaxCanastasPorEquipo(JugadorRepository.JugadorMaxCanastasPorEquipo("Sevilla"));

    }

    private void AVGCanastasANDAsistenciasANDRebotes(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Posición : "+statistic[0]);
            System.out.println("Canastas AVG = "+statistic[1]);
            System.out.println("Asistencias AVG = "+statistic[2]);
            System.out.println("Rebotes AVG = "+statistic[3]+System.lineSeparator());
        }
    }

    private void AvgMinANDMaxOfCanastasANDAsistenciasANDRebotes(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Canastas: "+statistic[0]);
            System.out.println("AVG = "+statistic[1] );
            System.out.println("MIN = "+statistic[2]);
            System.out.println("MAX = "+statistic[3]+System.lineSeparator());
            System.out.println("Asistencias: "+statistic[0]);
            System.out.println("AVG = "+statistic[1] );
            System.out.println("MIN = "+statistic[2]);
            System.out.println("MAX = "+statistic[3]+System.lineSeparator());
            System.out.println("Rebotes: "+statistic[0]);
            System.out.println("AVG = "+statistic[1]);
            System.out.println("MIN = "+statistic[2]);
            System.out.println("MAX = "+statistic[3]+System.lineSeparator());
        }

    }

    private void JugadorMaxCanastasPorEquipo(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Jugador: "+statistic[0]);
            System.out.println("MAX = "+statistic[1]+System.lineSeparator());
        }


    }
}
