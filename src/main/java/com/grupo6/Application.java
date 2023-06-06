package com.grupo6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class,args);
        }
    @Configuration
    public class MyCorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins("http://127.0.0.1:5173/")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("Authorization", "Content-Type")
                    .exposedHeaders("Custom-Header")
                    .allowCredentials(true)
                    .maxAge(3600);
        }

        // Otros métodos de configuración si es necesario

    }
}
