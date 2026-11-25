package com.biblioteca.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Classe principal que inicia o sistema e configura onde o Spring procura o código.
@SpringBootApplication(scanBasePackages = "com.biblioteca")
@EntityScan(basePackages = "com.biblioteca.model")
@EnableJpaRepositories(basePackages = "com.biblioteca.repository")
public class BibliotecaApplication {

	// Inicia a aplicação Spring Boot.
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
