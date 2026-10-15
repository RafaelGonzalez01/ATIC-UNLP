/* 3. Consultas AR y SQL
Resolver incisos 1, 2 y 3 en AR, y resolver incisos 1, 2, 3, 4 y 5 en SQL. 
Para aprobar debe hacer 3 SQL bien y 2 AR bien. */

/* =========================================================================
                                   ESQUEMA
   ========================================================================= */

/* Jugador = (idJugador, nombre, apellido, fecha_nacimiento, altura, peso, posicion) */

/* Equipo = (idEquipo, nombre, ciudad, conferencia) */

/* Contrato = (idJugador(fk), idEquipo(fk), fecha_desde, fecha_hasta) // fecha hasta no puede ser nulo */

/* Partido = (idPartido, fecha, idEquipoLocal(fk), idEquipoVisitante(fk), puntosLocal, puntosVisitante) */


/* =========================================================================
                                   CONSIGNAS
   ========================================================================= */

/* 1. Reportar nombre y ciudad de equipos que hayan jugado partidos durante 2023 pero no durante 2024. */



/* 2. Listar jugadores que jugaron en todos los equipos de la conferencia Este. */

SELECT j.idJugador,j.nombre,j.apellido
FROM Jugador j
INNER JOIN Contrato c ON c.idJugador = j.idJugador
INNER JOIN Equipo e ON e.idEquipo = c.idEquipo
WHERE e.conferencia = 'Este'
GROUP BY j.idJugador,j.nombre,j.apellido
HAVING COUNT(DISTINCT e.idEquipo) = (
    SELECT COUNT(idEquipo)
    FROM Equipo
    WHERE conferencia = 'Este'
) 

ESTE <= π idEquipo σ conferencia = 'Este'(Equipo)
jugadores <= π idJugador, idEquipo (ESTE |x| Contrato)
jugadores <= jugadores % ESTE
result <= π idjugador, nombre, apelldio (jugadores |x| jugador)


/* 3. Modificar la ciudad del equipo con idEquipo 5 a "San Francisco". */

π δ σ ∧ ⨝ ∩ ρ

UPDATE Equipo
SET ciudad = 'San Francisco'
WHERE idEquipo = 5

δ ciudad <= 'San Francisco' σ idEquipo = 5 (Equipo)

/* 4. Listar nombre, apellido, altura y posición de jugadores que midan más de 2.10 metros y que se encuentren jugando actualmente en algún equipo de la ciudad de Nueva York. Ordenar por apellido de manera descendente. */

/* 5. Listar idPartido, fecha y nombre de los equipos donde ambos equipos (local y visitante) sean de la conferencia Oeste. */

SELECT p.idPartido,p.fecha,e1.nombre,e2.nombre
FROM partido P
INNER JOIN Equipo e1 ON p.idEquipoLocal = e1.idEquipo AND e1.conferencia = 'Oeste'
INNER JOIN equipo e2 ON p.idEquipoVisitante = e2.idEquipo AND e2.conferencia = 'Oeste'
