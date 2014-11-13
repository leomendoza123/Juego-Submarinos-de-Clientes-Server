/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataTier.Client;

import DataTier.Packs.Datapack;
import LogicTier.Client.ClientDataInterfaceHandler;
import PresentationTier.Cliente.PantallaBienvenidaCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Client {
    
   public static String IP_SERVER = "localhost"; //IP del Servidor
   Socket cliente = null;//para la comunicacion
   TheardToServer hiloCliente;

    public void conexion(Datapack datapack, PantallaBienvenidaCliente patallacliente) throws IOException 
   {
      try {
          // se conecta con dos sockets al server, uno comunicacion otro msjes
         cliente = new Socket(Client.IP_SERVER, 3010);
         // inicializa las entradas-lectura y salidas-escritura
         ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
         ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
         //Lo coloca en la ventana
               
        hiloCliente = new TheardToServer(ois, oos, datapack);
        hiloCliente.start();
        
        ClientDataInterfaceHandler DataInterface = new ClientDataInterfaceHandler (datapack, patallacliente); 
        DataInterface.start();
        
         
      }

      catch (IOException e){
         System.out.println("\tEl servidor no esta levantado");
         System.out.println("\t=============================");
      }
      catch(Exception ex){
      System.out.println("Existe algun error");
      }

   }
  
    
}
