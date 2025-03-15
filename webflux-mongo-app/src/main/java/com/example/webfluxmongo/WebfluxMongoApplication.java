package com.example.webfluxmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Clase principal de la aplicación Spring Boot.
 * <p>
 * Anotaciones clave:
 * - @SpringBootApplication: habilita la autoconfiguración de Spring Boot,
 *   el escaneo de componentes (@ComponentScan) y la configuración automática
 *   de beans de Spring.
 * - @EnableConfigurationProperties: permite que las clases anotadas con
 *   @ConfigurationProperties se carguen y vinculen sus propiedades desde
 *   los archivos de configuración (application.yml, etc.).
 */
@SpringBootApplication
@EnableConfigurationProperties
public class WebfluxMongoApplication {

    /**
     * Método principal (entry point) de la aplicación Java.
     * <p>
     * Utiliza SpringApplication.run(...) para iniciar el contexto de Spring,
     * configurar los beans y arrancar el servidor embebido (Netty, al usar WebFlux).
     *
     * @param args argumentos de línea de comandos (no se usan en este ejemplo).
     */
    public static void main(String[] args) {
        SpringApplication.run(WebfluxMongoApplication.class, args);
    }
}
