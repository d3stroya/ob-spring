// 4. Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
// 5. Probar que funciona desde Postman.
// 6. Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.
// Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.

package com.d3stroya.ejercicio4.controller;

import com.d3stroya.ejercicio4.entity.Laptop;
import com.d3stroya.ejercicio4.repository.LaptopRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LaptopController {
    // 1. AÑADIR REPOSITORIO
    // Atributo
    private LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // 2. CRUD
    // Buscar todos los laptops. Devuelve una lista.
    @GetMapping("api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    // Crear un laptop
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
