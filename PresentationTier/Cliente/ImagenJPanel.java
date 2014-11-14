/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PresentationTier.Cliente;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Jose
 */
public class ImagenJPanel extends javax.swing.JPanel {
ImageIcon Img = new ImageIcon();
public ImagenJPanel() {
this.setSize(300, 400); //se selecciona el tamaño del panel
}

//Se crea un método cuyo parámetro debe ser un objeto Graphics

public void paint(Graphics grafico) {
Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa



//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

setOpaque(false);
super.paintComponent(grafico);
}

public void setImageIcon(String imgUrl){
try{
Img = new ImageIcon(getClass().getResource(imgUrl)); 
}
catch(Exception e){
System.out.println("Imagen no encontrada "+imgUrl);

}

}

}