package com.example.webfluxmongo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Convertidor para leer (recuperar) campos de tipo Date desde MongoDB
 * y transformarlos a OffsetDateTime en la aplicación.
 * <p>
 * Spring Data MongoDB, por defecto, maneja Date para representar campos de fecha.
 * Este convertidor permite que esos Date se conviertan en OffsetDateTime
 * para ser usados en el modelo de dominio.
 *
 * Anotaciones:
 * - @ReadingConverter: indica que es un convertidor de lectura (Reading Converter),
 *   usado cuando se recupera un objeto de la base de datos.
 * - @Component: registra la clase como bean de Spring para que sea detectada
 *   y utilizada por el sistema de conversiones de Spring Data.
 */
@ReadingConverter
@Component
public class OffsetDateTimeReadConverter implements Converter<Date, OffsetDateTime> {

    /**
     * Convierte un objeto Date (devuelto por MongoDB) en un OffsetDateTime.
     *
     * @param source objeto Date que se leyó de la base de datos.
     * @return OffsetDateTime resultante, que se usará en la aplicación.
     */
    @Override
    public OffsetDateTime convert(Date source) {
        // Ajusta el offset según la zona horaria actual
        // (puedes personalizarlo si necesitas un offset/zone distinto).
        return source.toInstant().atOffset(OffsetDateTime.now().getOffset());
    }
}
