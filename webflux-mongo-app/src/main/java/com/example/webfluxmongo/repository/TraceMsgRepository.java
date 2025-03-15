package com.example.webfluxmongo.repository;

import com.example.webfluxmongo.model.TraceMsg;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;

/**
 * Repositorio Reactivo para la entidad TraceMsg.
 * <p>
 * Anotaciones y conceptos clave:
 * - Extiende ReactiveMongoRepository<TraceMsg, String> para habilitar
 *   operaciones CRUD (create, read, update, delete) y consultas reactivas
 *   en la base de datos MongoDB.
 * - Permite declarar métodos de consulta personalizados, como findByTsBetween.
 */
public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, String> {

    /**
     * Encuentra todos los documentos (TraceMsg) cuyo campo 'ts' (fecha/hora)
     * esté comprendido entre 'from' y 'to'.
     * <p>
     * Dado que se trata de un repositorio reactivo, el método devuelve un Flux<TraceMsg>,
     * que irá emitiendo los resultados de manera no bloqueante.
     *
     * @param from fecha/hora de inicio (inclusive).
     * @param to   fecha/hora de fin (inclusive).
     * @return Flux<TraceMsg> que emite los mensajes encontrados en ese rango de tiempo.
     */
    Flux<TraceMsg> findByTsBetween(OffsetDateTime from, OffsetDateTime to);
}
