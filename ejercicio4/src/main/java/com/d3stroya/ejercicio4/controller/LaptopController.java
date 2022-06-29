// 4. Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
// 5. Probar que funciona desde Postman.
// 6. Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.
// Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.

package com.d3stroya.ejercicio4.controller;

import com.d3stroya.ejercicio4.entity.Laptop;
import com.d3stroya.ejercicio4.repository.LaptopRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // CREAR LOG
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // 1. AÑADIR REPOSITORIO
    // Atributo
    private LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // 2. CRUD
    // Buscar todos los laptops. Devuelve una lista. FindAll()
    @ApiOperation("Buscar todos los ordenadores.")
    @GetMapping("api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    // Buscar un laptop por id. FindOneById()
    @ApiOperation("Buscar un ordenador por id.")
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        // Compruebo si existe
        if(laptopOpt.isPresent()){
            // True: devuelve estado OK (200) y el libro
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            // False: devuelve NOT FOUND (404)
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un laptop
    @ApiOperation("Crear un ordenador.")
    @PostMapping("/api/laptops")
    public ResponseEntity<Object> create(@RequestBody Laptop laptop) {
        // Compruebo si ya esiste
        if(laptop.getId() != null) {
            // True: mensaje de error
            log.warn("Trying to create an existent laptop.");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
        }

        // Actualizar un laptop. update()
    @ApiOperation("Actualizar los datos de un ordenador.")
    @PutMapping("/api/laptops")
    public ResponseEntity<Object> update(@RequestBody Laptop laptop) {
        if(laptop.getId() == null) {
            log.warn("Trying to update a non existent laptop.");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non existent laptop.");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

        // Borrar un laptop. delete()
    @ApiOperation("Eliminar un ordenador por id.")
        @DeleteMapping("/api/laptop/{id}")
        public ResponseEntity<Laptop> deleteOne(@PathVariable Long id) {
            if(!laptopRepository.existsById(id)) {
                log.warn("Trying to delete a non existent laptop.");
                return ResponseEntity.notFound().build();
            }
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        // Borrar todos los laptops. deleteAll()
    @ApiOperation("Eliminar todos los ordenadores.")
        @DeleteMapping("/api/laptops")
        public ResponseEntity<Laptop> deleteAll() {
            laptopRepository.deleteAll();
            return ResponseEntity.noContent().build();
        }

}
