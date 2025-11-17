## Relaciones entre Entidades

### Flight y Airport (Origen/Destino):

- Un Flight tiene un único aeropuerto de origen (originAirport).

- Un Flight tiene un único aeropuerto de destino (destinationAirport).

- Un Airport puede ser el origen o destino de muchos vuelos.

- Relación: Muchos a Uno (ManyToOne) en ambos casos desde Flight a Airport.

### Reservation y Flight:

- Una Reservation está ligada a un único Flight.

- Un Flight puede tener muchas Reservation asociadas.

- Relación: Muchos a Uno (ManyToOne) desde Reservation a Flight.

## Modelo Previsto

<img src="./Model.svg" alt="Modelo de clases">