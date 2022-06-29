package com.d3stroya.ejercicio4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "SpringLaptops",
                "API REST Spring Laptop",
                "1.0",
                "https://d3stroya.com/terms-and-services",
                new Contact("Destroya", "https://destroya.com", "hi@destroya.com"),
                "MIT",
                "https://d3stroya.com/license",
                Collections.emptyList()
        );
    }
}
