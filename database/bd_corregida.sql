create database facturas_electronicas_2;
use facturas_electronicas_2;

create table login (idCliente varchar(50) not null,contrasenia varchar(50) not null);

create table clientes (RFC_Clientes varchar(50) not null,Receptor varchar(50) not null);

create table proveedores (RFC_provedor varchar (50) not null,NombreEmisor varchar(50) not null);

create table facturas (FacturaNumero int primary key auto_increment ,TotalImpuestos float not null,total float not null,SumaTotal float not null,fecha varchar(50) not null,MetodoPago varchar(50) not null,Moneda varchar(50) not null,RFC_Clientes varchar(50) not null,RFC_provedor varchar(50) not null,ruta varchar(100) not null);



insert into clientes values("123","123456");
insert facturas values(12,123,123,123,"15","18","187","198","197","198");


insert login values("1","123456");


 insert into proveedores values("123456789","mirsha");

  insert into facturas values(2,200,500,50,"12/12/12","tarjeta","pesos","123","pepe","C://");