package com.example.springrestdatajpa.service;

import com.example.springrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;   // Permite comprobar si algo está bien o mal

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        // Configuración de la prueba
        Book book  = new Book(1L, "Título", "Autor", 457, 20.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Se ejecuta el comportamiento al testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // Comprobaciones o aserciones
        assertTrue(price > 0);
        assertEquals(29, price);
    }
}