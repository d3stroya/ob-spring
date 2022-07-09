package com.example.springsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt que genera su propio salt de 16 bytes
     * Genera un string de 60 caracteres con el formato:
     * $a - versión
     * $10 - fuerza: es un valor 4-31 que por defecto vale 10, pero se puede cambiar.
     * Los 22 siguientes caracteres son el salt generado.
     */
    @Test
    void bcryptTest() {
        // Crear un objeto. Se puede personalizar con parámetros
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Encriptar una contraseña
        String hashPassword = passwordEncoder.encode("admin");
        System.out.println(hashPassword);

        // Verificar si la pass que introduce el usuario coincide con la codificada
        // Envía query a la base de datos, donde está el nombre de usuario con la pass codificada
        // y verifica si coincide (match) con la que ha introducido el usuario.
        Boolean matches = passwordEncoder.matches("admin", hashPassword);
        System.out.println(matches);
    }

    // Para una misma contraseña, se generan diferentes contraseñas codificadas
    @Test
    void bcryptCheckMultiplePasswords() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for(int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        for(int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

//    @Test
//    void argon() {
//        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
//        for (int i = 0; i < 30; i++)
//            System.out.println(passwordEncoder.encode("admin"));
//    }
//
    //@Test
    //void scrypt() {
    //    SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
    //    for (int i = 0; i < 30; i++)
    //        System.out.println(passwordEncoder.encode("admin"));
    //}


    // Spring trabaja con la intergaz PasswordEncoder y la clase DelegatingPasswordEncoder para no trabajar directamente
    // con password encoders que pueden quedar obsoletos con el tiempo (ya no sean seguros).
    // Podremos cambiar de password encoder sin cambiar esto.
    @Test
    void springPasswordEncoders() {
        // Crear un mapa
        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
    }
}
