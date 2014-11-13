/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTier.Server;

import DataTier.Packs.Datapack;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Jose
 */
public class NewClientsListener extends Thread {

    Server server;
    JTextArea server_text_area;

    public NewClientsListener(Server server, JTextArea server_text_area) {
        this.server = server;
        this.server_text_area = server_text_area;
    }

    @Override
    public void run() {
        System.out.println("Hilo listener de conexiones activo");

        while (true) {
            try {
                // Crea un datapack para el nuevo cliente
                Datapack newClientDataPack = new Datapack();
                //Se encuentra una conexion al servidor
                this.server.TheardToClient.add(new TheardToClient(this.server.serverSocket.accept(), this.server, server_text_area, newClientDataPack));
                //Se inicializa el HiloServidor correspondiente a un cliente conectandose
                this.server.TheardToClient.get(this.server.TheardToClient.size() - 1).start();
                this.server.ocean.addclient(newClientDataPack);
            } catch (Exception e) {
                e.printStackTrace();
                server_text_area.append("Error while tryinh to stablish new conection \n");
            }

        }

    }
}
