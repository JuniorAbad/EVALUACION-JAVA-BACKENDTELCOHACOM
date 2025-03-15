package com.example.webfluxmongo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración para la conexión a MongoDB.
 * <p>
 * Esta clase se basa en propiedades definidas en application.yml (o .properties),
 * específicamente bajo el prefijo "spring.data.mongodb".
 * 
 * Anotaciones:
 * - @Configuration: marca la clase como parte de la configuración de Spring.
 * - @ConfigurationProperties(prefix = "spring.data.mongodb"): indica que las propiedades
 *   que empiezan con "spring.data.mongodb" se inyectarán en los campos de esta clase.
 * - @Data: (de Lombok) genera getters, setters, toString, etc. de forma automática.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoConfig {

    /**
     * URI de conexión a MongoDB, por ejemplo: "mongodb://127.0.0.1:27017".
     */
    private String uri;

    /**
     * Nombre de la base de datos, por ejemplo: "exampleDb".
     */
    private String database;
}
