package com.d3stroya.springrestsocios.Controladores;

import com.d3stroya.springrestsocios.entidades.Socio;
import com.d3stroya.springrestsocios.repositorio.SocioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class SocioControlador {
    // Logger
    private final Logger log = LoggerFactory.getLogger(SocioControlador.class);

    // Atributos
    private SocioRepositorio repositorio;

    // Controlador
    public SocioControlador(SocioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // CRUD
    // Crear un socio
    @PostMapping("/api/socios")
    public ResponseEntity<Object> crear(@RequestBody Socio socio) {
        if(socio.getId() != null) {
            log.warn("El usuario ya existe.");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repositorio.save(socio));
    }

    // Listar todos los socios
    @GetMapping("/api/socios")
    public List<Socio> buscarTodos() {
        return repositorio.findAll();
    }

    // Buscar un socio por id
    @GetMapping("/api/socio/{id}")
    public ResponseEntity<Socio> buscarPorId(@PathVariable Long id) {
        Optional<Socio> socioOptional = repositorio.findById(id);
        if(socioOptional.isPresent()) {
            return ResponseEntity.ok(socioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un socio
    @PutMapping("/api/socios")
    public ResponseEntity<Object> actualizar(@RequestBody Socio socio) {
        if(socio.getId() == null) {
            log.warn("El socio no existe.");
            return ResponseEntity.badRequest().build();
        }
        if(!repositorio.existsById(socio.getId())) {
            log.warn("El socio no existe.");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repositorio.save(socio));
    }

    // Eliminar un socio por id
    @DeleteMapping("/api/socio/{id}")
    public ResponseEntity<Socio> eliminarUno(@PathVariable Long id) {
        if(!repositorio.existsById(id)) {
            log.warn("No existe el socio que estás tratando de eliminar.");
            return ResponseEntity.notFound().build();
        }
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Eliminar todos los socios
    @DeleteMapping("/api/socios")
    public ResponseEntity<Socio> eliminarTodos() {
        log.info("Solicitud de borrado de todos los socios.");
        repositorio.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
