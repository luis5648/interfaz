<?php

function buscarClientes($condicion, $conexion)
{
    strtoupper($condicion);

    $cons = mysqli_query($conexion, "SELECT NumeroDeFactura, Receptor,clientes.RFC_Cliente,proveedores.RFC_Proveedor,Emisor,iva,fecha,Total_Impuestos,total,Ruta_Factura FROM facturas INNER JOIN clientes ON facturas.RFC_Cliente = clientes.RFC_Cliente INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE clientes.Receptor LIKE '%$condicion%'");

    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["NumeroDeFactura"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Cliente"] . "</td>";
            echo "<td>" . $filas["Emisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["iva"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["Total_Impuestos"] . "</td>";
            echo "<td><a href='" . $filas["Ruta_Factura"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

function buscarProveedor($condicion, $conexion)
{

    $cons = mysqli_query($conexion, "SELECT NumeroDeFactura, Receptor,clientes.RFC_Cliente,proveedores.RFC_Proveedor,Emisor,iva,fecha,Total_Impuestos,total,Ruta_Factura FROM facturas INNER JOIN clientes ON facturas.RFC_Cliente = clientes.RFC_Cliente INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE proveedores.Emisor LIKE '%$condicion%'");

    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["NumeroDeFactura"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Cliente"] . "</td>";
            echo "<td>" . $filas["Emisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["iva"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["Total_Impuestos"] . "</td>";
            echo "<td><a href='" . $filas["Ruta_Factura"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

function buscarPorFecha($fecha, $conexion)
{
    $cons = mysqli_query($conexion, "SELECT NumeroDeFactura, Receptor,clientes.RFC_Cliente,proveedores.RFC_Proveedor,Emisor,iva,fecha,Total_Impuestos,total,Ruta_Factura FROM facturas INNER JOIN clientes ON facturas.RFC_Cliente = clientes.RFC_Cliente INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE fecha = '$fecha'");


    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["NumeroDeFactura"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Cliente"] . "</td>";
            echo "<td>" . $filas["Emisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["iva"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["Total_Impuestos"] . "</td>";
            echo "<td><a href='" . $filas["Ruta_Factura"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

//pendiente consultas con fecha.
