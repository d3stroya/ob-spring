package com.example.springrestdatajpa;

import com.example.springrestdatajpa.entities.Book;
import com.example.springrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		// CRUD
		// Crear libro
		Book laCelestina = new Book(null, "La Celestina", "Fernando de Rojas", 160, 9.90, LocalDate.of(1499, 1, 7), true);
		Book condeLucanor = new Book(null, "El conde Lucanor", "Don Juan Manuel", 160, 7.90, LocalDate.of(14991331, 5, 20), true);

		// Almacenar un libro
		//System.out.println("Número de libros en BD antes de guardar: " + repository.findAll().size());
		repository.save(laCelestina);
		repository.save(condeLucanor);

		// Recuperar todos los libros
		//System.out.println("Número de libros en BD después de guardar: " + repository.findAll().size());

		// Borrar un libro
		/// repository.deleteById(1L);
		//System.out.println("Número de libros en BD después de eliminar uno: " + repository.findAll().size());
	}

}
