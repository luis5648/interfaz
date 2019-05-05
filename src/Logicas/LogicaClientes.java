
package Logicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.Conectar;


public class LogicaClientes {
    private final String SQL_INSERT="INSERT INTO Clientes(RFC_Clientes,Receptor) values(?,?)";
    private final String SQL_SELECT="SELECT * FROM Clientes";
    
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS; 
    private Conectar CN;

    public LogicaClientes() {
        PS=null;
        CN= new Conectar();
    }
    private DefaultTableModel setTitulos(){
        DT= new DefaultTableModel();
    DT.addColumn("RFC ");
    DT.addColumn("RECEPTOR");
   
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
    
    
    
    
    
    public int  insertDatos(String  RFC_Cliente,String Receptor){
              int res=0;       
        try {
            
            PS=CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, RFC_Cliente);
            PS.setString(2,Receptor);
            
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
