package com.example.springrestdatajpa.service;

import com.example.springrestdatajpa.entities.Book;

// Clase creada para probar testing
// Click Derecho > Generate > Test
public class BookPriceCalculator {
    public double calculatePrice(Book book) {
        double price = book.getPrice();
        if(book.getNumPages() > 300) {
            price += 5;
        }
        price += 2.99;  // envío
        return Math.round(price);
    }
}
