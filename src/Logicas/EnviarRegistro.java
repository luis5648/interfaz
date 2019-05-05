/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logicas;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan gonzalez
 */
public class EnviarRegistro  implements Serializable{
    String ip;
    String id;
    String contrasenia;
    

    public EnviarRegistro(String ip, String id, String contrasenia) {
        this.ip = ip;
        this.id = id;
        this.contrasenia = contrasenia;
        
    }
    public EnviarRegistro(){
        
    }
    

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    
    public void EnviarRe(String idp,String ipp,String Contrasenia){
        EnviarRegistro enviar = new EnviarRegistro(idp, ipp, Contrasenia);
        try {
            // Creamos la direccion IP de la maquina que recibira el archivo
            InetAddress direccion = InetAddress.getByName( ip );
            InetAddress direccionBandera = InetAddress.getByName( ip );
            
            
            // Creamos el Socket con la direccion y elpuerto de comunicacion
            Socket socket = new Socket( direccion, 9999);
            Socket socketBandera= new Socket(direccionBandera,1000);
          
            ObjectOutputStream paquete_Datos= new ObjectOutputStream(socket.getOutputStream());
            paquete_Datos.writeObject(enviar);
            DataOutputStream bandera= new DataOutputStream(socketBandera.getOutputStream());
            bandera.writeUTF("1");
            
           
            
            paquete_Datos.close();
            socket.close();
            bandera.close();
            socketBandera.close();
        } catch (IOException ex) {
            Logger.getLogger(EnviarRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
