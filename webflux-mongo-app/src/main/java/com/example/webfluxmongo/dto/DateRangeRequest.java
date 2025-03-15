package com.example.webfluxmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

/**
 * DTO (Data Transfer Object) que representa una solicitud de rango de fechas.
 * <p>
 * Usado para delimitar un rango (from - to) al buscar registros o mensajes
 * cuyo campo de fecha/hora (ts) esté dentro de este intervalo.
 *
 * Anotaciones:
 * - @Data: (de Lombok) genera automáticamente getters, setters, toString, equals, etc.
 * - @AllArgsConstructor: (de Lombok) crea un constructor que recibe todos los campos.
 * - @NotNull: valida que los campos no sean nulos cuando se use, por ejemplo, con @Valid.
 */
@Data
@AllArgsConstructor
public class DateRangeRequest {

    /**
     * Fecha/hora de inicio del rango.
     * <p>
     * @NotNull indica que no debe ser nulo al momento de la validación.
     */
    @NotNull
    private OffsetDateTime from;

    /**
     * Fecha/hora de fin del rango.
     * <p>
     * @NotNull indica que no debe ser nulo al momento de la validación.
     */
    @NotNull
    private OffsetDateTime to;
}
