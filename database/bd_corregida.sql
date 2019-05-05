
-- Volcando estructura de base de datos para factura_electronicas

CREATE DATABASE factura_electronicas_2;
USE factura_electronicas_2;

-- Volcando estructura para tabla factura_electronicas.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `RFC_Clientes` varchar(59) NOT NULL,
  `Receptor` varchar(50) NOT NULL,
  PRIMARY KEY (`RFC_Clientes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `proveedores` (
  `RFC_proveedor` varchar(50) NOT NULL,
  `NombreEmisor` varchar(50) NOT NULL,
  PRIMARY KEY (`RFC_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;






CREATE TABLE IF NOT EXISTS `facturas` (
  `FacturaNumero` int(11) NOT NULL AUTO_INCREMENT,
  `TotalImpuestos` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `SumaTotal` float DEFAULT NULL,
  `fecha` varchar(59) DEFAULT NULL,
  `MetodoPago` varchar(50) DEFAULT NULL,
  `Moneda` varchar(50) DEFAULT NULL,
  `RFC_Clientes` varchar(50) DEFAULT NULL,
  `RFC_proveedor` varchar(50) DEFAULT NULL,
  `Ruta` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FacturaNumero`),
  KEY `RFC_Clientes` (`RFC_Clientes`),
  KEY `RFC_proveedor` (`RFC_proveedor`),
  CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`RFC_Clientes`) REFERENCES `clientes` (`rfc_clientes`),
  CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`RFC_proveedor`) REFERENCES `proveedores` (`rfc_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `login` (
  `idCliente` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

