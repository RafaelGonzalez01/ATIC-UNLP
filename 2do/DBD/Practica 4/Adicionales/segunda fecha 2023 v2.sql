/* Persona=(dni, nombre, apellido, edad) / / 
Visita=(dni(fk), codigo_ciudad(fk), fecha, motivo) / / 
Ciudad=(codigo_ciudad, nombre, latitud, longitud, cantidad_habitantes, codigo_pais(fk)) / / 
Pais=(codigo_pais, nombre, tiene_salida_mar, anio_independencia) / */

/* 1. Mostrar todos los datos de las personas que hayan conocido más de 10 países diferentes junto con la cantidad de países conocidos. (SQL) */

SELECT p.dni,p.nombre,p.apellido,p.edad,COUNT(DISTINCT c.codigo_pais) as cant
FROM persona P
INNER JOIN visita v ON v.dni = p.dni
INNER JOIN ciudad c ON c.codigo_ciudad = v.codigo_ciudad
GROUP BY p.dni,p.nombre,p.apellido,p.edad
HAVING COUNT(DISTINCT c.codigo_pais) > 10
ORDER BY p.dni

/* 2. Eliminar el país con código 2398. (SQL) */

DELETE FROM Visita
WHERE codigo_ciudad IN (
    SELECT v.codigo_ciudad
    FROM VISITA v
    INNER JOIN CIUDAD c ON c.codigo_ciudad = v2.codigo_ciudad
    WHERE c.codigo_pais = 2398
)

DELETE FROM CIUDAD
WHERE codigo_pais = 2398

DELETE FROM Pais
WHERE codigo_pais = 2398

/* 3. Mostrar todos los datos de las personas que hayan conocido todas las ciudades. (SQL y AR) */

SELECT p.dni,p.nombre,p.apellido,p.edad
FROM PERSONA P
INNER JOIN visita v ON v.dni = p.dni
GROUP by p.dni,p.nombre,p.apellido,p.edad
HAVING COUNT( DISTINCT v.codigo_ciudad) = (
    SELECT COUNT(c.codigo_ciudad)
    FROM CIUDAD c
)

π δ σ ∧ ⨝ ∩

PER <= π dni, codigo_ciudad (VISITA)
CIU <= π codigo_ciudad (CIUDAD)
TOT <= PER % CIU
RESULT <= π dni, nombre, apellido , edad (TOT |x| Persona)

/* 4. Mostrar todos los datos de las personas que hayan visitado solo Argentina en el año 2023. (SQL y AR) */

SELECT p.dni,p.nombre,p.apellido,p.edad
FROM PERSONA P
INNER JOIN visita v ON v.dni = p.dni
INNER JOIN ciudad c ON c.codigo_ciudad = v.codigo_ciudad
INNER JOIN pais pa ON c.codigo_pais = pa.codigo_pais
WHERE pa.nombre = 'Argentina' AND YEAR (v.fecha) = 2023 AND p.dni NOT IN (
    SELECT p2.dni
    FROM PERSONA P2
    INNER JOIN visita v2 ON v2.dni = p2.dni
    INNER JOIN ciudad c2 ON c2.codigo_ciudad = v2.codigo_ciudad
    INNER JOIN pais pa2 ON c2.codigo_pais = pa2.codigo_pais
    WHERE pa2.nombre <> 'Argentina' AND YEAR (v2.fecha) = 2023 
)

PER <= π dni, codigo_ciudad σ fecha >= 1/1/2023 ^ fecha <= 31/12/2023 (VISITA)
PER <= π dni,codigo_pais (PER|x|ciudad)
PER <= π dni σ nombre <> 'Argentina' (PER|x|pais)
PERNO <= π dni, codigo_ciudad σ fecha >= 1/1/2023 ^ fecha <= 31/12/2023 (VISITA)
PERNO <= π dni,codigo_pais (PERNO|x|ciudad)
PERNO <= π dni σ nombre <> 'Argentina' (PERNO|x|pais)
RESULT <= π dni,nombre,apellido,edad (PER - PERNO) |x| PERSONA


/* 5. Actualizar la cantidad de habitantes de la ciudad con código 5432. La nueva cantidad de habitantes es 23.456.789. (SQL y AR) */

UPDATE CIUDAD
SET cantidad_habitantes = 23.456.789
WHERE codigo_ciudad = 5432

δ cantidad_habitantes = 3.456.789 σ codigo_ciudad = 5432 (ciudad)

