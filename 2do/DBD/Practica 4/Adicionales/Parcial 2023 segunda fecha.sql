/*
 * Usuario = (nombreUsuario, correo, apellido, nombre, fechaNac, localidad, nivelPrivacidad)
 * Solicitudes = (nombreUsuarioSolicita(fk), nombreUsuarioRecibe(fk), fechaSolicitud, fechaAcepta?, fechaRechaza?)
 * Publicación = (idPublicacion, nombreUsuario(fk), fechaPub, horaPub, titulo, tipoPub, linkPub)
 * Comentario = (numeroComentario, idPublicacion(fk), nombreUsuario(fk), fechaCom, horaCom, textoCom)
 */

/*
 * ============================================
 * CONSULTAS AR 1,2,3,4 y SQL 3,4,5,6,7
 * ============================================
 */

/* * 1) Listar para las solicitudes rechazadas el nombre de usuario, nombre y apellido del usuario que la solicita, el
 * nombre de usuario, nombre y apellido del usuario que recibe y la fecha de la solicitud.
 */
π δ σ ∧ ⨝ ∩

RECHAZADAS <= π nombreUsuarioSolicita, nombreUsuarioRecibe,fechaSolicitud σ fechaRechaza <> NULL (Solicitudes)
RESULT <= π u.nombreUsuario,u.nombre,u.apellido,u2.nombreUsuario,u2.nombre,u2.apellido,fechaSolicitud σ nombreUsuarioSolicita = u.nombreUsuario ^ nombreUsuarioRecibe = u2.nombreUsuario(ρU(Usuario) x ρU2(usuario) x RECHAZADAS)

/* * 2) Listar nombre de usuario, correo, nombre y apellido de los usuarios que no tuvieron publicaciones del tipo
 * 'Video' en 2020.
 */

VIDEO2020 <=π nombreUsuario σ tipoPub = "Video" ^ FechaPub > 31/12/2019 ^ FechaPub < 1/1/2021 (Publicación)
RESULT <= (π nombreUsuario (USUARIO)) - VIDEO2020
RESULT <= π nombreUsuario, correo, nombre, apellido (RESULT |x| Usuario) 

/* * 3) Listar los usuarios que realizaron comentarios en 2022 y también tienen publicaciones en el mismo año.
 * SQL ordenar por apellido y nombre.
 */

COMENTAROS <= π nombreUsuario σ fechaCom > 31/12/2021 ^ fechaCom < 1/1/2023 (Comentario)
PUBLICARON <= π nombreUsuario σ fechaPub > 31/12/2021 ^ fechaPub < 1/1/2023 (publicación)
USUA <= COMENTAROS ∩ PUBLICARON
RESULT <= π nombreUsuario,nombre, apellido (USUA |x| USUARIO)

SELECT DISTINCT u.nombreUsuario,u.apellido, u.nombre
FROM Usuario U
INNER JOIN Comentario c ON c.nombreUsuario = u.nombreUsuario
WHERE YEAR(c.fechaCom) = 2022 AND u.nombreUsuario IN (
    SELECT DISTINCT u2.nombreUsuario
    FROM Usuario U2
    INNER JOIN Publicación p ON p.nombreUsuario = u2.nombreUsuario
    WHERE YEAR(p.fechaPub) = 2022
)
ORDER BY
    U.apellido, U.nombre

/* * 4) Eliminar la publicación con idPublicacion=50.
 */

ELIMINAR <= σ idPublicacion = 50 (publicación)
publicación <= publicación = ELIMINAR
ELIMINAR <= σ idPublicacion = 50 (Comentario)
Comentario<= Comentario - Eliminar


DELETE FROM comentario
WHERE idPublicacion = 50

DELETE FROM Publicación
WHERE idPublicacion = 50


/* * 5) Listar para cada usuario la cantidad de publicaciones. Ordenar por cantidad de publicaciones en orden
 * descendente.
 * Informar nombre de usuario, correo, nombre y apellido.
 */

SELECT u.nombreUsuario,u.correo,u.nombre,u.apellido, COALESCE(t.cantidad,0)
FROM USUARIO u
LEFT JOIN (
    SELECT p.nombreUsuario,COUNT(p.nombreUsuario) AS Cantidad
    FROM Publicación P
    GROUP By p.nombreUsuario
) as T ON u.nombreUsuario = t.nombreUsuario
ORDER BY cantidad DESC


/* * 6) Listar el/los usuario/s con mayor cantidad de publicaciones. Informar nombre de usuario, correo, nombre y
 * apellido.
 */

SELECT u.nombreUsuario,u.correo,u.nombre,u.apellido
FROM USUARIO U
INNER JOIN PUBLICACION p ON p.nombreUsuario = u.nombreUsuario
GROUP BY u.nombreUsuario,u.correo,u.nombre,u.apellido
HAVING (COUNT(p.idPublicacion)) = (
    SELECT MAX (T.total)
    FROM (
        SELECT COUNT (p2.idPublicacion) AS total
        FROM Publicacion p2
        GROUP By p2.nombreUsuario
    ) AS T
)

/* * 7) Listar para cada publicación que dentro del título contenga el string "Publicidad" y cuya cantidad de
 * comentarios sea superior a 1000, fecha de publicación, título, tipo, el correo del usuario y cantidad de
 * comentarios.
 */

SELECT p.FechaPub,p.titulo,p.tipo,u.correo, COUNT(c.idPublicacion) as totales
FROM PUBLICACION P
INNER JOIN USUARIO u ON p.nombreUsuario = u.nombreUsuario
LEFT JOIN COMENTARIO c ON c.idPublicacion = p.idPublicacion
WHERE p.titulo LIKE "%Publicidad%"
GROUP BY p.idPublicacion,p.FechaPub,p.titulo,p.tipo,u.correo
HAVING (COUNT(c.idPublicacion) > 1000)