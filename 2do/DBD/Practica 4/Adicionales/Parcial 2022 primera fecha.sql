/* SOCIO = (nro_socio, DNI, Apellido, Nombre, Fecha_Nacimiento, Fecha_ingreso) */ 

/* LIBRO = (ISBN, Titulo, Cod_Genero, Descripcion) */ 

/* COPIA = (ISBN(PK). Nro Ejemplar, Estado) */ 

/* EDITORIAL (Cod_Editorial, Denominacion, Telefono, Calle, Numero, Piso, Dpto.) */ 

/* LIBRO_EDITORIAL = (ISBN(FK), Cod_Editorial (PK), Año_Edicion) */ 

/* GENERO (Cod Genero, Nombre_genero) */ 

/* PRESTAMO = (Nro_Prestamo, nro_Socio(FK), ISBN(FK), Nro_Ejemplar (FK), Fecha_Prestamo, Fecha_Devolucion)// 
ISBN(FK) y Nro_Ejemplar son foraneas de copia */

/* 1. Listar el título, género (el Nombre del Género) y descripción de aquellos libros editados por la editorial "Nueva Editorial". 
Dicho listado deberá estar ordenado por título. */

SELECT l.titulo,g.Nombre_genero,l.descripcion
FROM libro l
INNER JOIN Genero g ON l.Cod_Genero = g.Cod_Genero
INNER JOIN Libro_editorial le ON le.ISBN = l.ISBN
INNER JOIN EDITORIAL e ON e.cod_Editorial = le.Cod_Editorial
WHERE e.denominación = 'Nueva Editorial'
ORDER BY l.titulo


/* 2. Listar el apellido y nombre de aquellos socios cuya fecha de ingreso esté entre el 01/9/2022 y el 30/09/2022. 
Dicho listado deberá estar ordenado por apellido y nombre. */ 

SELECT s.apellido,s.nombre
FROM Socio s
WHERE s.fechaIngreso BETWEEN '01/9/2022' AND '30/09/2022'
ORDER BY s.apellido,s.nombre

/* 3. Listar el nombre, apellido, fecha de Nacimiento y cantidad de préstamos de aquellos socios que hayan solicitado más de 5 préstamos. 
Dicho listado deberá estar ordenado por Apellido. */ 

SELECT s.nombre,s.apellido,s.Fecha_Nacimiento,COUNT(p.Nro_Prestamo) as cant
FROM SOCIO s
INNER JOIN PRESTAMO p ON s.nro_Socio = p.nro_Socio
GROUP BY s.nro_Socio,s.nombre,s.apellido,s.Fecha_Nacimiento
HAVING COUNT(p.Nro_Prestamo) > 5
ORDER BY s.apellido,s.nombre 

/* 4. Listar el DNI, apellido y nombre de aquellos socios que no tengan préstamos de libros editados por la editorial "Gran Editorial". 
Dicho listado deberá estar ordenado por Apellido y Nombre. */ 

SELECT DISTINCT s.dni,s.apellido,s.nombre
FROM SOCIO S
WHERE s.nro_socio NOT IN (
    SELECT s2.nro_Socio
    FROM Socio s2
    INNER JOIN PRESTAMO p ON p.nro_Socio = s2.nro_Socio
    INNER JOIN Libro_editorial le on le.ISBN = p.ISBN
    INNER JOIN editorial e ON e.cod_Editorial = le.cod_Editorial
    WHERE e.denominación = 'Gran Editorial'
)
ORDER BY s.apellido,s.nombre

/* 5. Mostrar que cantidad de socios tienen actualmente libros prestados cuyo estado sea "Bueno". */ 

SELECT COUNT(DISTINCT(s.nro_socio)) as cant
FROM SOCIO S
INNER JOIN PRESTAMO p ON s.nro_Socio = p.nro_Socio
INNER JOIN COPIA c ON c.Nro_Ejemplar = p.Nro_Ejemplar AND c.ISBN = p.ISBN
WHERE c.estado = 'Bueno' AND p.Fecha_Devolucion IS NULL

/* 6. Listar el título, género, denominación de la editorial y año de edición de aquellos libros editados entre los años 1980 y 2015. */ 

SELECT l.titulo,g.Nombre_genero,e.denominación,le.Año_Edicion
FROM libro l
INNER JOIN Libro_editorial le ON le.ISBN = l.ISBN
INNER JOIN EDITORIAL e ON e.cod_Editorial = le.cod_Editorial
INNER JOIN Genero g ON l.Cod_Genero = g.Cod_Genero
WHERE le.Año_Edicion BETWEEN 1980 AND 2015

/* AR (Agregar). Agregar un nuevo socio con el nro_socio, DNI, Apellido, Nombre y Fecha de nacimiento que prefiera. */ 

nue <= {31,23,'gomez','pablo','1/1/1','16/12/2025'}
socio <= socio U nue

INSERT INTO socio(nro_socio, DNI, Apellido, Nombre ,Fecha_Nacimiento, Fecha_ingreso)
VALUES (31,23,'gomez','pablo','1/1/1',CURRENT_DATE)

/* AR (Modificar). Modificar el título del libro cuyo ISBN es 2152-2020 por el título "El Código X". */

π δ σ ∧ ⨝ ∩ ρ

δ titulo <= 'hola' σ isbn = '2152-2020' (libro)

UPDATE libro
SET titulo = 'hola'
WHERE isbn = '2152-2020'

NUELIBRO <= ρ(isbn,nuetitulo,nuecod_genero,nuedesc) (Libro)