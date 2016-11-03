package com.example;

import com.example.services.jugadorServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JugadoresYEquiposApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JugadoresYEquiposApplication.class, args);
		context.getBean(jugadorServices.class).testJugador();
	}
}
