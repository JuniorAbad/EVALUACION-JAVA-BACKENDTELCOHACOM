package com.example.webfluxmongo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración personalizada para la aplicación, basada en propiedades definidas con el prefijo "app".
 * <p>
 * Anotaciones:
 * - @Configuration: indica que esta clase forma parte de la configuración de Spring.
 * - @ConfigurationProperties(prefix = "app"): inyecta propiedades que comienzan con "app" en el archivo de configuración (application.yml, etc.).
 * - @Data: (de Lombok) genera getters, setters, toString, etc.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    /**
     * Nombre de la base de datos de MongoDB, tomado de "app.mongodbDatabase" en el archivo de configuración.
     */
    private String mongodbDatabase;

    /**
     * URI de conexión a MongoDB, tomado de "app.mongodbUri" en el archivo de configuración.
     */
    private String mongodbUri;

    /**
     * Puerto en el que se ejecutará la API, tomado de "app.apiPort" en el archivo de configuración.
     */
    private int apiPort;
}
