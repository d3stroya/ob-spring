package com.example.springrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

// Configuración Swagger para crear la documentación de la API REST
// http://localhost:8080/swagger-ui/
@Configuration
public class SwaggerConfig {
    // Inicializa Swagger
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())   // Que construya sobre todas las rutas que tenemos
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("SpringBooks",
                "API REST made with Srping",
                "1.0", "https://www.d3stroya.com/terminos-servicios",
                new Contact("Paca","\"https://www.d3stroya.com","d3stroya@d3stroya.com"),
                "MIT",
                "https://www.d3stroya.com/licencia",
                Collections.emptyList());
    }
}
