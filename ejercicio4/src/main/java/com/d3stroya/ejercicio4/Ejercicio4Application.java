// 1. Crear un proyecto Spring Boot con las dependencias:
	//H2
	//Spring Data JPA
	//Spring Web
	//Spring Boot dev tools

// 3. Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":
//Laptop (entidad)
//LaptopRepository (repositorio)
//LaptopController (controlador)

package com.d3stroya.ejercicio4;

import com.d3stroya.ejercicio4.controller.HelloController;
import com.d3stroya.ejercicio4.entity.Laptop;
import com.d3stroya.ejercicio4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		// Crear ordenadores
		Laptop mac = new Laptop(null, 128, 100, "Apple", true, 1089.90);
		Laptop vaio = new Laptop(null, 36, 512, "Sony", true, 789.20);

		// Almacenar ordenadores en base de datos
		laptopRepository.save(mac);
		laptopRepository.save(vaio);
	}

}
