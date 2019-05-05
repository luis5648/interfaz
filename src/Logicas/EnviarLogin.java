
package Logicas;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnviarLogin implements Serializable{
    String ip,id,contrasenia;

    public EnviarLogin(String ip, String id, String contrasenia) {
        this.ip = ip;
        this.id = id;
        this.contrasenia = contrasenia;
    }

    public EnviarLogin() {
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
    public void EnviarLogin(String idp,String ipp,String contraseniap){
        EnviarLogin enviar= new EnviarLogin(idp, ipp, contraseniap);
        
        try {
            InetAddress direccion = InetAddress.getByName( ip );
            InetAddress direccionBandera = InetAddress.getByName( ip );
            
            Socket socket = new Socket( direccion, 2000);
            Socket socketBandera= new Socket(direccionBandera,1000);
            
            ObjectOutputStream paquete_Datos= new ObjectOutputStream(socket.getOutputStream());
            paquete_Datos.writeObject(enviar);
            DataOutputStream bandera= new DataOutputStream(socketBandera.getOutputStream());
            bandera.writeUTF("2");
        } catch (IOException ex) {
            Logger.getLogger(EnviarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
}