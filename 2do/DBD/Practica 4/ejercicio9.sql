/* Ejercicio 9 
Proyecto = (codProyecto, nombrP,descripcion, fechaInicioP, fechaFinP?, fechaFinEstimada, 
DNIResponsable(FK), equipoBackend(FK), equipoFrontend(FK)) // DNIResponsable corresponde a un 
empleado, equipoBackend y equipoFrontend corresponden a equipos
Equipo = (codEquipo, nombreE, descTecnologias, DNILider(FK))//DNILider corresponde a un empleado 
Empleado = (DNI, nombre, apellido, telefono, direccion, fechaIngreso) 
Empleado_Equipo = (codEquipo(FK), DNI(FK), fechaInicio, fechaFin, descripcionRol)  */

/*1. Listar nombre, descripción, fecha de inicio y fecha de fin de proyectos ya finalizados que no 
fueron terminados antes de la fecha de fin estimada.*/

SELECT p.nombrP,p.descripcion,p.fechaInicioP,p.fechaFinP
FROM proyecto P
WHERE p.fechaFinP IS NOT NULL AND p.fechaFinP > fechaFinEstimada

/*2. Listar DNI, nombre, apellido, teléfono, dirección y fecha de ingreso de empleados que no son, ni 
fueron responsables de proyectos. Ordenar por apellido y  nombre. */



3. Listar DNI, nombre, apellido, teléfono y dirección de líderes de equipo que tenga más de un 
equipo a cargo. 
4. Listar DNI, nombre, apellido, teléfono y dirección de todos los empleados que trabajan en el 
proyecto con nombre ‘Proyecto X’. No es necesario informar responsable y líderes. 
5. Listar nombre de equipo y datos personales de líderes de equipos que no tengan empleados 
asignados y trabajen con tecnología ‘Java’. 
/*6. Modificar nombre, apellido y dirección del empleado con DNI 40568965 con los datos que desee.*/

UPDATE Empleado SET apellido = "Rodriguez",nombre = "Juan", direccion = "Calle 1" WHERE DNI = 50568965

/* 7. Listar DNI, nombre, apellido, teléfono y dirección de empleados que son responsables de 
proyectos pero no han sido líderes de equipo. */

FROM
    Empleado e
WHERE
    -- 1. Condición de INCLUSIÓN: DNI debe existir en la lista de Responsables de Proyecto
    e.DNI IN (
        SELECT DNIResponsable
        FROM Proyecto
        WHERE p.fechaFin IS NOT NULL
    )
    -- 2. Condición de EXCLUSIÓN: DNI NO debe existir en la lista de Líderes de Equipo
    AND e.DNI NOT IN (
        SELECT DNILider
        FROM Equipo
    )
ORDER BY

/* 8. Listar nombre de equipo y descripción de tecnologías de equipos que hayan sido asignados 
como equipos frontend y backend. */

SELECT e.nombreE, e.descTecnologias
FROM Equipo e
INNER JOIN Proyecto p ON (e.DNI = p.equipoBackend)
WHERE e2.dni  IN (
    SELECT e2
    FROM Equipo e2
    INNER JOIN Proyecto p2 ON (e2.DNI = p2.equipoFrontend)
)

/* 9. Listar nombre, descripción, fecha de inicio, nombre y apellido de responsables de proyectos que 
se estiman finalizar durante 2025. */

