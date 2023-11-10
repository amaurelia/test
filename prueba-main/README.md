# Prueba de API REST para crear un usuario

Servicio backend desarrollado en Java/SpringBoot para demostrar conocimientos en una prueba técnica.
El servicio sirve para crear un usuario nueva en la base de datos.
Los datos de acceso a la base de datos están en application.properties.
Por defecto las credenciales son root y sin password.
Al iniciar el servicio este creará automáticamente las tablas de la base de datos, estas requieren que exista una base de datos con el esquema test.

## Requerimientos

* **JDK para Java SE 8** 
* **Maven**
* **Base de datos SQL con el esquema test**

## Instalación de dependencias

Las dependencias están en maven, en el pom.xml.
Para instalarlas debe usar el comando:
`mvn clean install`.

## Ejecución de la aplicación

Se ejecuta con el comando `mvn spring-boot::run` desde el directorio raíz del proyecto.

## Servicio

El servicio backend se encuentra alojado en el puerto `8231`, y se puede acceder en POST `http://localhost:8231/users/save`.
Debe ingresar un body similar a 

{
  "name": "string",
  "email": "string",
  "password": "string",
  "isactive": true,
  "phones": [
    {
      "number": "string",
      "citycode": "string",
      "contrycode": "string"
    },
    {
      "number": "string",
      "citycode": "string",
      "contrycode": "string"
    }
  ]
}

La respuesta tendrá el formato 

{
  "mensaje": "string"
}

## Arquitectura del servicio

El controlador del servicio se encuentra en la carpeta controller.
Las entidades (que se homologan en la base de datos) se encuentran dentro de la carpeta entity.
Las implementaciones de JPARepository se encuentran en la carpeta repository.
Los DTO se encuentran en una carpeta con ese mismo nombre.
El controlador llama a una interface llamada UserService, la cual es implementada en la carpeta Impl.

## Swagger

El servicio cuenta con un Swagger que puede ser accedido desde el navegador en `http://localhost:8231/swagger-ui/index.html`.
