# Proyecto de Autenticación JWT con Spring Boot 3

Este proyecto demuestra cómo implementar una API REST utilizando Spring Boot 3 con autenticación basada en JWT (JSON Web Tokens). Permite registrar usuarios, iniciar sesión y verificar autenticación con roles.

## Características
- **Spring Boot 3**: Potente framework para construir aplicaciones.
- **JWT**: Manejo seguro de autenticación y autorización.
- **Validación**: Uso de DTOs y validaciones con anotaciones.
- **Registro y autenticación**: Endpoints para registrar usuarios y obtener un token JWT.

---

# JWT Authentication Project with Spring Boot 3

This project showcases how to implement a REST API using Spring Boot 3 with JWT-based authentication. It enables user registration, login, and authentication verification with roles.

## Features
- **Spring Boot 3**: A powerful framework for building applications.
- **JWT**: Secure handling of authentication and authorization.
- **Validation**: Use of DTOs and validation annotations.
- **User Registration and Authentication**: Endpoints for user signup and obtaining JWT tokens.

---

## Endpoints

### `POST /login`
- **Descripción / Description**:
  - **ES:** Autentica a un usuario registrado mediante sus credenciales (nombre de usuario y contraseña) y devuelve un token JWT.
  - **EN:** Authenticates a registered user via their credentials (username and password) and returns a JWT token.

- **Request Body**:
  ```json
  {
    "userName": "string",
    "password": "string"
  }
  ```

- **Responses**:
  - `200 OK`: Devuelve el token JWT.
  - `400 Bad Request`: Credenciales inválidas o errores en los datos.

### `POST /register`
- **Descripción / Description**:
  - **ES:** Registra un nuevo usuario con los datos proporcionados.
  - **EN:** Registers a new user with the provided data.

- **Request Body**:
  ```json
  {
    "userName": "string",
    "password": "string",
  }
  ```

- **Responses**:
  - `201 Created`: Usuario registrado exitosamente.
  - `400 Bad Request`: Campos inválidos o el usuario ya existe.

### `GET /check-auth`
- **Descripción / Description**:
  - **ES:** Verifica si el usuario autenticado tiene acceso.
  - **EN:** Checks if the authenticated user has access.

- **Responses**:
  - `200 OK`: Usuario autenticado.
- `401 unauthorized`: Usuario no autenticado.
---

## Requisitos / Requirements
- Java 17+
- Maven 3.6+
- Postman o cualquier cliente para probar la API.

---

## Instalación / Installation

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/SaulM12/LastSpringSecurityJWT.git
   ```

2. Configurar las propiedades de la aplicación en `application.properties`.

3. Construir y ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

---

## Tutorial

• Mira el tutorial completo en este enlace: 

