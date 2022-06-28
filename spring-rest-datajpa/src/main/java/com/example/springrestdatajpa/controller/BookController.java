package com.example.springrestdatajpa.controller;

// Crear un controlador de tipor REST
import com.example.springrestdatajpa.entities.Book;
import com.example.springrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // Crear log
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // 1. AÑADIR REPOSITORY:
    // Atributos
    private BookRepository bookRepository;

    // Constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 2. CRUD sobre la entidad Book
    // 2.1. Buscar todos los libros que hay BD (ArrayList de libros)
    @GetMapping("/api/books")
    public List<Book> findAll() {
        // Recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }

    // 2.2. Buscar un solo libro según su
    // Necesitamos un id dinámico en la url. Para ello, usamos /{id}
    // Ese id será el que pasemos como parámetro. Para ello, añadimos @PathVariable al parámetro.
    // Así vinculamos el id del parámetro con el id de la url
    @GetMapping("/api/books/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long") // Explica lo que hace el método. Es un comentario de Swagg
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

    // 2.3. Crear un nuevo libro
    @PostMapping("/api/books")  // Envía petición, por lo que se usa PostMapping. No colisiona con GET /api/books porque es POST (método http diferente).
    public ResponseEntity<Object> create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {    // RequestBody extrae la información de la petición. RequestHeader extrae cabeceras (se usa para enviar info al servidor).
        System.out.println(headers.get("User-Agent"));
        // Guardar el libro recibido por parámetro en la base de datos
        if(book.getId() != null) {    // Comprueba si existe el libro. Si existe no se podrá crear, sino actualizar, y viceversa.
            log.warn("Trying to create a book with id");    // Muestra una advertencia si se intenta crear un libro que ya existe (ya tiene un id).
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // 2.4. Actualizar un libro existente
    @PutMapping("/api/books") // PUT para actualizar. No colisiona porque es otro método http
    public ResponseEntity<Object> update(@RequestBody Book book) {
        if(book.getId() == null) {
            log.warn("Trying to update a non existent book.");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())) {
            log.warn("Trying to update  a non existent book.");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // 2.5. Borrar un libro
    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        if(!bookRepository.existsById(id)) {
            log.warn("Trying to delete a non existent book.");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();  // Indica que el contenido no existe, porque se ha borrado.
    }

    // 2.6. Eliminar todos los libros
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll() {
        log.info("REST Request for delete all books.");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
