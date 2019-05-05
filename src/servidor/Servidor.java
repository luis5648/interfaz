package servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logicas.*;
import cliente.CorregirRuta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Servidor extends javax.swing.JFrame implements Runnable {

    String idLogin, ipLogin, contraseniaLogin;
    String idL, ipL, contraL;
    LogicaClientes LC;
    LogicasProveedores LP;
    LogicasFactura LF = new LogicasFactura();
     LogicaLogin logica ;
    Thread miHilo = new Thread(this);
    String DireccionCliente;
    

    public Servidor() {

        initComponents();
        txtEliminar.disable();
        miHilo.start();
        LC = new LogicaClientes();
        LP = new LogicasProveedores();
        LF = new LogicasFactura();
        logica= new LogicaLogin();
    }

    private void listarFacturas() {
        jTable1.setModel(LF.getDatos());
    }

    private void listar() {
        jTable1.setModel(LC.getDatos());
    }

    private void ListarProveedores() {
        jTable1.setModel(LP.getDatos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnMOSTRARPROVEEDORES = new javax.swing.JButton();
        btnMostrarTodoFacturas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtEliminar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtLeer = new javax.swing.JTextField();
        btnLeerXML = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("MOSTRAR TODO CLIENTES ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnMOSTRARPROVEEDORES.setText("MOSTRAR TODO PROVEEDORES");
        btnMOSTRARPROVEEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOSTRARPROVEEDORESActionPerformed(evt);
            }
        });

        btnMostrarTodoFacturas.setText("MOSTRAR TODO FACTURAS");
        btnMostrarTodoFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoFacturasActionPerformed(evt);
            }
        });

        jLabel1.setText("Eliminar un xml");

        jButton2.setText("eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("buscar cliente");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar Proveedor");

        btnProveedor.setText("Buscar proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel4.setText("Leer xml");

        txtLeer.setEnabled(false);

        btnLeerXML.setText("Leer");
        btnLeerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarTodoFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscarCliente)
                                            .addComponent(txtProveedor))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btnMOSTRARPROVEEDORES, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLeer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLeerXML, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnMOSTRARPROVEEDORES))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLeer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLeerXML, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarTodoFacturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtProveedor)
                                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        listar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMOSTRARPROVEEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOSTRARPROVEEDORESActionPerformed
        // TODO add your handling code here:
        ListarProveedores();
    }//GEN-LAST:event_btnMOSTRARPROVEEDORESActionPerformed

    private void btnMostrarTodoFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoFacturasActionPerformed
        // TODO add your handling code here:
        listarFacturas();
    }//GEN-LAST:event_btnMostrarTodoFacturasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CorregirRuta co = new CorregirRuta(txtEliminar.getText(), "\\", "\\\\");
        String rutaEliminar = co.obtenerRutaCorregidaWindows();
        File fichero = new File(rutaEliminar);
        fichero.delete();
        LF.deleteDatos(rutaEliminar);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1)) {
            System.out.println("fila:" + fila + " columna:" + columna);
        }

        System.out.println(jTable1.getValueAt(fila, columna));
        String rutaBorrar = (String) jTable1.getValueAt(fila, columna);
        txtEliminar.setText(rutaBorrar);
        txtLeer.setText(rutaBorrar);


    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        String rfcC = txtBuscarCliente.getText().toUpperCase();
        jTable1.setModel(LF.getCliente(rfcC));


    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        String rfcP = txtProveedor.getText().toUpperCase();
        jTable1.setModel(LF.getProveedor(rfcP));
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnLeerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerXMLActionPerformed


    }//GEN-LAST:event_btnLeerXMLActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(false);

            }
        });
    }

    @Override
    public void run() {
        System.out.println("listening...");
        xml verificar = new xml();
        try {
            ServerSocket Servidor = new ServerSocket(8080);

            ServerSocket loginServidor = new ServerSocket(9999);
            ServerSocket Bandera = new ServerSocket(1000);
            ServerSocket loginS = new ServerSocket(2000);

            while (true) {

                Socket bande = Bandera.accept();
                DataInputStream bandeD = new DataInputStream(bande.getInputStream());
                String bandera = bandeD.readUTF();
                 if (bandera.equals("1")) {
                    
                    EnviarRegistro registrarse;
                    Socket servidorlogin = loginServidor.accept();
                    ObjectInputStream paqueteDatos = new ObjectInputStream(servidorlogin.getInputStream());
                    registrarse = (EnviarRegistro) paqueteDatos.readObject();
                    idLogin = registrarse.getId();
                    ipLogin = registrarse.getIp();
                    contraseniaLogin = registrarse.getContrasenia();
                    LogicaLogin logica = new LogicaLogin();
                    int respuesta = logica.insertDatos(idLogin, contraseniaLogin);
                    System.out.println(respuesta);

                } else if (bandera.equals("2")) {
                     
                   EnviarLogin login;
                    Socket socket = loginS.accept();
                    DireccionCliente = socket.getInetAddress().getHostName();
                    ObjectInputStream enviar = new ObjectInputStream(socket.getInputStream());
                    login = (EnviarLogin) enviar.readObject();
                    idL = login.getId();
                    ipL = login.getIp();
                    contraL = login.getContrasenia();
                    socket.close();
                    enviar.close();
                    System.out.println("klelelelelel :" + idL + " ip: " + ipL + " contra :" + contraL);
                    int n = logica.login(idL, contraL);
                    Socket verificarLogin = new Socket(DireccionCliente, 3001);
                    DataOutputStream mandarmensaje = new DataOutputStream(verificarLogin.getOutputStream());
                    String mensajelogin;
                    if (n >= 1) {
                        mensajelogin = "1";
                    } else {
                        mensajelogin = "0";
                    }
                    mandarmensaje.writeUTF(mensajelogin);
                    verificarLogin.close();
                    mandarmensaje.close();

                } else if (bandera.equals("3")) {

                    Socket miscocket = Servidor.accept();

                    DireccionCliente = miscocket.getInetAddress().getHostName();

                    DataInputStream nombre = new DataInputStream(miscocket.getInputStream());
                    String nombreRuta = nombre.readUTF();
                    // Creamos flujo de entrada para leer los datos que envia el cliente 
                    DataInputStream dis = new DataInputStream(miscocket.getInputStream());
                    // Obtenemos el nombre del archivo

                    String nombreArchivo = dis.readUTF().toString();
                    System.out.println("ruta: " + nombreArchivo);
                    Date fecha = new Date();
                    String anio = String.valueOf(fecha.getYear() + 1900);
                    String mes = String.valueOf(fecha.getMonth() + 1);
                    String dia = String.valueOf(fecha.getDay());
                    String hora = String.valueOf(fecha.getHours());
                    String minutos = String.valueOf(fecha.getMinutes());
                    String segundos = String.valueOf(fecha.getSeconds());
                    String fe = "fecha" + anio + "_" + mes + "_" + dia + "_Hora_" + hora + "_" + minutos + "_" + segundos + "_";

                    String h1 = "";
                    if (nombreRuta.equals("h1")) {
                        h1 = "h1";
                    } else if (nombreRuta.equals("h2")) {
                        h1 = "h2";

                    } else if (nombreRuta.equals("h3")) {
                        h1 = "h3";
                    }
                    int xml = nombreArchivo.indexOf(".xml");
                    String sub = nombreArchivo.substring(0, xml);
                    h1 += "_" + sub + "_" + fe + ".xml";

                    //nombreArchivo=nuevo;
                    File car = new File("files/" + nombreRuta);
                    if (car.exists()) {
                        car.delete();
                        car.mkdirs();
                    } else {
                        car.mkdirs();
                    }

                    // Obtenemos el tamaño del archivo
                    int tam = dis.readInt();
                    System.out.println("Recibiendo Archivo " + nombreArchivo);
                    // Creamos flujo de salida, este flujo nos sirve para 
                    // indicar donde guardaremos el archivo
                    FileOutputStream fos = new FileOutputStream("files/" + nombreRuta + "/" + h1);
                    BufferedOutputStream out = new BufferedOutputStream(fos);
                    BufferedInputStream in = new BufferedInputStream(miscocket.getInputStream());

                    // Creamos el array de bytes para leer los datos del archivo
                    byte[] buffer = new byte[tam];
                    // Obtenemos el archivo mediante la lectura de bytes enviados
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) in.read();
                    }
                    //Escribimos el archivo
                    out.write(buffer);
                    //Cerramos los flujos
                    out.flush();
                    in.close();
                    out.close();
                    miscocket.close();

                    String origen = "files/" + nombreRuta + "/" + h1;
                    String origenContenido = verificar.leerArchivos(origen);
                    String estandar = "files/val/cfdi_correcto.xml";
                    String estandarContenido = verificar.leerArchivos(estandar);
                      
                    boolean ban = false;
                    try {
                        ban = verificar.optenerValidacion(origen);
                    } catch (Exception ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ban == true) {
                        System.out.println("los ficheros son correctos");
                      ExtraerDatosXML(origen);

                    } else {
                        System.out.println("el fichero es incorrecto");
                        File fichero = new File(origen);
                        fichero.delete();
                    }
                    
                    Socket socket = new Socket(DireccionCliente, 5000);

                    DataOutputStream servicio = new DataOutputStream(socket.getOutputStream());
                    String mensaje="alan";
                   if (ban == true) {
                        mensaje = "el archivo es correcto";
                    } else {
                        mensaje = "el archivo es incorrecto";
                    }
                    servicio.writeUTF(mensaje);
                }

            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (ParserConfigurationException ex) {
         //   Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (SAXException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnLeerXML;
    private javax.swing.JButton btnMOSTRARPROVEEDORES;
    private javax.swing.JButton btnMostrarTodoFacturas;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtEliminar;
    private javax.swing.JTextField txtLeer;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
public void ExtraerDatosXML(String ruta) throws ParserConfigurationException, SAXException, IOException, Exception {
        File archivo = new File(ruta);
       
      
               
           
       
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(archivo);
        document.getDocumentElement().normalize();

        //imprime el nodo raÃ­z del xml
        System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());

        //obtener el nombre del cliente y proveedor
        NodeList receptor = document.getElementsByTagName("cfdi:Receptor");
        NodeList emisor = document.getElementsByTagName("cfdi:Emisor");
        //obtener lo de facturas
        NodeList Traslado = document.getElementsByTagName("cfdi:Traslado");
        NodeList comprobante = document.getElementsByTagName("cfdi:Comprobante");
//          Obtener lo de proveedor
        Node nodoE = emisor.item(0);
        // obtener lo de cliente
        Node nodoR = receptor.item(0);
        //obtener lo de facturas
        Node nodoT = Traslado.item(0);
        Node nodoC = comprobante.item(0);

//obtener lo de clientes
        Element elementRes = (Element) nodoR;
        //obtener lo de proveedores
        Element elementEmi = (Element) nodoE;
        //obtener lo de  facturas
        Element elementT = (Element) nodoT;
        Element elementC = (Element) nodoC;

        //informaciÃ³n cliente:
        String nombreCliente = elementRes.getAttribute("Nombre");
        String rfcCliente = elementRes.getAttribute("Rfc");

        //informaciÃ³n del proveedor:
        String nombreProveedor="",rfcProveedor="";
        nombreProveedor = elementEmi.getAttribute("Nombre");
        rfcProveedor = elementEmi.getAttribute("Rfc");

        //Datos Factura 
        String Impuesto="",Base="",fecha="",MetodoPago="",Moneda="";
         Impuesto = elementT.getAttribute("Importe");

         Base = elementT.getAttribute("Base");

        fecha = elementC.getAttribute("Fecha");
         MetodoPago = elementC.getAttribute("MetodoPago");
         Moneda = elementC.getAttribute("Moneda");
         if(nombreProveedor.equals("")&& rfcProveedor.equals("") && Base.equals("") && fecha.equals("") && MetodoPago.equals("") && Moneda.equals("")){
             System.out.println(" datos erroneos");
             
         }else{
             
         
        
        int respuesta = LC.insertDatos(rfcCliente, nombreCliente);
        if (respuesta > 0) {
            System.out.println("se ingreso con todo");
        } else {
            System.out.println("no se ingreso \n\n\n");
        }
        LogicasProveedores LP = new LogicasProveedores();

        respuesta = LP.insertDatos(rfcProveedor, nombreProveedor);
        if (respuesta > 0) {
            System.out.println(" se guardo pro");
        } else {
            System.out.println(" no se agrego");
        }
        float TotalImpuesto = Float.parseFloat(Impuesto);
        float totalF = Float.parseFloat(Base);
        float sumaTotal = TotalImpuesto + totalF;

        LogicasFactura LF = new LogicasFactura();
        respuesta = LF.InserDatos(TotalImpuesto, totalF, sumaTotal, fecha, MetodoPago, Moneda, rfcCliente, rfcProveedor, ruta);
        if (respuesta > 0) {
            System.out.println("registro factura con exito");
        } else {
            System.out.println(" factura incorrecta");
        }
         }
           
    }

}
