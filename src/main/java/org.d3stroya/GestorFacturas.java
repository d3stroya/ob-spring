package org.d3stroya;

// Indica que es un componente para que el escaner de beans.xml lo pueda encontrar.
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component

public class GestorFacturas {
    // 1. Atributos
    Calculadora calculadora;

    // 2. Constructores
    public GestorFacturas(Calculadora calculadora) {
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
    }
}
