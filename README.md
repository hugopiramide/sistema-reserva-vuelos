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

### Flight y FligthService:

- Un Flight ofrece varios Service

- Un Service puede ser ofrecido en varios Flights

- Relación: Muchos a Muchos (ManyToMany) desde Flight a Service

## Documentación de Endpoints

A continuación se detallan los endpoints disponibles en la API, organizados por controlador.

### Gestión de Aeropuertos (AirportController)
**Base URL:** `/api/airports`

Endpoints para la administración de aeropuertos.

- **Ver todos los aeropuertos** (`GET /`): Devuelve una lista de todos los aeropuertos registrados.
- **Buscar un aeropuerto** (`GET /{id}`): Obtiene los detalles de un aeropuerto específico mediante su ID.
- **Conteo de vuelos** (`GET /{id}/flights/count`): Devuelve el número de vuelos asociados a un aeropuerto específico.
- **Registrar aeropuerto** (`POST /`): Agrega un nuevo aeropuerto a la base de datos.
- **Actualizar datos** (`PUT /{id}`): Actualiza la información de un aeropuerto existente.
- **Eliminar aeropuerto** (`DELETE /{id}`): Elimina un aeropuerto del sistema.

### Gestión de Clientes (ClientController)
**Base URL:** `/api/clients`

Endpoints para la administración de clientes.

- **Listar clientes** (`GET /`): Devuelve una lista de todos los clientes registrados.
- **Detalle de cliente** (`GET /{id}`): Obtiene la información completa de un cliente específico.
- **Viajeros frecuentes** (`GET /by-min-reservations/{min}`): Filtra clientes que tienen más de un número mínimo (`min`) de reservaciones.
- **Nuevo cliente** (`POST /`): Registra a un nuevo cliente en el sistema.
- **Actualizar cliente** (`PUT /{id}`): Actualiza los datos de un cliente existente.
- **Eliminar cliente** (`DELETE /{id}`): Elimina el registro de un cliente.

### Gestión de Vuelos (FlightController)
**Base URL:** `/api/flights`

Endpoints para la administración de vuelos.

- **Ver vuelos** (`GET /`): Devuelve una lista de todos los vuelos programados.
- **Info de vuelo** (`GET /{id}`): Obtiene los detalles de un vuelo específico.
- **Vuelos por cliente** (`GET /by-client/{clientId}`): Devuelve todos los vuelos asociados a un cliente específico.
- **Programar vuelo** (`POST /`): Crea un nuevo vuelo en el sistema.
- **Modificar vuelo** (`PUT /{id}`): Actualiza la información de un vuelo existente.
- **Cancelar vuelo** (`DELETE /{id}`): Elimina un vuelo del sistema.

### Servicios de Vuelo (FlightServiceController)
**Base URL:** `/api/flight-services`

Endpoints para la gestión de posibles servicios adicionales de vuelo.

- **Catálogo de servicios** (`GET /`): Devuelve una lista de todos los servicios disponibles.
- **Detalle de servicio** (`GET /{id}`): Obtiene la información de un servicio específico.
- **Servicios por vuelo** (`GET /by-flight/{flightId}`): Devuelve los servicios ofrecidos en un vuelo específico.
- **Crear servicio** (`POST /`): Agrega un nuevo servicio al catálogo.
- **Actualizar servicio** (`PUT /{id}`): Modifica los detalles de un servicio existente.
- **Eliminar servicio** (`DELETE /{id}`): Elimina un servicio del sistema.

### Reservas (ReservationController)
**Base URL:** `/api/reservations`

Endpoints para la gestión de reservas.

- **Historial de reservas** (`GET /`): Devuelve una lista de todas las reservas realizadas.
- **Consultar reserva** (`GET /{id}`): Obtiene los detalles de una reserva específica.
- **Reservas por aeropuerto** (`GET /by-airport/{airportId}`): Devuelve todas las reservas asociadas a un aeropuerto específico.
- **Hacer reserva** (`POST /`): Crea una nueva reserva para un cliente.
- **Modificar reserva** (`PUT /{id}`): Actualiza una reserva existente.
- **Cancelar reserva** (`DELETE /{id}`): Elimina una reserva del sistema.