/*ESQUEMA:
AGENCIA = (RAZONSOCIAL, dirección, teléfono, e-mail)
CIUDAD = (CODIGOPOSTAL, nombreCiudad, anioCreación)
CLIENTE = (DNI, nombre, apellido, teléfono, dirección, cpLocalidad (FK))
VIAJE = (FECHA, HORA, DNI(FK), cpOrigen(FK), cpDestino(FK), razonSocial(FK), descripción) */

/* AR y SQL */

/*1- Listar apellido y nombre de clientes que viajaron con ciudad destino 'San Miguel del Monte' pero no viajaron con ciudad 
destino 'Las Flores'. En SQL ordenar por apellido y nombre */

SELECT DISTINCT c.apellido,c.nombre
FROM CLIENTE c
INNER JOIN VIAJE  v ON c.DNI = v.dni
INNER JOIN CIUDAD ci ON ci.codigoPostal = v.cpDestino
WHERE ci.nombreCiudad = "San Miguel del Monte" AND c.dni NOT IN (
    SELECT c2.dni
    FROM CLIENTE c2
    INNER JOIN VIAJE  v2 ON c2.DNI = v2.dni
    INNER JOIN CIUDAD c2i ON ci2.codigoPostal = v2.cpDestino
    WHERE ci2.nombreCiudad = "Las Flores"
)

π δ σ ∧ ⨝ ∩

SANMIGEL <= π codigoPostal δ nombreCiudad = "San Miguel del Monte" (CIUDAD)
LASFLORES <= π codigoPostal δ nombreCiudad = "Las Flores" (CIUDAD)
DNISANMIGEL <= π dni δ cpDestino = codigoPostal (SANMIGEL x VIAJE)
DNILASFLORES <= π dni δ cpDestino = codigoPostal (LASFLORES x VIAJE)
RESULT <= π apellido, nombre ((DNISANMIGEL - DNILASFLORES) |x| CLIENTE)

/*2- Listar DNI, apellido y nombre de los clientes que realizaron viajes durante 2017 o que hayan viajado por la agencia ubicada 
en la dirección 50 y 120. En SQL ordenar por apellido y nombre */

SELECT c.dni,c.apellido,c.nombre
FROM CLIENTE c
INNER JOIN VIAJE v ON v.dni = c.dni
INNER JOIN Agencia a ON a.razonSocial = v.razonSocial
WHERE (YEAR(v.fecha) = 2017 OR a.direccion = "50 y 120")
ORDER BY c.apellido,c.nombre 

π δ σ ∧ ⨝ ∩

VIAJES2017 <= π dni δ fecha > 31/12/2016 ^ fecha < 1/1/2018 (CLIENTE |x| VIAJE) 
CINCUEN <= π dni δ direccion = "50 y 120" (VIAJE |X| AGENCIA)
RESULT <= VIAJES2017 U CINCUEN
RESULT <= π dni, apellido, nombre (RESULT |x| CLIENTE)

/*3- Eliminar la agencia con nombre "Los Tilos". */

DELETE FROM VIAJE
WHERE razonSocial = "Los Tilos"

DELETE FROM AGENCIA
WHERE razonSocial = "Los Tilos"

VIAJEAELIMINAR <= δ razonSocial = "Los Tilos" (VIAJE)
VIAJE <= VIAJE - VIAJEAELIMINAR

AGENCIAELIMINAR <= δ razonSocial = "Los Tilos" (AGENCIA)
AGENCIA <= AGENCIA - AGENCIAELIMINAR

/*4- Lista apellido, nombre, teléfono y ciudad de clientes que hayan viajado a "Mar del Plata" y a "Carlos Paz". */

SELECT c.apellido,c.nombre,c.telefono,ci.nombreCiudad
FROM CLIENTE c
INNER JOIN CIUDAD ci ON ci.codigoPostal = c.cpLocalidad
WHERE c.dni IN (
    SELECT v.dni
    FROM VIAJE v
    INNER JOIN CIUDAD ci2 ON ci2.codigoPostal = v.cpDestino
    WHERE ci2.nombreCiudad = "Mar del Plata") AND c.dni IN (
        SELECT v2.dni
        FROM VIAJE v2 
        INNER JOIN CIUDAD ci3 ON ci3.codigoPostal = v2.cpDestino
        WHERE ci3.nombreCiudad = "Carlos Paz"
    )

π δ σ ∧ ⨝ ∩
MARDELPLATA <= π dni σ cpDestino = cpLocalidad  ^ nombreCiudad "Mar del Plata" (VIAJE x CIUDAD)

CARLOS <= π dni σ cpDestino = cpLocalidad  ^ nombreCiudad "Carlos Paz" (VIAJE x CIUDAD)

RESULT <= MARDELPLATA ∩ CARLOS
RESULT <= π apellido,nombre,telefono,nombreCiudad σ cpLocalidad = codigoPostal((RESULT |x| CLIENTE) x CIUDAD)

/*5- Listar las ciudades que no poseen viajes (tanto origen como destino) durante el año 2017. En SQL ordenar por nombre de ciudad. */

SELECT ci.nombreCiudad
FROM CIUDAD ci
WHERE ci.codigoPostal NOT EXISTS (
    SELECT *
    FROM VIAJE v
    WHERE (v.cpDestino = ci.codigoPostal OR v.cpOrigen = ci.codigoPostal) AND YEAR(v.fecha) = 2017
)

CI2017 <= π cpOrigen,cpDestino σ fecha > 31/12/2016 ^ fecha < 1/1/2018 (VIAJE)
CIDADES <= (π cpLocalidad σ cpOrigen = cpLocalidad ci2017 x CIUDAD) U (π cpLocalidad σ cpDestino = cpLocalidadci2017 x CIUDAD)
RESULT <= π nombreCiudad (CIUDAD - (CIUDADES |x| CIUDAD))

/* SQL */

/* 6- Reportar nombre, apellido, dirección y teléfono de clientes con más de 10 viajes. Ordenar por apellido y nombre. */

SELECT c.nombre, c.apellido, c.direccion, c.telefono
FROM CLIENTE c
INNER JOIN VIAJE v ON v.dni = c.dni
GROUP BY c.dni,c.nombre, c.apellido, c.direccion, c.telefono
HAVING COUNT(v.fecha) > 10
ORDER BY c.apellido,c.nombre

/*7- Listar razón social, dirección y teléfono de las agencias que registren viajes (tener en cuenta solo los destinos) a todas las ciudades. */

SELECT a.razonSocial,a.direccion,a.telefono
FROM AGENCIA a
WHERE NOT EXISTS (
    SELECT *
    FROM CIUDAD ci
    WHERE NOT EXISTS (
        SELECT *
        FROM VIAJE V
        WHERE v.cpDestino = ci.ciudad AND v.razonSocial = a.razonSocial
    ) 
)
