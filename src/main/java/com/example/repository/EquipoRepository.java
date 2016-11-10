package com.example.repository;

import com.example.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by usu32 on 24/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long>
{
    //Consulta los equipos existentes en una localidad determinada
    List<Equipo> findByLocalidad(@Param("localidad") String localidad);





}
