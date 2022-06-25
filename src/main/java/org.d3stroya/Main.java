package org.d3stroya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Inicializar contenedor para tener beans
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // CONCEPTO 1: Obtener objetos de Spring
        // Opción 1. Crear un objeto de forma normal
        // Calculadora service = new Calculadora();

        // Opción 2. Recibir un objeto de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        // Usar el método holaMundo de la clase CalculadoraService
        String texto = calculadora.holaMundo();
        System.out.println(texto);

        // CONCEPTO 2: Cargar un bean de otro bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());
        // CONCEPTO 3: scope o alcance
        // Los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación.
        // Podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez.
        // Por ejemplo, crear un nuevo coche cada vez.
    }
}
