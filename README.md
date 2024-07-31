
# Estadisticas-pro

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

## Características Clave
- **Registro de Productos Creados**: Registrar productos creados por categoría.
- **Obtención de Estadísticas**: Obtener estadísticas de productos creados por categoría.
- **Seguridad**: Autenticación básica con Spring Security.
- **Persistencia de Datos**: Uso de JPA y base de datos H2 para almacenamiento de datos.
- **Manejo de Excepciones**: Manejo centralizado de excepciones mediante `GlobalExceptionHandler`.

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

## Uso
Una vez que la aplicación esté en ejecución, puede acceder a los endpoints definidos para gestionar las estadísticas de productos.

### Credenciales de Seguridad auth
- **Usuario**: \`estadisticas\`
- **Contraseña**: \`1234\`

## Endpoints
- \`POST /api/estadisticas/registrar?categoria={categoria}\`: Registrar un producto creado en una categoría.
- \`GET /api/estadisticas?categoria={categoria}\`: Obtener estadísticas de productos creados por categoría.

## Manejo de Excepciones
El proyecto incluye un manejo centralizado de excepciones utilizando `GlobalExceptionHandler`, que maneja las siguientes excepciones:
- \`ResourceNotFoundException\`
- Excepciones generales (\`Exception\`)

