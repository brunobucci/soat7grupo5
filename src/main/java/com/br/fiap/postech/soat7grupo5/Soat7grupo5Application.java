package com.br.fiap.postech.soat7grupo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = 
		@Info(title = "Soat7grupo5 API", 
			version = "2.0", 
			description = "Página de referência da Soat7grupo5 API")
)
public class Soat7grupo5Application {
	public static void main(String[] args) {
		SpringApplication.run(Soat7grupo5Application.class, args);
	}
}