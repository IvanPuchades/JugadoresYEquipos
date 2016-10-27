package com.example.service;

import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by dam on 21/10/16.
 */
@Service
public class jugadorServices {


    private EquipoRepository EquipoRepository;


    private JugadorRepository JugadorRepository;


    public void testJugador() {

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Ivan");
        jugador1.setApellido("Puchades");
        jugador1.setCanastas(5);
        jugador1.setAsistencias(7);
        jugador1.setPosicion("Pivote");
        jugador1.setRebotes(8);
        jugador1.setCumpleaños(LocalDate.of(1995,29,11));
        JugadorRepository.save(jugador1);


        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Sergi");
        jugador2.setApellido("Tirado");
        jugador2.setCanastas(6);
        jugador2.setAsistencias(4);
        jugador2.setPosicion("Centro");
        jugador2.setRebotes(9);
        jugador2.setCumpleaños(LocalDate.of(1996,2,5));
        JugadorRepository.save(jugador2);


        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Julen");
        jugador3.setApellido("Galindo");
        jugador3.setCanastas(9);
        jugador3.setAsistencias(14);
        jugador3.setPosicion("Lateral");
        jugador3.setRebotes(22);
        jugador3.setCumpleaños(LocalDate.of(1997,4,2));
        JugadorRepository.save(jugador3);


        Jugador jugador4 = new Jugador();
        jugador4.setNombre("Jordi");
        jugador4.setApellido("Batalla");
        jugador4.setCanastas(14);
        jugador4.setAsistencias(12);
        jugador4.setPosicion("Lateral");
        jugador4.setRebotes(15);
        jugador4.setCumpleaños(LocalDate.of(1995,12,12));
        JugadorRepository.save(jugador4);


        Jugador jugador5 = new Jugador();
        jugador5.setNombre("Jordi");
        jugador5.setApellido("Batalla");
        jugador5.setCanastas(14);
        jugador5.setAsistencias(12);
        jugador5.setPosicion("Lateral");
        jugador5.setRebotes(15);
        jugador5.setCumpleaños(LocalDate.of(1997,6,9));
        JugadorRepository.save(jugador5);
    }
}
