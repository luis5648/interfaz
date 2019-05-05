/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servidor.Conectar;


public class LogicaLogin {
   private final String INSERTSQL="INSERT INTO login(idCliente,contrasenia) values(?,?)"; 
   private PreparedStatement PS;
    private ResultSet RS; 
    private Conectar CN;
    
    private Statement stmt;
 
    public int  insertDatos(String idCliente,String contrasenia){
              int res=0;       
        try {
            
            PS=CN.getConnection().prepareStatement(INSERTSQL);
            PS.setString(1, idCliente);
            PS.setString(2,contrasenia);
            
            res=PS.executeUpdate();
            
            if(res>0){
                
            }
        } catch (SQLException e) {
        }finally{
            
        }
        return res;
    }
    public int  login(String usuario ,String pass){
       int resultado=0;
       
       String  sql="select * from login where idCliente= '"+usuario+"' and contrasenia='"+pass+"'";
        try {
           Connection cn=CN.getConnection();
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                resultado=1;
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LogicaLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
        }
        return resultado;
        }
        
    
}
