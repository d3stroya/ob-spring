package com.example.springrestdatajpa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")  // Opcional: cambia el nombre de la tabla en la BD
public class Book {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer numPages;
    private Double price;
    private LocalDate realseDate;
    private Boolean online;

    // Constructores
    public Book() {
    }
    public Book(Long id, String title, String author, Integer numPages, Double price, LocalDate realseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.price = price;
        this.realseDate = realseDate;
        this.online = online;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRealseDate() {
        return realseDate;
    }

    public void setRealseDate(LocalDate realseDate) {
        this.realseDate = realseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    // ToString
}
