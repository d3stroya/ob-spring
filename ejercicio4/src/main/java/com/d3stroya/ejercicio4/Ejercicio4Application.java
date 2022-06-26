// 1. Crear un proyecto Spring Boot con las dependencias:
	//H2
	//Spring Data JPA
	//Spring Web
	//Spring Boot dev tools

package com.d3stroya.ejercicio4;

import com.d3stroya.ejercicio4.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);

	}

}
