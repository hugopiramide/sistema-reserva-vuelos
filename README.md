## Relaciones entre Entidades

### Flight y Airport (Origen/Destino):

- Un Flight tiene un único aeropuerto de origen (originAirport).

- Un Flight tiene un único aeropuerto de destino (destinationAirport).

- Un Airport puede ser el origen o destino de muchos vuelos.

- Relación: Muchos a Uno (ManyToOne) en ambos casos desde Flight a Airport.

### Client y Flight --> Reservation:

- Un Client puede tener muchas Reservation a lo largo del tiempo

- Un Flight también puede tener muchas Reservation a lo largo del tiempo

- Relación: Mucho a Uno (ManyToOne) tanto en Client como en Flight, creando así un tabla con información 

### Flight y Service:

- Un Flight ofrece varios Service

- Un Service puede ser ofrecido en varios Flights

- Relación: Muchos a Muchos (ManyToMany) desde Flight a Service

## Requisitos previos

Asegúrate de tener instalado:

- <a href="https://docs.docker.com/get-docker/" target="_blank">Docker</a>
- Docker compose (incluido con Docker Desktop)
- Git para clonar el repositorio

### Puedes verificar la instalacion ejecutando : 

```
docker --version 
docker compose version
```

## Configurar variables de entorno (.env)
El proyecto utiliza un archivo `.env` para configurar valores importantes como:

- Credenciales de base de datos
- Puertos expuestos
- Nombre de las imágenes

Antes de iniciar Docker, crea un archivo `.env` en la raíz del proyecto basado en el archivo de ejemplo:

```
# CONFIGURACIÓN DE MYSQL

MYSQL_ROOT_PASSWORD=1234
MYSQL_DATABASE=airbooking
MYSQL_USER=root
MYSQL_PASSWORD=1234

# CONFIGURACIÓN DE SPRING BOOT

SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/airbooking?createDatabaseIfNotExist=true &
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=1234
APP_PORT=8080
```
## Cómo iniciar el proyecto

Para levantar todos los servicios:

```
docker compose up -d --build
```
Para revisar logs: 

- Logs del escenario

```
docker compose logs -f
```

- Logs en especifico

```
docker compose logs -f spring-app
```

## Modelo Previsto

<img src="./Model.svg" alt="Modelo de clases">
