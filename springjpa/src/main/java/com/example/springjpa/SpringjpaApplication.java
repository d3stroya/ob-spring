package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);


		// Crear y almacenar un coche en base de datos
		Coche toyota = new Coche(null, "Toyota", "Prius", 2010);
		repository.save(toyota);
		System.out.println("NÚMERO DE COCHE EN BD: " + repository.count());

		// Recuperar un coche por id
		System.out.println(repository.findAll());
	}

}
