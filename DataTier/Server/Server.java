/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataTier.Server;

import DataTier.Packs.Datapack;
import LogicTier.Server.Ocean;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
/**
 *
 * @author Jose
 */

public class Server{
    
    public ArrayList<TheardToClient> TheardToClient = new ArrayList<TheardToClient>();
    
     
    public ServerSocket serverSocket;
    public Ocean ocean; 

    public void runServer(JTextArea server_text_area)
    {
        
        
        ocean = new Ocean();
     
        try{
            //Se empieza a escuchar desde este puerto
            serverSocket = new ServerSocket(3010);
            //Se empieza a correr para detectar conexiones de jugadores
            
            ocean.start();
            InetAddress IP=InetAddress.getLocalHost();
            server_text_area.append("IP of my system is := "+IP.getHostAddress());
            NewClientsListener clientListener = new NewClientsListener(this, server_text_area);
            clientListener.start();
        
        }
    
        catch(Exception e){
            System.out.println("Error en el servidor");
        }
        
      
    
    }
   
}
