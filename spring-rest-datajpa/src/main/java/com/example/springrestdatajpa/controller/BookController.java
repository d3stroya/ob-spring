package com.example.springrestdatajpa.controller;

// Crear un controlador de tipor REST
import com.example.springrestdatajpa.entities.Book;
import com.example.springrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // 1. AÑADIR REPOSITORY:
    // Atributos
    private BookRepository bookRepository;

    // Constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 2. CRUD sobre la entidad Book
    // Buscar todos los libros (lista)
    @GetMapping("/api/books")
    public List<Book> findAll() {
        // Recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }

    // Buscar un solo libro según su
    // Necesitamos un id dinámico en la url. Para ello, usamos /{id}
    // Ese id será el que pasemos como parámetro. Para ello, añadimos @PathVariable al parámetro.
    // Así vinculamos el id del parámetro con el id de la url
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {   // Response entity devuelve una respuesta http
        Optional<Book> bookOpt = bookRepository.findById(id);
        // Comprobar si hay datos o no:
        // Opción 1.1
        if(bookOpt.isPresent()){
            // Opción 1.2
            //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
            return ResponseEntity.ok(bookOpt.get());    // Devuelve una respuesta con el libro
        } else {
            return ResponseEntity.notFound().build();   // Construye una respuesta not found
        }
        // Opción 2
        //return bookOpt.orElse(null);
    }

    // Crear un nuevo libro
    @PostMapping("/api/books")  // Envía petición, por lo que se usa PostMapping. No colisiona con GET /api/books porque es POST
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {    // RequestBody extrae la información de la petición. RequestHeader extrae cabeceras
        System.out.println(headers.get("User-Agent"));
        // Guardar el libro recibido por parámetro en la base de datos
        return bookRepository.save(book);
    }


    // Actualizar un libro existente

    // Borrar un libro
}
