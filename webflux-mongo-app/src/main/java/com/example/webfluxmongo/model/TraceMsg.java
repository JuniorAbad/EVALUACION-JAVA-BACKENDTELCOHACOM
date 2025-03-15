package com.example.webfluxmongo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

/**
 * Entidad que representa un mensaje de traza (TraceMsg) en la aplicación.
 * <p>
 * Anotaciones:
 * - @Data: (de Lombok) genera automáticamente getters, setters, toString, equals, etc.
 * - @Document(collection = "trace_msgs"): indica que esta clase se mapeará a la colección "trace_msgs" en MongoDB.
 */
@Data
@Document(collection = "trace_msgs")
public class TraceMsg {

    /**
     * Identificador único del documento en MongoDB.
     * Utiliza ObjectId de BSON para almacenar el _id.
     */
    @Id
    private ObjectId _id;

    /**
     * Identificador de sesión, por ejemplo, para asociar el mensaje a una sesión de usuario o de sistema.
     */
    private String sessionId;

    /**
     * Contenido o información del mensaje de traza.
     */
    private String payload;

    /**
     * Marca de tiempo (fecha/hora) asociada al mensaje.
     * Usamos OffsetDateTime para incluir información de zona u offset.
     */
    private OffsetDateTime ts;
}
