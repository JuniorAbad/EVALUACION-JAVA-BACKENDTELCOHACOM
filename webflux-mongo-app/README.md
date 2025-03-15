# Autor: JUAN JUNIOR ABAD YACILA
# Fecha Creación: 15-03-2025

# Proyecto Spring Boot WebFlux + MongoDB + Log4j2 + Actuator (Prometheus)

Este proyecto consiste en una **API REST** desarrollada con **Spring Boot** que implementa un modelo de **programación reactiva** (usando **Spring WebFlux**) para interactuar con **MongoDB** de forma no bloqueante. Además, se integra **Log4j2** para el manejo de logs y **Spring Actuator** para exponer métricas y endpoints de monitoreo, incluyendo **Prometheus**. Toda la configuración se realiza en un único archivo `application.yml`, evitando `application.properties`.

---

## Tabla de Contenidos
1. [Requerimientos y Tecnologías](#requerimientos-y-tecnologías)  
2. [Características Principales](#características-principales)  
3. [Estructura del Proyecto](#estructura-del-proyecto)  

---

## 1. Requerimientos y Tecnologías

### **Requerimientos:**
- **Gradle** como sistema de construcción (puede usarse Maven, pero se recomienda Gradle).
- **Java 8** como versión mínima del lenguaje.
- **MongoDB** instalado y corriendo (por defecto en `mongodb://127.0.0.1:27017`).
- **Archivo `application.yml`** para configurar todo (en vez de `application.properties`).

### **Tecnologías Utilizadas:**
1. **Gradle**  
2. **Java 8**  
3. **Spring Boot** (versión recomendada: 2.4.3)  
4. **Spring Data MongoDB Reactivo**  
5. **Spring WebFlux**  
6. **Spring Log4j2** (excluyendo Logback)  
7. **Spring Actuator** (exponiendo métricas a Prometheus)  
8. **Validación** con Spring (anotaciones como `@NotNull`)  
9. **Lombok** (opcional, para reducir código repetitivo)

---

## 2. Características Principales
- **Programación Reactiva** con **Spring WebFlux** y servidor embebido (Netty).
- **Persistencia** en MongoDB de forma **no bloqueante** (reactivo).
- **Exposición de Métricas** con Actuator y Prometheus.
- **Logs** configurados con **Log4j2** mediante un archivo `log4j2.yml`.
- **Endpoints**:
  - `POST` para insertar un `TraceMsg`.

  JSON:

    {
      "sessionId": "abc123",
      "payload": "Mensaje de prueba"
    }

    http://localhost:9898/api/traces/insert

  - `GET` para consultar un rango de fechas.

  http://localhost:9898/api/traces/range?from=2025-01-01T00:00:00Z&to=2025-12-31T23:59:59Z

- **Contador** `hacom.test.developer.insert.rx` que se incrementa en cada inserción.
- **Toda la configuración** en `application.yml`, incluyendo puerto (`apiPort=9898`), URI y DB de MongoDB, ajustes de logging y Actuator.

---

##  3. Estructura del Proyecto
css
Copiar
Editar
.
├── build.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.webfluxmongo
│   │   │       ├── WebfluxMongoApplication.java
│   │   │       ├── config
│   │   │       │   ├── MongoConfig.java
│   │   │       │   ├── AppConfig.java
│   │   │       │   └── ...
│   │   │       ├── controller
│   │   │       │   ├── TraceController.java
│   │   │       │   └── ...
│   │   │       ├── dto
│   │   │       │   └── DateRangeRequest.java
│   │   │       ├── model
│   │   │       │   └── TraceMsg.java
│   │   │       ├── repository
│   │   │       │   └── TraceMsgRepository.java
│   │   │       └── service
│   │   │           └── TraceMsgService.java
│   │   └── resources
│   │       ├── application.yml
│   │       └── log4j2.yml
└── ...

