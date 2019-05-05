<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "factura_electronicas_2";
$conn = new mysqli($servername, $username, $password, $dbname);
$acentos = $conn->query("SET NAMES 'utf8'");

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}
