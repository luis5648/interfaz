
package Logicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.Conectar;


public class LogicasProveedores {
    
    
    private final String SQL_INSERT="INSERT INTO proveedores(RFC_proveedor,NombreEmisor) values(?,?)";
    private final String SQL_SELECT="SELECT* FROM Proveedores";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS; 
    private Conectar CN;
    
    public LogicasProveedores(){
        PS=null;
        CN= new Conectar();
    }
    private DefaultTableModel setTitulos(){
        DT= new DefaultTableModel();
    DT.addColumn("RFC");
    DT.addColumn("Nombre");
    
    return DT;
    }
    public DefaultTableModel getDatos(){
        try {
            setTitulos();
            PS=CN.getConnection().prepareStatement(SQL_SELECT);
            RS=PS.executeQuery();
            Object[] fila= new Object[2];
            while(RS.next()){
                fila[0]=RS.getString(1);
                fila[1]=RS.getString(2);
                
                
             DT.addRow(fila);
            }
            
            
        } catch (SQLException e) {
            System.out.println("error  al listar los datos"+e.getMessage());
        }finally{
            PS=null;
            RS=null;
            CN.Desconectar();
        }
        
        return DT; 
    }
    
    public int  insertDatos(String RFC__proveedor,String NombreEmisor){
              int res=0;       
        try{
             
            PS=CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1,RFC__proveedor);
            PS.setString(2, NombreEmisor);
            
            res=PS.executeUpdate();
            
            if(res>0){
                
            }
        } catch (SQLException e) {
        }finally{
            PS=null;
            CN.Desconectar();
        }
        
        
        return res;
    }
    
    
}
