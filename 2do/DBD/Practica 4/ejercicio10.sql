/* Ejercicio 10 
Vehiculo = (patente, modelo, marca, peso, km) 
Camion = (patente(fk), largo, max_toneladas, cant_ruedas, tiene_acoplado) 
Auto = (patente(fk), es_electrico, tipo_motor) 
Service = (fecha, patente(fk), km_service, descripcion, monto) 
Parte = (cod_parte, nombre, precio_parte) 
Service_Parte = ([fecha, patente](fk), cod_parte(fk), precio) */

/* 1. Listar todos los datos de aquellos camiones que tengan entre 4 y 8 ruedas, y que hayan 
realizado algún service en los últimos 365 días. Ordenar por marca, modelo y patente. */

SELECT c.patente, c.largo, c.max_toneladas, c.cant_ruedas, c.tiene_acoplado
FROM Camion c
INNER JOIN Service s ON s.patente = c.patente
INNER JOIN Vehiculo V ON v.patente = c.patente
WHERE c.cant_ruedas BETWEEN 4 AND 8 AND S.fecha >= DATE_SUB(CURRENT_DATE(), INTERVAL 365 DAY)

/* 2. Listar los autos que hayan realizado el service “cambio de aceite” antes de los 13.000 km o 
hayan realizado el service “inspección general” que incluya la parte “filtro de combustible”. */

SELECT v.patente
INNER JOIN Service s ON s.patente = v.patente
WHERE s.km_service < 13.000 AND s.descripcion = "cambio de aceite"
UNION
SELECT v.patente
INNER JOIN Service s ON s.patente = v.patente
INNER JOIN Service_parte sp ON s.patente = sp.patente AND s.fecha = sp.fecha
INNER JOIN Parte p ON p.cod_parte = sp.cod_parte
WHERE sp.nombre "filtro de combustible" AND s.descripcion = "inspeccion general"

/* 3. Listar nombre y precio de todas las partes que aparezcan en más de 30 services que hayan 
salido (partes) más de $4.000.*/

SELECT p.nombre. p.precio_parte
FROM Parte P
INNER JOIN (
    SELECT sp.cod_parte
    FROM Service_Parte sp
    GROUP BY sp.cod_parte
    HAVING COUNT(DISTINCT sp.fecha,sp.patente) > 30
) AS CODIGOSFINALES ON p.cod_parte = CODIGOSFINALES.cod_parte
WHERE p.precio_parte > 4000

/* 4. Dar de baja todos los camiones con más de 250.000 km.  */

DELETE FROM Service_Parte
WHERE PATENTE IN (
    SELECT v.patente 
    FROM vehiculo v
    INNER JOIN Camion c ON v.patente = c.patente
    WHERE v.km > 250.000
)

DELETE FROM Service
WHERE PATENTE IN (
    SELECT v.patente 
    FROM vehiculo v
    INNER JOIN Camion c ON v.patente = c.patente
    WHERE v.km > 250.000
)

DELETE FROM vehiculo
WHERE PATENTE IN (
    SELECT v.patente 
    FROM vehiculo v
    INNER JOIN Camion c ON v.patente = c.patente
    WHERE v.km > 250.000
)

DELETE FROM Camion
WHERE Patente NOT IN (
    SELECT v.patente
    FROM vehiculo v
)

/* 5. Listar el nombre y precio de aquellas partes que figuren en todos los service realizados en el año 
actual. */

Select p.nombre, p.precio_parte
FROM Parte P
INNER JOIN Service_Parte sp ON p.cod_parte = sp.cod_parte
WHERE YEAR(sp.fecha) = 2025 AND p.cod_parte NOT EXIST IN (
    Select sp2.fecha
    FROM Parte p2 INNER JOIN Service_Parte sp2 ON sp2.cod_parte = p2.cod_parte
    WHERE YEAR(sp.fecha) = 2025
)

/* 6. Listar todos los autos que sean eléctricos. Mostrar información de patente, modelo, marca y 
peso. */

SELECT v.modelo,v.marca,v.peso
FROM vehiculo V
INNER JOIN auto a ON a.patente = v.patente
WHERE a.es_electrico = true

/* 7. Dar de alta una parte, cuyo nombre sea “Aleron”  y precio $5000. */

INSERT INTO Parte(cod_parte, nombre, precio_parte)
values (1234,'Aleron','5000')

/* 8. Dar de baja todos los services que se realizaron al auto con patente ‘AWA564’. */
DELETE FROM Service_parte
WHERE patente = ‘AWA564’

DELETE FROM Service
WHERE patente = ‘AWA564’

/* 9. Listar todos los vehículos que hayan tenido services durante el 2024.  */
 