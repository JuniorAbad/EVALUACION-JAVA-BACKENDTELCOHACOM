package com.example.webfluxmongo.controller;

import com.example.webfluxmongo.dto.DateRangeRequest;
import com.example.webfluxmongo.model.TraceMsg;
import com.example.webfluxmongo.service.TraceMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

/**
 * Controlador que maneja solicitudes relacionadas con TraceMsg,
 * usando la ruta base "/api/traces".
 * <p>
 * Anotaciones:
 * - @Log4j2: habilita el uso de un logger (log) para registrar eventos y mensajes.
 * - @RestController: marca la clase como un controlador REST para Spring WebFlux.
 * - @RequestMapping("/api/traces"): define la ruta base para los endpoints de este controlador.
 * - @RequiredArgsConstructor: (de Lombok) genera un constructor que recibe los campos final.
 */
@Log4j2
@RestController
@RequestMapping("/api/traces")
@RequiredArgsConstructor
public class TraceController {

    /**
     * Servicio que encapsula la lógica de negocio para TraceMsg,
     * incluyendo inserción y consultas reactivas en MongoDB.
     */
    private final TraceMsgService traceMsgService;

    /**
     * Inserta un TraceMsg en la base de datos.
     * <p>
     * - Establece la marca de tiempo (ts) con OffsetDateTime.now().
     * - Registra en el log la inserción recibida.
     *
     * @param traceMsg objeto TraceMsg que se recibe en el cuerpo de la solicitud (JSON).
     * @return Mono<TraceMsg> que emite el objeto guardado tras completarse la operación.
     */
    @PostMapping("/insert")
    public Mono<TraceMsg> insertTrace(@RequestBody TraceMsg traceMsg) {
        traceMsg.setTs(OffsetDateTime.now());
        log.info("Solicitud de inserción recibida: {}", traceMsg);
        return traceMsgService.insert(traceMsg);
    }

    /**
     * Devuelve los TraceMsg cuyo campo 'ts' esté entre las fechas 'from' y 'to'.
     * <p>
     * - Recibe parámetros 'from' y 'to' como strings en la URL.
     * - Los convierte a OffsetDateTime.
     * - Llama al servicio para buscar registros en el rango.
     *
     * @param from fecha/hora de inicio (en formato string).
     * @param to   fecha/hora de fin (en formato string).
     * @return Flux<TraceMsg> con los documentos encontrados en el rango.
     */
    @GetMapping("/range")
    public Flux<TraceMsg> getTracesInRange(@RequestParam("from") String from,
                                           @RequestParam("to")   String to) {
        log.info("Solicitud de rango recibida de {} a {}", from, to);
        OffsetDateTime fromDate = OffsetDateTime.parse(from);
        OffsetDateTime toDate   = OffsetDateTime.parse(to);
        return traceMsgService.findByDateRange(new DateRangeRequest(fromDate, toDate));
    }
}
