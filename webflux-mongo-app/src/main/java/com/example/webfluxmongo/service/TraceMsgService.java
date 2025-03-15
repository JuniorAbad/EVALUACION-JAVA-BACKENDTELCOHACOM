package com.example.webfluxmongo.service;

import com.example.webfluxmongo.dto.DateRangeRequest;
import com.example.webfluxmongo.model.TraceMsg;
import com.example.webfluxmongo.repository.TraceMsgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio encargado de la lógica de negocio relacionada con los mensajes de trazas (TraceMsg).
 * <p>
 * Anotaciones:
 * - @Service: indica que esta clase forma parte de la capa de servicios en la arquitectura de la aplicación.
 * - @Log4j2: habilita la generación de un logger para registrar eventos en el servicio.
 * - @RequiredArgsConstructor: de Lombok, genera un constructor con todos los campos marcados como final.
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class TraceMsgService {

    /**
     * Repositorio para gestionar las operaciones CRUD (create, read, update, delete)
     * de la entidad TraceMsg en la base de datos MongoDB.
     */
    private final TraceMsgRepository repository;

    /**
     * Inserta un mensaje de traza (TraceMsg) en la base de datos.
     * <p>
     * Registra un log de nivel INFO con el contenido del mensaje que se va a insertar.
     *
     * @param traceMsg objeto TraceMsg que se desea persistir.
     * @return Mono<TraceMsg> que emite el objeto guardado tras completarse la operación.
     */
    public Mono<TraceMsg> insert(TraceMsg traceMsg) {
        log.info("Insertando mensaje de rastreo: {}", traceMsg);
        return repository.save(traceMsg);
    }

    /**
     * Busca mensajes de traza (TraceMsg) en un rango de fechas.
     * <p>
     * Registra un log de nivel INFO indicando el rango solicitado. Luego,
     * delega al repositorio la búsqueda por el campo ts entre 'from' y 'to'.
     *
     * @param request objeto DateRangeRequest con las fechas 'from' y 'to'.
     * @return Flux<TraceMsg> que emite los mensajes encontrados en el rango de fechas.
     */
    public Flux<TraceMsg> findByDateRange(DateRangeRequest request) {
        log.info("Buscando rastros desde {} hasta {}", request.getFrom(), request.getTo());
        return repository.findByTsBetween(request.getFrom(), request.getTo());
    }
}
