-- Airports
INSERT INTO airport (airport_id, name, location, country) VALUES (1, 'Aeropuerto A', 'Ciudad Uno', 'País Uno');
INSERT INTO airport (airport_id, name, location, country) VALUES (2, 'Aeropuerto B', 'Ciudad Dos', 'País Dos');
INSERT INTO airport (airport_id, name, location, country) VALUES (3, 'Aeropuerto C', 'Ciudad Tres', 'País Tres');
INSERT INTO airport (airport_id, name, location, country) VALUES (4, 'Aeropuerto D', 'Ciudad Cuatro', 'País Cuatro');
INSERT INTO airport (airport_id, name, location, country) VALUES (5, 'Aeropuerto E', 'Ciudad Cinco', 'País Cinco');


-- Clients
INSERT INTO client (client_id, name, first_name, email) VALUES (1, 'Perez', 'Juan', 'juan@email.com');
INSERT INTO client (client_id, name, first_name, email) VALUES (2, 'Gomez', 'Maria', 'maria@email.com');
INSERT INTO client (client_id, name, first_name, email) VALUES (3, 'Ruiz', 'Carlos', 'carlos@email.com');
INSERT INTO client (client_id, name, first_name, email) VALUES (4, 'Torres', 'Ana', 'ana@email.com');
INSERT INTO client (client_id, name, first_name, email) VALUES (5, 'Fernandez', 'Luis', 'luis@email.com');


-- Flights
INSERT INTO flight (flight_id, origin_airport_id, destination_airport_id, departure_time, arrival_time, passengers, available_seats) VALUES (1, 1, 2, '2025-11-20T08:00:00', '2025-11-20T10:00:00', 120, 20);
INSERT INTO flight (flight_id, origin_airport_id, destination_airport_id, departure_time, arrival_time, passengers, available_seats) VALUES (2, 2, 3, '2025-11-21T09:00:00', '2025-11-21T11:00:00', 100, 15);
INSERT INTO flight (flight_id, origin_airport_id, destination_airport_id, departure_time, arrival_time, passengers, available_seats) VALUES (3, 3, 4, '2025-11-22T12:00:00', '2025-11-22T14:00:00', 80, 10);
INSERT INTO flight (flight_id, origin_airport_id, destination_airport_id, departure_time, arrival_time, passengers, available_seats) VALUES (4, 4, 5, '2025-11-23T15:00:00', '2025-11-23T17:00:00', 150, 30);
INSERT INTO flight (flight_id, origin_airport_id, destination_airport_id, departure_time, arrival_time, passengers, available_seats) VALUES (5, 5, 1, '2025-11-24T18:00:00', '2025-11-24T20:00:00', 90, 5);


-- Flight Services
INSERT INTO service (service_id, name, description) VALUES (1, 'Comida', 'Servicio de comida a bordo');
INSERT INTO service (service_id, name, description) VALUES (2, 'WiFi', 'Internet inalámbrico');
INSERT INTO service (service_id, name, description) VALUES (3, 'Entretenimiento', 'Pantallas individuales');
INSERT INTO service (service_id, name, description) VALUES (4, 'Asiento Premium', 'Mayor espacio y comodidad');
INSERT INTO service (service_id, name, description) VALUES (5, 'Equipaje Extra', 'Maleta adicional incluida');


-- Reservations
INSERT INTO reservation (reservation_id, booking_date, status, flight_id, client_id) VALUES (1, '2025-11-19T10:00:00', 'CONFIRMED', 1, 1);
INSERT INTO reservation (reservation_id, booking_date, status, flight_id, client_id) VALUES (2, '2025-11-19T11:00:00', 'CONFIRMED', 2, 2);
INSERT INTO reservation (reservation_id, booking_date, status, flight_id, client_id) VALUES (3, '2025-11-19T12:00:00', 'CANCELLED', 3, 3);
INSERT INTO reservation (reservation_id, booking_date, status, flight_id, client_id) VALUES (4, '2025-11-19T13:00:00', 'CONFIRMED', 4, 4);
INSERT INTO reservation (reservation_id, booking_date, status, flight_id, client_id) VALUES (5, '2025-11-19T14:00:00', 'CONFIRMED', 5, 5);


-- ManyToMany: Flight <-> Service
INSERT INTO service_flight (flight_id, service_id) VALUES (1, 1);
INSERT INTO service_flight (flight_id, service_id) VALUES (1, 2);
INSERT INTO service_flight (flight_id, service_id) VALUES (2, 2);
INSERT INTO service_flight (flight_id, service_id) VALUES (2, 3);
INSERT INTO service_flight (flight_id, service_id) VALUES (3, 3);
INSERT INTO service_flight (flight_id, service_id) VALUES (3, 4);
INSERT INTO service_flight (flight_id, service_id) VALUES (4, 4);
INSERT INTO service_flight (flight_id, service_id) VALUES (4, 5);
INSERT INTO service_flight (flight_id, service_id) VALUES (5, 5);
INSERT INTO service_flight (flight_id, service_id) VALUES (5, 1);
