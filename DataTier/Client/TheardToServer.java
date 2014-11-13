/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTier.Client;

import DataTier.Packs.Datapack;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class TheardToServer extends Thread {

    private boolean detener;
    private boolean pausa;

    ObjectInputStream ois;
    ObjectOutputStream oos;
    private Datapack Clientdatapack;
    private Datapack Serverdatapack;


    TheardToServer(ObjectInputStream ois, ObjectOutputStream oos, Datapack Clientdatapack) {
        this.ois = ois;
        this.oos = oos;
        this.Clientdatapack = Clientdatapack;
        detener = false;
        pausa = false;
        
        
        this.setName("(Client)Data Handler");
    }

    @Override
    public void run() {
        int opcion = 0;
        // solamente lee lo que el servidor threadServidor le envia
        while (!detener) {
            Clientdatapack.DatapackLock.lock();
            // Envia datos al server
            try {
                oos.writeObject(Clientdatapack);
                oos.reset();
            } catch (IOException ex) {
                System.out.println("Error enviando datapack:" + ex);
            }
            Clientdatapack.DatapackLock.unlock();
                      
            
            
            // Lee datos de Server
            try {
                boolean esperandoDatos= true; 
                while (esperandoDatos){
                    Serverdatapack = (Datapack) ois.readObject();
                    if (Serverdatapack != null) {
                        esperandoDatos = false;
                        DataFromServerpackToClientpack();       
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TheardToServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheardToServer.class.getName()).log(Level.SEVERE, null, ex);
            }


         
        }
    }

    private void DataFromServerpackToClientpack() {
        Clientdatapack.DatapackLock.lock();
        String data = Serverdatapack.self.toString() + "\n";
        System.out.println(Serverdatapack);
        Clientdatapack.self.color = Serverdatapack.self.color;
        Clientdatapack.self.depth = Serverdatapack.self.depth;
        Clientdatapack.self.direction = Serverdatapack.self.direction;
        Clientdatapack.self.loot_value = Serverdatapack.self.loot_value;
        Clientdatapack.self.speed = Serverdatapack.self.speed;
        Clientdatapack.self.size = Serverdatapack.self.size;
        Clientdatapack.neighborhood  = Serverdatapack.neighborhood;
        Clientdatapack.self.localisation = Serverdatapack.self.localisation; 
        Clientdatapack.self.health = Clientdatapack.self.health; 
        if (Clientdatapack.player.points<Serverdatapack.player.points){
            Clientdatapack.player.points = Serverdatapack.player.points; 
        }
        Clientdatapack.DatapackLock.unlock();
    }

    public void pausar() {
        this.pausa = !this.pausa;
    }

    public void detener() {
        this.detener = true;
    }

    public void reanudar() {
        this.pausa = false;
    }
}
