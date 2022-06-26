// 1. Crear la clase NotificationService, con un método que imprima un saludo.
package com.d3stroya;

// 3. Utilizar la anotación @Component en cada clase.
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public void imprimirSaludo(String texto) {
        System.out.println(texto);
    }

    public NotificationService() {
        System.out.println("Ejecutando constructor NotificationService");
    }
}
