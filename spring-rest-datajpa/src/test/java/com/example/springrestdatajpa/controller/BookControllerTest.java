package com.example.springrestdatajpa.controller;

import com.example.springrestdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// Para testear un controlador hay que lanzar http y recibir responseRequest. Envía y recibe peticiones desde la propia api, sin usar postman o swagger.
// Añadir la anotación:
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Para lanzar peticiones http
class BookControllerTest {

    // Crear clases:
    private TestRestTemplate testRestTemplate;  // Método para hacer peticiones http

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    // Clic derecho > Generate > SetUp Method
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    @DisplayName("Comprobar hola mundo desde controladores Spring REST")
    @Test
    void hello() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);  // Para indicar el tipo de dato, se pone .class.
        assertEquals(HttpStatus.OK, response.getStatusCode());  // Comprueba el estado de la petición (que sea 200).
        assertEquals("Hola mundo!!!", response.getBody());  // Que devuelva el texto dado.
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findById() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/api/books/1", String.class);
        // La idea es ir probando todas las posibilidades
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Test",
                    "author": "Test",
                    "numPages": 800,
                    "price": 9.9,
                    "realseDate": "2022",
                    "online": false
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);

        Book result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Spring", result.getTitle());

    }
}