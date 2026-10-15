/* Cliente = (idCliente, nombre, apellido, DNI, telefono, direccion)
Factura = (nroTicket, total, fecha, hora, idCliente (fk))
Detalle = (nroTicket (fk), idProducto (fk), cantidad, preciounitario)
Producto = (idProducto, nombreP, descripcion, precio, stock)*/

/* 1. Listar datos personales de clientes cuyo apellido comience con el string ‘Pe’. Ordenar por DNI */
SELECT c.nombre, c.apellido, c.DNI, c.telefono, c.direccion
FROM Cliente c
WHERE c.apellido LIKE 'Pe%'
ORDER BY c.DNI;

/*2. Listar nombre, apellido, DNI, teléfono y dirección de clientes que realizaron compras solamente
durante 2024. */
SELECT c.nombre, c.apellido, c.DNI, c.telefono, c.direccion
FROM Cliente c
WHERE c.idCliente IN (
    SELECT f.idCliente
    FROM Factura f
    WHERE (YEAR(f.fecha) = 2024)
);
AND c.idCliente NOT IN (
    SELECT f.idCliente
    FROM Factura f
    WHERE (YEAR(f.fecha) <> 2024)
)

/*3. Listar nombre, descripción, precio y stock de productos vendidos al cliente con DNI 45789456,
pero que no fueron vendidos a clientes de apellido ‘Garcia’. */

SELECT p.nombreP, p.descripcion, p.precio, p.stock
    FROM CLIENTE c
    INNER JOIN FACTURA f ON c.idCliente = f.idCliente
    INNER JOIN DETALLE d ON f.nroTicket = d.nroTicket
    INNER JOIN PRODUCTO p ON d.idProducto = p.idProducto
    WHERE c.DNI = 45789456 AND NOT p.idProducto IN (
        SELECT d2.idProducto
            FROM CLIENTE c2
            INNER JOIN FACTURA f2 ON c2.idCliente = f2.idCliente
            INNER JOIN DETALLE d2 ON f2.nroTicket = d2.nroTicket
            WHERE c2.apellido = 'Garcia'
)

/*4. Listar nombre, descripción, precio y stock de productos no vendidos a clientes que tengan
teléfono con característica 221 (la característica está al comienzo del teléfono). Ordenar por
nombre. */

SELECT p.nombreP, p.descripcion, p.precio, p.stock
    FROM PRODUCTO p
    WHERE NOT p.nombreP IN (
        SELECT p2.nombreP
            FROM PRODUCTO p2
            INNER JOIN DETALLE d2 ON d2.idProducto = p2=idProducto
            INNER JOIN FACTURA f2 ON d2.nroTicket = f2.nroTicket
            INNER JOIN CLIENTE c2 ON f2.idCliente = c2.idCliente
            WHERE c2.telefono LIKE '221%'
    )
ORDER BY p.nombre;

/*5. Listar para cada producto nombre, descripción, precio y cuantas veces fue vendido. Tenga en
cuenta que puede no haberse vendido nunca el producto. */

SELECT p.nombreP, p.descripcion, p.precio, COALESCE (SUM(d.cantidad),0)
    FROM PRODUCTO P
    LEFT JOIN DETALLE d ON d.idProducto = p.idProducto
    GROUP BY
    p.idProducto, p.nombreP, p.descripcion, p.precio, p.stock
    ORDER BY p.nombreP;

/*6. Listar nombre, apellido, DNI, teléfono y dirección de clientes que compraron los productos con
nombre ‘prod1’ y ‘prod2’ pero nunca compraron el producto con nombre ‘prod3’. */
SELECT F.idCliente
FROM Factura F
INNER JOIN Detalle D ON F.nroTicket = D.nroTicket
INNER JOIN Producto P ON D.idProducto = P.idProducto
WHERE P.nombreP IN ('prod1', 'prod2')
GROUP BY F.idCliente
HAVING COUNT(DISTINCT P.nombreP) = 2
AND C.idCliente NOT IN (
    SELECT F.idCliente
    FROM Factura F
    INNER JOIN Detalle D ON F.nroTicket = D.nroTicket
    INNER JOIN Producto P ON D.idProducto = P.idProducto
    WHERE P.nombreP = 'prod3'
);
/*7. Listar nroTicket, total, fecha, hora y DNI del cliente, de aquellas facturas donde se haya
comprado el producto ‘prod38’ o la factura tenga fecha de 2023. */

SELECT DISTINCT f.nroTicket,f.total,f.fecha,f.hora,c.DNI
FROM FACTURA f
INNER JOIN CLIENTE c ON f.idCliente = c.idCliente
INNER JOIN DETALLE d ON f.nroTicket = d.nroTicket
INNER JOIN PRODUCTO p ON d.idProducto = p.idProducto
WHERE p.nombreP = ‘prod38’ OR YEAR(f.fecha) = 2023

/*8. Agregar un cliente con los siguientes datos: nombre:’Jorge Luis’, apellido:’Castor’, DNI:
40578999, teléfono: ‘221-4400789’, dirección:’11 entre 500 y 501 nro:2587’ y el id de cliente:
500002. Se supone que el idCliente 500002 no existe. */

INSERT INTO Cliente (idCliente, nombre, apellido, DNI, telefono, direccion)
VALUES (500002, 'Jorge Luis', 'Castor', 40578999, '221-4400789', '11 entre 500 y 501 nro:2587');

/*9. Listar nroTicket, total, fecha, hora para las facturas del cliente ´Jorge Pérez´ donde no haya
comprado el producto ´Z´.*/

SELECT f.nroTicket, f.total, f.fecha
FROM FACTURA f
INNER JOIN CLIENTE c ON f.idCliente = c.idCliente
WHERE c.nombre = ´Jorge Pérez´ AND f.nroTicket NOT IN (
    SELECT DISTINCT f2.nroTicket
    FROM FACTURA f2
    INNER JOIN CLIENTE c2 ON f2.idCliente = c2.idCliente
    INNER JOIN DETALLE d2 ON d2.nroTicket = f2.nroTicket
    INNER JOIN PRODUCTO p2 ON d2.idProducto = p2.idProducto
    WHERE p2.nombreP = ´Z´
)
ORDER BY f.nroTicket

/*10. Listar DNI, apellido y nombre de clientes donde el monto total comprado, teniendo en cuenta
todas sus facturas, supere $100000. */

SELECT c.DNI, c.apellido, c.nombre
FROM CLIENTE c
INNER JOIN FACTURA f ON f.idCliente = c.idCliente
GROUP BY
c.idCliente, c.nombre,  c.apellido, c.DNI, c.telefono, c.direccion
HAVING SUM(f.total) > 100000
ORDER BY c.DNI