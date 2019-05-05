<?php

//eliminados:
//iva, 

function buscarClientes($condicion, $conexion)
{
    strtoupper($condicion);

    $cons = mysqli_query($conexion, "SELECT FacturaNumero, Receptor,clientes.RFC_Clientes,proveedores.RFC_Proveedor,NombreEmisor,fecha,TotalImpuestos,total,ruta FROM facturas INNER JOIN clientes ON facturas.RFC_Clientes = clientes.RFC_Clientes INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE clientes.Receptor LIKE '%$condicion%'");

    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["FacturaNumero"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Clientes"] . "</td>";
            echo "<td>" . $filas["NombreEmisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["TotalImpuestos"] . "</td>";
            echo "<td><a href='" . $filas["ruta"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

function buscarProveedor($condicion, $conexion)
{
    strtoupper($condicion);

    $cons = mysqli_query($conexion, "SELECT FacturaNumero, Receptor,clientes.RFC_Clientes,proveedores.RFC_Proveedor,NombreEmisor,fecha,TotalImpuestos,total,ruta FROM facturas INNER JOIN clientes ON facturas.RFC_Clientes = clientes.RFC_Clientes INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE proveedores.NombreEmisor LIKE '%$condicion%'");

    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["FacturaNumero"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Clientes"] . "</td>";
            echo "<td>" . $filas["NombreEmisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["TotalImpuestos"] . "</td>";
            echo "<td><a href='" . $filas["ruta"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

function buscarPorFecha($fecha, $conexion)
{
    $cons = mysqli_query($conexion, "SELECT FacturaNumero, Receptor,clientes.RFC_Clientes,proveedores.RFC_Proveedor,NombreEmisor,fecha,TotalImpuestos,total,ruta FROM facturas INNER JOIN clientes ON facturas.RFC_Clientes = clientes.RFC_Clientes INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE fecha = '$fecha'");


    if ($cons->num_rows > 0) {
        while ($filas = $cons->fetch_assoc()) {
            echo "<tr><td>" . $filas["FacturaNumero"] . "</td>";
            echo "<td>" . $filas["Receptor"] . "</td>";
            echo "<td>" . $filas["RFC_Clientes"] . "</td>";
            echo "<td>" . $filas["NombreEmisor"] . "</td>";
            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
            echo "<td>" . $filas["fecha"] . "</td>";
            echo "<td>" . $filas["total"] . "</td>";
            echo "<td>" . $filas["TotalImpuestos"] . "</td>";
            echo "<td><a href='" . $filas["ruta"] . "' target='_blank'>Ver factura</a></td>";
            echo "</tr>";
        }
    }
}

//pendiente consultas con fecha.
