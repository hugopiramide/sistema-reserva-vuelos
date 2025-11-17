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

## Modelo Previsto

<img src="./Model.svg" alt="Modelo de clases">