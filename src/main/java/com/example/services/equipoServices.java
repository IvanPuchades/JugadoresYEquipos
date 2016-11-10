package com.example.services;

import com.example.domain.Equipo;
import com.example.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by dam on 21/10/16.
 */
@Service
public class equipoServices {

    @Autowired
    private EquipoRepository EquipoRepository;

    public void testEquipos() {

        Equipo equipo1 = new Equipo();
        equipo1.setNombre("F.C.Barcelona");
        equipo1.setLocalidad("Barcelona");
        equipo1.setCreacion(LocalDate.of(1899,11,29));
        EquipoRepository.save(equipo1);

        Equipo equipo2 = new Equipo();
        equipo2.setNombre("Madrid");
        equipo2.setLocalidad("Madrid");
        equipo2.setCreacion(LocalDate.of(1902,3,6));
        EquipoRepository.save(equipo2);

        Equipo equipo3 = new Equipo();
        equipo3.setNombre("Valencia");
        equipo3.setLocalidad("Ciudad de Valencia");
        equipo3.setCreacion(LocalDate.of(1919,3,18));
        EquipoRepository.save(equipo3);

        Equipo equipo4 = new Equipo();
        equipo4.setNombre("Atleti");
        equipo4.setLocalidad("Ciudad Atletic");
        equipo4.setCreacion(LocalDate.of(1919,3,18));
        EquipoRepository.save(equipo4);

        Equipo equipo5 = new Equipo();
        equipo5.setNombre("Sevilla");
        equipo5.setLocalidad("Ciudad de Sevilla");
        equipo5.setCreacion(LocalDate.of(1919,3,18));
        EquipoRepository.save(equipo5);


        System.out.println();


    }
}
