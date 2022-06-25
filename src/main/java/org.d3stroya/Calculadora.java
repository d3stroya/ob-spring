package org.d3stroya;

import org.springframework.stereotype.Component;
@Component

public class Calculadora {
    // Spring aporta los constructores automáticamente en otros archivos
    public Calculadora(){
        System.out.println("Ejecutando constructor CalculatorService");
    }
    public String holaMundo() {
        return "Hola mundo";
    }
}
