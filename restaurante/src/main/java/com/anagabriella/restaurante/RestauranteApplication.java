package com.anagabriella.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication ///chamando atenção do springboot, tal como uma atiqueta de como deve tratar o comando
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args); ///partida na aplicação
	}

}
