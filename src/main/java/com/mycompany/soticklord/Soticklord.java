package com.mycompany.soticklord;

import java.util.Scanner;
import Clases.Rey;
import javax.swing.*;
import java.awt.*;

public class Soticklord {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Inicia Sesion");
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); //(opcional)
        ventana.setLayout(null); //ventana cerrada ?

        // Cargar imagen original
        ImageIcon iconoOriginal = new ImageIcon("waos.png");     
        // Queremos escalar a un ancho máximo de 300 px
        int anchoDeseado = 200;
        int altoDeseado = 300;
        
        // Escalar
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imgEscalada);

        //posicion de la imagen
        JLabel etiquetaImagen = new JLabel(iconoEscalado);
        etiquetaImagen.setBounds(0, 60, anchoDeseado, altoDeseado);

        ventana.add(etiquetaImagen);
        ventana.setVisible(true);
    }

}
