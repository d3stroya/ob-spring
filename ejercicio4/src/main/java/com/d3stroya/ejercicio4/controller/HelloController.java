// 2. Crear una clase HelloController que sea un controlador REST.
// Dentro de la clase crear un método que retorne un saludo.
// Probar que retorna el saludo desde el navegador y desde Postman.
package com.d3stroya.ejercicio4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    String message;
    @GetMapping("/saludo")
    public String saludo() {
        System.out.println(message);
        return "Hola mundo";
    }
}
