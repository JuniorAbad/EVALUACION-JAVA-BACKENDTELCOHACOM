package com.example.webfluxmongo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

/**
 * Configuración de convertidores personalizados para MongoDB.
 * <p>
 * Esta clase registra los convertidores de lectura y escritura que
 * permiten a Spring Data MongoDB manejar campos de tipo OffsetDateTime,
 * transformándolos a Date y viceversa.
 *
 * Anotaciones:
 * - @Configuration: indica que esta clase declara beans para el contexto de Spring.
 * - @RequiredArgsConstructor: (de Lombok) genera un constructor con los campos final.
 */
@Configuration
@RequiredArgsConstructor
public class MongoConvertersConfig {

    /**
     * Convertidor de escritura: OffsetDateTime -> Date
     */
    private final OffsetDateTimeWriteConverter offsetDateTimeWriteConverter;

    /**
     * Convertidor de lectura: Date -> OffsetDateTime
     */
    private final OffsetDateTimeReadConverter offsetDateTimeReadConverter;

    /**
     * Registra los convertidores personalizados en MongoCustomConversions.
     * <p>
     * De esta manera, Spring Data MongoDB usará dichos convertidores
     * al guardar (writing) y leer (reading) documentos que contengan
     * campos de tipo OffsetDateTime.
     *
     * @return un bean de tipo MongoCustomConversions con los convertidores agregados.
     */
    @Bean
    public MongoCustomConversions customConversions() {
        // Agrega los convertidores en una lista
        return new MongoCustomConversions(Arrays.asList(
            offsetDateTimeWriteConverter,
            offsetDateTimeReadConverter
        ));
    }
}
