// 5. Desde el método main, probar a obtener el bean UserService
// y ejecutar el método imprimirSaludo que tiene asociado el atributo de tipo NotificationService.
// De forma similar a la realizada en clase.
package com.d3stroya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Inicializar contenedor para tener beans
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        NotificationService notification = (NotificationService) context.getBean("notificationService");
        notification.imprimirSaludo("Hola mundo desde NotificationService");

        UserService userService = (UserService) context.getBean("userService");
        userService.notificationService.imprimirSaludo("Saludo desde UserService");
    }
}
