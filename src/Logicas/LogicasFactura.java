package Logicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.Conectar;

public class LogicasFactura {

    private final String INSERT_INTO = "INSERT INTO facturas(TotalImpuestos,total,SumaTotal,fecha,MetodoPago,Moneda,RFC_Clientes,RFC_proveedor,Ruta)values(?,?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "select FacturaNumero,TotalImpuestos,total,SumaTotal,fecha,MetodoPago,Moneda,facturas.RFC_Clientes,facturas.RFC_proveedor,Ruta from facturas inner join Clientes on facturas.RFC_Clientes=Clientes.RFC_Clientes inner join proveedores on facturas.RFC_proveedor=proveedores.RFC_proveedor;";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private Conectar CN;

    public LogicasFactura() {
        PS = null;
        CN = new Conectar();

    }

    private DefaultTableModel setTitulos() {
        DT = new DefaultTableModel();
        DT.addColumn("Factura numero ");
        DT.addColumn("TotalImpuestos");
        DT.addColumn("total ");
        DT.addColumn("SumaTotal");
        DT.addColumn("fecha");
        DT.addColumn("MetodoPago");
        DT.addColumn("Moneda");
        DT.addColumn("RFC cliente");
        DT.addColumn("RFC proveedor");
        DT.addColumn("Ruta");

        return DT;
    }

    public DefaultTableModel getDatos() {
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getFloat(2);
                fila[2] = RS.getFloat(3);
                fila[3] = RS.getFloat(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);

                DT.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("error  al listar los datos" + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.Desconectar();
        }

        return DT;
    }

    public int InserDatos(float TotalImpuestos, float total, float SumaTotal, String fecha, String MetodoPago, String Moneda, String RFC_Clientes, String RFC_proveedor, String Ruta) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(INSERT_INTO);
            PS.setFloat(1, TotalImpuestos);
            PS.setFloat(2, total);
            PS.setFloat(3, SumaTotal);
            PS.setString(4, fecha);
            PS.setString(5, MetodoPago);
            PS.setString(6, Moneda);
            PS.setString(7, RFC_Clientes);
            PS.setString(8, RFC_proveedor);
            PS.setString(9, Ruta);

            res = PS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PS = null;
            CN.Desconectar();
        }
        return res;
    }

    public void deleteDatos(String ruta) {
        String SQL = "DELETE from facturas WHERE Ruta='" + ruta + "'";
        int res = 0;
        try {

            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos" + e.getMessage());
        } finally {
            PS = null;
            CN.Desconectar();
        }

    }

    public DefaultTableModel getProveedor(String RFC_proveedor) {
        try {

            String SQL = "select FacturaNumero,TotalImpuestos,total,SumaTotal,fecha,MetodoPago,Moneda,facturas.RFC_Clientes,facturas.RFC_proveedor,Ruta from facturas inner join Clientes on facturas.RFC_Clientes=Clientes.RFC_Clientes inner join proveedores on facturas.RFC_proveedor=proveedores.RFC_proveedor where facturas.RFC_proveedor='" + RFC_proveedor + "'";
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getFloat(2);
                fila[2] = RS.getFloat(3);
                fila[3] = RS.getFloat(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);

                DT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PS = null;
            RS = null;
            CN.Desconectar();
        }
        return DT;
    }
    public DefaultTableModel getCliente(String RFC_Clientes) {
        try {

            String SQL = "select FacturaNumero,TotalImpuestos,total,SumaTotal,fecha,MetodoPago,Moneda,facturas.RFC_Clientes,facturas.RFC_proveedor,Ruta from facturas inner join Clientes on facturas.RFC_Clientes=Clientes.RFC_Clientes inner join proveedores on facturas.RFC_proveedor=proveedores.RFC_proveedor where facturas.RFC_clientes='" + RFC_Clientes + "'";
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getFloat(2);
                fila[2] = RS.getFloat(3);
                fila[3] = RS.getFloat(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);

                DT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PS = null;
            RS = null;
            CN.Desconectar();
        }
        return DT;
    }
}
