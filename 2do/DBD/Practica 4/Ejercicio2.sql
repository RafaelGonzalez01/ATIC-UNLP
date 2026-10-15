/* Localidad = (codigoPostal, nombreL, descripcion, nroHabitantes) 
Arbol = (nroArbol, especie, anios, calle, nro, codigoPostal(fk)) 
Podador = (DNI, nombre, apellido, telefono, fnac, codigoPostalVive(fk)) 
Poda = (codPoda, fecha, DNI(fk), nroArbol(fk)) */

/* 1. Listar especie, años, calle, nro y localidad de árboles podados por el podador ‘Juan Perez’ y por 
el podador ‘Jose Garcia’.  */

SELECT DISTINCT a.especie, a.anios, a.calle, a.nro, l.nombreL
FROM ARBOL a
INNER JOIN LOCALIDAD l ON l.codigoPostal = a.codigoPostal
INNER JOIN PODA p ON p.nroArbol = a.nroArbol
INNER JOIN PODADOR po ON po.DNI = p.DNI
WHERE po.nombre = ‘Jose Garcia’ AND a.nroArbol IN (
    SELECT DISTINCT a.nroArbol
    FROM ARBOL a
    INNER JOIN PODA p ON p.nroArbol = a.nroArbol
    INNER JOIN PODADOR po ON po.DNI = p.DNI
    WHERE po.nombre = ‘Juan Perez’ 
)

/* 2. Reportar DNI, nombre, apellido, fecha de nacimiento y localidad donde viven de aquellos 
podadores que tengan podas realizadas durante 2023. */

SELECT DISTINCT po.DNI, po.nombre, po.apellido, po.fnac, l.nombreL
FROM PODADOR po
INNER JOIN LOCALIDAD l ON po.codigoPostal = l.codigoPostal
INNER JOIN PODA p ON p.DNI = po.DNI
WHERE YEAR(p.fecha) = 2023
ORDER BY po.DNI

/*3. Listar especie, años, calle, nro y localidad de árboles que no fueron podados nunca. */

SELECT DISTINCT a.especie, a.anios, a.calle, a.nro, l.nombreL
FROM ARBOL a
INNER JOIN LOCALIDAD l ON l.codigoPostal = a.codigoPostal
WHERE a.nroArbol NOT IN (
    SELECT p.nroArbol
    FROM PODA p
)
ORDER BY a.especie

/*4. Reportar especie, años,calle, nro y localidad de árboles que fueron podados durante 2022 y  no 
fueron podados durante 2023. */

SELECT a.especie,a.anios,a.calle,a.nroArbol,l.nombreL
FROM ARBOL a
INNER JOIN LOCALIDAD l ON a.codigoPostal = l.codigoPostal
INNER JOIN PODA p ON a.nroArbol = p.nroArbol
WHERE YEAR(p.fecha) = 2022 AND a.nroArbol NOT IN (
    SELECT a2.nroArbol
    FROM ARBOL a2
    INNER JOIN PODA p2 ON a2.nroArbol = p2.nroArbol
    WHERE YEAR(p2.fecha) = 2023
)
ORDER BY a.especie

/*5. Reportar DNI, nombre, apellido, fecha de nacimiento y localidad donde viven de aquellos 
podadores con apellido terminado con el string ‘ata’  y que tengan al menos una poda durante 
2024. Ordenar por apellido y nombre.*/ 

SELECT DISTINCT po.DNI,po.nombre,po.apellido,po.fnac,l.nombreL
FROM PODADOR po
INNER JOIN LOCALIDAD l ON po.codigoPostalVive = l.codigoPostal
INNER JOIN PODA p ON p.DNI = po.DNI
WHERE po.apellido LIKE ‘%ata’ AND YEAR(P.fecha) = 2024
ORDER BY PO.apellido,po.nombre

/*6. Listar DNI, apellido, nombre, teléfono y fecha de nacimiento de podadores que solo podaron 
árboles de especie ‘Coníferas’. */

SELECT po.DNI,po.nombre,po.apellido,po.fnac
FROM PODADOR po
INNER JOIN PODA p ON p.DNI = po.DNI
INNER JOIN ARBOL a ON a.nroArbol = p.nroArbol
WHERE a.especie = "Coniferas" AND po.DNI NOT IN (
    SELECT po2.DNI
    FROM PODADOR po2
    INNER JOIN PODA p2 ON p2.DNI = po2.DNI
    INNER JOIN ARBOL a2 ON a2.nroArbol = p2.nroArbol
    WHERE a2.especie <> "Coniferas"
)

/*7. Listar especies de árboles que se encuentren en la localidad de ‘La Plata’ y también en la 
localidad de ‘Salta’. */

SELECT a.especie
FROM ARBOL a
INNER JOIN LOCALIDAD l ON l.codigoPostal = a.codigoPostal
WHERE l.nombreL = "La Plata" AND a.especie IN (
    SELECT a2.especie
    FROM ARBOL a2
    INNER JOIN LOCALIDAD l2 ON l2.codigoPostal = a2.codigoPostal
    WHERE l2.nombreL = "Salta"
)

/*8. Eliminar el podador con DNI 22234566. */

DELETE FROM PODA
WHERE dni = 22234566;

DELETE FROM PODADOR 
WHERE dni = 22234566;

/*9. Reportar  nombre, descripción y cantidad de habitantes de localidades que tengan menos de 5 
árboles. */

SElECT l.nombreL,l.descripcion,l.nroHabitantes
FROM LOCALIDAD l
INNER JOIN (
    
    SELECT a.codigoPostal
    FROM ARBOL a
    GROUP BY a.codigoPostal
    HAVING COUNT(a.nroArbol) < 5

) AS LOCALIDADESPOCO ON l.codigoPostal = LOCALIDADESPOCO.codigoPostal

ORDER BY l.nombreL