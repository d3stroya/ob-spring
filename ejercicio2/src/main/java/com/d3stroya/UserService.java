// 2. Crear una clase UserService que tenga un atributo de clase NotificationService.
package com.d3stroya;

// 3. Utilizar la anotación @Component en cada clase.
import org.springframework.stereotype.Component;

@Component
public class UserService {
    NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        System.out.println("Ejecutando constructor UserService");
        this.notificationService = notificationService;
    }
}
