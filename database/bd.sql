create database facturas_Electronicas;
use facturas_Electronicas;
create table proveedores(
  RFC_Proveedor varchar(15) not null primary key,
  Emisor varchar(25),
  NumeroSerieCertificadoSAT varchar(25),
  Ruta_provedor varchar(25)
);
create table clientes(
  RFC_Cliente varchar(15) not null primary key,
  Receptor varchar(25),
  Fechadesde varchar(25),
  Fechahasta varchar(25),
  TotalImpuestos varchar(25),
  MontoAPagarEnLetras varchar(30),
  Ruta_cliente varchar(15)
);
create table facturas(
  NumeroDeFactura int not null primary key,
  Total_Impuestos int,
  iva float,
  total int,
  fecha date,
  RFC_Proveedor varchar(15),
  RFC_Cliente varchar(15),
  foreign key (RFC_Proveedor) references proveedores(RFC_Proveedor),
  foreign key (RFC_Cliente) references clientes(RFC_Cliente),
  Ruta_Factura varchar(25)
);