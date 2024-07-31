
# estadisticas-pro

## Descripción General
`estadisticas-pro` es un proyecto de demostración para AgendaPro-Estadisticas, diseñado para registrar y obtener estadísticas de productos creados por categoría. Este proyecto está construido utilizando Spring Boot, con varias integraciones para seguridad, persistencia de datos y funcionalidades web.

## Tabla de Contenidos
1. [Tecnologías Utilizadas](#tecnologías-utilizadas)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Características Clave](#características-clave)
4. [Arquitectura](#arquitectura)
5. [Configuración e Instalación](#configuración-e-instalación)
6. [Uso](#uso)
7. [Endpoints](#endpoints)
8. [Manejo de Excepciones](#manejo-de-excepciones)
9. [Contribuciones](#contribuciones)
10. [Licencia](#licencia)

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.3.2**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security
  - Spring Boot Starter Web
  - Spring Boot DevTools
- **Base de Datos H2** (runtime)
- **Project Lombok**
- **Mockito** (4.3.1)
- **Maven**
- **Docker**

## Estructura del Proyecto
\`\`\`plaintext
src/main/java/com/estadisticaspro
├── config
│   └── SecurityConfig.java
├── controller
│   └── EstadisticaController.java
├── exception
│   └── ResourceNotFoundException.java
├── exceptionmanager
│   └── GlobalExceptionHandler.java
├── model
│   └── Estadistica.java
├── repository
│   └── EstadisticaRepository.java
└── service
    └── EstadisticaService.java
\`\`\`

## Características Clave
- **Registro de Productos Creados**: Registrar productos creados por categoría.
- **Obtención de Estadísticas**: Obtener estadísticas de productos creados por categoría.
- **Seguridad**: Autenticación básica con Spring Security.
- **Persistencia de Datos**: Uso de JPA y base de datos H2 para almacenamiento de datos.
- **Manejo de Excepciones**: Manejo centralizado de excepciones mediante `GlobalExceptionHandler`.

## Arquitectura
El diagrama de arquitectura a continuación muestra los componentes principales y su interacción:

![Arquitectura](./docs/arquitectura_estadisticas.png)

### Descripción del Diagrama
1. **Controlador (`EstadisticaController`)**: Gestiona las solicitudes HTTP y coordina con el servicio de estadísticas.
2. **Servicio (`EstadisticaService`)**: Contiene la lógica de negocio para la gestión de estadísticas.
3. **Repositorio (`EstadisticaRepository`)**: Interactúa con la base de datos para las operaciones CRUD.
4. **Manejo de Excepciones (`GlobalExceptionHandler`)**: Captura y maneja las excepciones de manera centralizada.
5. **Configuraciones**: Configuración de seguridad (`SecurityConfig`).

## Configuración e Instalación
1. Clonar el repositorio:
    \`\`\`bash
    git clone https://github.com/tu_usuario/estadisticas-pro.git
    \`\`\`
2. Navegar al directorio del proyecto:
    \`\`\`bash
    cd estadisticas-pro
    \`\`\`
3. Construir el proyecto con Maven:
    \`\`\`bash
    mvn clean install
    \`\`\`
4. Ejecutar la aplicación:
    \`\`\`bash
    mvn spring-boot:run
    \`\`\`

### Usando Docker
1. Construir la imagen Docker:
    \`\`\`bash
    docker build -t estadisticas-pro .
    \`\`\`
2. Ejecutar el contenedor:
    \`\`\`bash
    docker run -p 8080:8080 estadisticas-pro
    \`\`\`

## Dockerfile
\`\`\`dockerfile
# Etapa 1: Construcción
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias necesarias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto de los archivos del proyecto y construye el JAR
COPY src ./src
RUN mvn clean package

# Etapa 2: Ejecución
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia el JAR construido en la etapa de construcción
COPY --from=build /app/target/estadisticas-pro-0.0.1-SNAPSHOT.jar /app/estadisticas-pro-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/estadisticas-pro-0.0.1-SNAPSHOT.jar"]
\`\`\`

## Uso
Una vez que la aplicación esté en ejecución, puede acceder a los endpoints definidos para gestionar las estadísticas de productos.

### Credenciales de Seguridad
- **Usuario**: \`estadisticas\`
- **Contraseña**: \`1234\`

## Endpoints
- \`POST /api/estadisticas/registrar?categoria={categoria}\`: Registrar un producto creado en una categoría.
- \`GET /api/estadisticas?categoria={categoria}\`: Obtener estadísticas de productos creados por categoría.

## Manejo de Excepciones
El proyecto incluye un manejo centralizado de excepciones utilizando `GlobalExceptionHandler`, que maneja las siguientes excepciones:
- \`ResourceNotFoundException\`
- Excepciones generales (\`Exception\`)

## Contribuciones
Las contribuciones son bienvenidas. Por favor, siga estos pasos:
1. Haga un fork del repositorio.
2. Cree una rama para su característica (\`git checkout -b feature/nueva-caracteristica\`).
3. Realice un commit de sus cambios (\`git commit -am 'Añadir nueva característica'\`).
4. Haga push a la rama (\`git push origin feature/nueva-caracteristica\`).
5. Cree un nuevo Pull Request.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT - vea el archivo [LICENSE](LICENSE) para más detalles.
