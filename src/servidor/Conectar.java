
package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conectar {
     public static final String URL = "jdbc:mysql://localhost:3306/factura_electronicas_2?useTimezone=true&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static Connection   conn;

    public Conectar() {
        this.conn = null;
    }
    
    
    public static Connection getConnection() {
        
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn=  DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("coneccion positiva");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conn;
    }
    public void Desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Error al cerrar la conexion",JOptionPane.ERROR_MESSAGE);
        }
    }
}
