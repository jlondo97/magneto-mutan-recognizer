# magneto-mutan-recognizer

El analizador de cadenas de ADN para posibles nuevos integrantes del ejercito de Magneto es un proyecto encargado de analizar y obtener individuos donde las cadenas de ADN se encuentren genes mutantantes , separando los mutantantes de simples humanos ademas dando respuesta en  servicio REST si eres humano o mutante (/mutant) y cual es el porcentaje de mutantes en el total de cadenas evaluadas (/stats) 


## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Mira **Deployment** para conocer como desplegar el proyecto.

### Pre-requisitos 📋

¿Que cosas necesitas para instalar el software y como instalarlas 
Necesitas lo siguiente


* [Gradle 7.0 ](https://gradle.org/) - Manejador de dependencias
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)-Lenguaje programacion y version
* [Postgres](https://www.postgresql.org/)-Motor Base de datos
* [Docker](https://www.docker.com/products/docker-desktop/)
* [Postman](https://www.postman.com/downloads/)



### Instalación 🔧

Una serie de paso a paso que te dice lo que debes ejecutar para tener un entorno de desarrollo local.

Luego de instalar todos los prerequisitos inciamos con la configuracion del ambiente local 

###Paso 1: Configuracion del docker para alojar postgres en un contendor y poder acceder a la base de datos facilmente 

[Guia paso a paso intalacion de postgres y pgAdmin en docker](https://dev.to/shree_j/how-to-install-and-run-psql-using-docker-41j2)

recuerda cambiar la url y las credenciales que  creaste en el alojamiento de postgres en docker , los cambio se realizan en el archivo application.propertis


###Paso 2: luego en el directorio del proyecto (root) abriremos nuestra terminal preferida y ejecutaremos el siguiente comando para la ejecucion del proyecto

```
Para windows
$ gradlew bootRun 

Para linux 
$./gradleW bootRun
```

Asi finalizamos la instalacion del ambiente local para el proyecto ahora puedes usar los servicios expuesto <url>:<puerto>/<servicio> te recomiendo usar postman para generar las peticiones 


## Construido con 🛠️

* [spring boot](https://spring.io/projects/spring-boot) - El framework web usado
* [Gradle 7.0](https://gradle.org/) - Manejador de dependencias
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)-Lenguaje programacion y version
* [Postgres](https://www.postgresql.org/)-Motor Base de datos

## Autores ✒️

* **Andrés Jhoany Londoño Toro ** - *Trabajo Inicial*  

