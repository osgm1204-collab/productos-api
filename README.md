# API de Productos

API REST para gestionar productos (CRUD), hecha con Spring Boot. Es mi primer proyecto backend.

## Tecnologías

- Java 21
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## Arquitectura

El proyecto sigue una arquitectura en capas:

```
Controller → Service → Repository → Base de datos
```

- **Controller:** recibe las peticiones HTTP.
- **Service:** contiene la lógica de negocio.
- **Repository:** accede a la base de datos con Spring Data JPA.
- **Producto:** entidad que se mapea a la tabla `PRODUCTO`.

## Cómo ejecutarlo

1. Clona el repositorio.
2. Ábrelo con IntelliJ IDEA (JDK 21).
3. Ejecuta `ProductosApplication`.
4. La API queda en `http://localhost:8081`.

La consola de H2 está en `http://localhost:8081/h2-console`
(JDBC URL: `jdbc:h2:mem:tienda`, usuario: `sa`, sin contraseña).

> La base de datos es en memoria: los datos se borran al apagar la app.

## Endpoints

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | `/productos` | Lista todos los productos |
| POST | `/productos` | Crea un producto |
| PUT | `/productos/{id}` | Actualiza un producto |
| DELETE | `/productos/{id}` | Elimina un producto |

### Ejemplo de JSON

```json
{
  "nombre": "Playera",
  "precio": 199
}
```

## Pendiente

- Validaciones y manejo de errores (404)
- DTOs
- Migrar de H2 a MySQL
- Seguridad con Spring Security y JWT