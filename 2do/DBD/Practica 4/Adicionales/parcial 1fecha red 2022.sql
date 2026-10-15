/*
=========================================================================
                        ESQUEMA RELACIONAL
=========================================================================

Especialista = (Matricula [PK], nombre, apellido, domicilio)

ObraSocial   = (nombre [PK], descripción)

Paciente     = (DNI [PK], nombre, apellido, domicilio, telefono)

Turno        = (Matricula [PK][FK], DNI [PK][FK], fecha [PK], motivo, nombre [FK], observaciones)
               -- Nota: La imagen indica que el campo 'nombre' en Turno refiere a la Obra Social.
               -- Sugerencia: Trátalo como 'nombre_os' para no confundirlo con los nombres de personas.

=========================================================================
                        CONSIGNAS
=========================================================================
Realizar 1, 2, 3 y 4 en AR (Álgebra Relacional)
Realizar 2, 3, 4, 5 y 6 en SQL */

/*Para los turnos del 26/06/2022 listar matrícula, nombre y apellido de los especialistas, 
DNI, nombre, apellido, teléfono de los pacientes involucrados, fecha del turno, 
nombre y descripción de la obra social. */

π δ σ ∧ ⨝ ∩ ρ

tot <= π dni,matricula,fecha,nombre σ fecha = '26/06/2022' (Turno)
Esp <= ρ (matricula,nom_esp,ape_esp,dom_esp) (Especialista)
pac <= ρ (dni,nom_pac,ape_pac,dom_pac,telefono) (Paciente)
Result <= (tot |x| Esp |x| Pac |x| ObraSocial)

δ domicilio <= '1 y 50' σ dni = 1 (Especialista)

/*Listar los datos de los pacientes que se atendieron con todos los especialistas. */

TODOS <= π matricula, dni (Turno)
TODOS <= TODOS % π matricula(Especialista)
RESULT <= π dni,nombre,apellido,telefono (TODOS |x| Paciente)

SELECT p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
FROM Paciente p
INNER JOIN turno t on p.dni = t.dni
GROUP BY p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
HAVING COUNT(DISTINCT t.matricula) = (
    SELECT COUNT(matricula)
    FROM especialista
)

/*Listar las pacientes que se atendieron en el año 2021 pero no se atendieron en el año 2019. */

2021 <= π dni σ fecha >= 1/1/2021 ^ fecha <= 31/12/2021(Turno)
2019 <= π dni σ fecha >= 1/1/2019 ^ fecha <= 31/12/2019(Turno)
RESULT <= π dni,nombre,apellido,telefono ((2021-2019) |x| Paciente)

SELECT DISTINCT p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
FROM Paciente p
INNER JOIN turno t on p.dni = t.dni
WHERE YEAR(t.fecha) = 2021 AND p.dni NOT IN (
    SELECT t2.dni
    FROM turno t2
    WHERE YEAR(t2.fecha) = 2019
)

/*Listar los pacientes que se atendieron por la obra social “OSDE” y también “IOMA”.*/

TODOS <= π nombre, dni (Turno)
OSDE <= π dni σ nombre = 'OSDE'(TODOS |x| ObraSocial)
IOMA <= π dni σ nombre = 'IOMA'(TODOS |x| ObraSocial)
RESUL <= π dni,nombre,apellido,telefono ((OSDE ∩ IOMA) |x| Paciente)

SELECT DISTINCT p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
FROM Paciente p
INNER JOIN turno t on p.dni = t.dni
WHERE t.nombre_os = 'OSDE' AND p.dni IN (
    SELECT t2.dni
    FROM turno t2
    WHERE t2.nombre_os = 'IOMA'
)

/*Listar para cada especialista la cantidad de turnos en el 2022.*/

SELECT e.matricula,COUNT(t.matricula) AS Cantidad
FROM Especialista e
LEFT JOIN Turno t ON e.matricula = t.matricula AND YEAR(t.fecha) = 2022
GROUP BY e.matricula

/*Listar los pacientes que se hayan atendido más de 5 veces en el año 2020.
*/

SELECT p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
FROM Paciente p
INNER JOIN turno t on p.dni = t.dni
WHERE YEAR(t.fecha) = 2020
GROUP BY p.dni,p.nombre,p.apellido,p.domicilio,p.telefono
HAVING COUNT(t.matricula) > 5