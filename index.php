<?php
require "php/Conexion.php"

?>
<!-- éste sitio no es responsivo para dispositivos móviles o pantallas pequeñas porque me dio pereza xd-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="css/main.css">
    <title>Busquedas</title>
</head>

<body>

    <h2>Facturas</h2>


    <form id="f1" method="post" action="">
        <div class="form-group">
            <h4>Busqueda por cliente</h3>
                <label for="exampleInputEmail1">Nombre del cliente</label>
                <input class="form-control" name="nombreCliente" placeholder="Nombre del cliente">

        </div>

        </div>
        <button name="buscaClien" class="btn btn-primary">Submit</button>
    </form>

    <form id="f2" method="post" action="">
        <div class="form-group">
            <h4>Busqueda por proveedor</h3>
                <label for="exampleInputEmail1">Nombre proveedor</label>
                <input class="form-control" name="nombreProveedor" placeholder="Nombre del proveedor">


        </div>
        <button type="submit" name="buscaProv" class="btn btn-primary">Submit</button>
    </form>

    <form id="f3" method="post" action="">
        <h4>Busqueda por factura</h3>
            <div class="form-group">
                <label>Facturas dispo</label>
                <!-- a cambiar por un select -->

                <select name="Facturas" class="form-control" id="">
                    <option value="1">1</option>
                </select>

            </div>

            <button type="submit" name="buscaFact" class="btn btn-primary">Submit</button>
    </form>

    <div id="tablaDatos">
        <h3>datos de facturas: </h3>
        <table class="table table-striped table-dark">
            <thead>
                <tr>

                    <th scope="col">ID Factura</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">RFC Cliente</th>
                    <th scope="col">Proveedor</th>
                    <th scope="col">RFC Proveedor</th>
                    <th scope="col">IVA</th>
                    <th scope="col">Subtotal</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
                <!-- 
                    referencia:
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
-->
                <?php
                if (isset($_POST["buscaClien"])) {

                    $cliente = $_POST["nombreCliente"];
                    $rutaPrueba = "https://www.google.com";

                  strtoupper($cliente);

                    $cons = mysqli_query($conn, "SELECT NumeroDeFactura, Receptor,clientes.RFC_Cliente,proveedores.RFC_Proveedor,Emisor,iva,Total_Impuestos,total,Ruta_Factura FROM facturas INNER JOIN clientes ON facturas.RFC_Cliente = clientes.RFC_Cliente INNER JOIN proveedores ON facturas.RFC_Proveedor = proveedores.RFC_Proveedor WHERE clientes.Receptor = '$cliente'");

                  



                    if ($cons->num_rows > 0) {
                        while ($filas = $cons->fetch_assoc()) {
                            echo "<tr><td>" . $filas["NumeroDeFactura"] . "</td>";
                            echo "<td>" . $filas["Receptor"] . "</td>";
                            echo "<td>" . $filas["RFC_Cliente"] . "</td>";
                            echo "<td>" . $filas["Emisor"] . "</td>";
                            echo "<td>" . $filas["RFC_Proveedor"] . "</td>";
                            echo "<td>" . $filas["iva"] . "</td>";
                            echo "<td>" . $filas["total"] . "</td>";
                            echo "<td>" . $filas["Total_Impuestos"] . "</td>";
                            echo "<td><a href='" . $filas["Ruta_Factura"] . "' target='_blank'>Ver factura</a></td>";
                            echo "</tr>";
                        }
                    }
                }



                ?>
            </tbody>
            <a href="" target="_blank"></a>
        </table>
    </div>




    <script src="js/creaForms"></script>
</body>

</html>