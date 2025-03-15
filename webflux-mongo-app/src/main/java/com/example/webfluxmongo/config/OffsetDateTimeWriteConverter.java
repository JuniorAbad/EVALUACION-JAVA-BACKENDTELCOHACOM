package com.example.webfluxmongo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Convertidor para escribir (almacenar) campos de tipo OffsetDateTime en MongoDB.
 * <p>
 * Al guardar documentos que contienen un OffsetDateTime, Spring Data MongoDB
 * no sabe manejar directamente ese tipo, así que este convertidor
 * lo transforma a java.util.Date, que sí es soportado por defecto.
 *
 * Anotaciones:
 * - @WritingConverter: indica que es un convertidor de escritura (Writing Converter),
 *   usado cuando se almacena un objeto en la base de datos.
 * - @Component: registra la clase como bean de Spring para que sea detectada
 *   y usada automáticamente por el sistema de conversiones de Spring Data.
 */
@WritingConverter
@Component
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {

    /**
     * Convierte un OffsetDateTime en un Date.
     *
     * @param source objeto OffsetDateTime a convertir.
     * @return Date resultante, que Spring Data MongoDB puede almacenar.
     */
    @Override
    public Date convert(OffsetDateTime source) {
        // Toma la parte Instant de OffsetDateTime y crea un Date a partir de ella
        return Date.from(source.toInstant());
    }
}
