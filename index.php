<?php
require "php/Conexion.php";
require "php/Consultas.php";

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


    <div id="container">
        <form id="f1" method="post" action="">
            <div class="form-group">
                <h4>Busqueda por cliente</h3>
                    <label for="exampleInputEmail1">Nombre del cliente</label>
                    <input class="form-control" name="nombreCliente" placeholder="Nombre del cliente" required>

            </div>


            <button name="buscaClien" class="btn btn-primary">Buscar</button>
        </form>

        <form id="f2" method="post" action="">
            <div class="form-group">
                <h4>Busqueda por proveedor</h3>
                    <label for="exampleInputEmail1">Nombre proveedor</label>
                    <input class="form-control" name="nombreProveedor" placeholder="Nombre del proveedor" required>


            </div>
            <button name="buscaProv" class="btn btn-primary">Buscar</button>
        </form>

        <form id="f3" method="post" action="">
            <h4>Busqueda por factura</h3>
                <div class="form-group">
                    <label>Facturas disponibles por fecha</label>
                    <!-- a cambiar por un select -->

                    <select name="FacturasFechas" class="form-control" id="">
                        <?php
                        $facturasConsult = mysqli_query($conn, "SELECT fecha FROM facturas");
                        if ($facturasConsult->num_rows > 0) {
                            while ($opciones = $facturasConsult->fetch_assoc()) {
                                echo "<option value='$opciones[fecha]'> $opciones[fecha]</option>";
                            }
                        }

                        ?>
                    </select>

                </div>

                <button type="submit" name="buscaFact" class="btn btn-primary">Buscar</button>
        </form>
    </div>


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
                    <th scope="col">Fecha</th>
                    <th scope="col">Total de impuesto</th>
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

                    buscarClientes($cliente, $conn);
                } else if (isset($_POST["buscaProv"])) {

                    $proveedor = $_POST["nombreProveedor"];

                    buscarProveedor($proveedor, $conn);
                } else if (isset($_POST["buscaFact"])) {
                    $fecha = $_POST["FacturasFechas"];

                    buscarPorFecha($fecha, $conn);
                }

                ?>
            </tbody>
            <a href="" target="_blank"></a>
        </table>
    </div>




    <script src="js/creaForms"></script>
</body>

</html>