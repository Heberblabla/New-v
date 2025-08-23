package com.mycompany.soticklord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JuegoTropas extends JFrame {

    private JComboBox<String> cbRey, cbTropa1, cbTropa2, cbTropa3, cbTropa4, cbTropa5;
    private JLabel lblRey, lblTropa1, lblTropa2, lblTropa3, lblTropa4, lblTropa5;

    public JuegoTropas() {
        setTitle("Selecciona tu ejército");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(null); // posiciones absolutas

        // ------------ COMBOBOX (izquierda) ----------------
        JLabel lblTitulo = new JLabel("Configura tu ejército:");
        lblTitulo.setBounds(30, 20, 200, 30);
        add(lblTitulo);

        cbRey = new JComboBox<>(new String[]{"Rey Arquero", "Rey Lanzatonio", "Rey Espadachin"});
        cbRey.setBounds(30, 70, 150, 30);
        add(new JLabel("Rey:")).setBounds(30, 50, 100, 20);
        add(cbRey);

        cbTropa1 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa1.setBounds(30, 120, 150, 30);
        add(new JLabel("Tropa 1:")).setBounds(30, 100, 100, 20);
        add(cbTropa1);

        cbTropa2 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa2.setBounds(30, 170, 150, 30);
        add(new JLabel("Tropa 2:")).setBounds(30, 150, 100, 20);
        add(cbTropa2);

        cbTropa3 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa3.setBounds(30, 220, 150, 30);
        add(new JLabel("Tropa 3:")).setBounds(30, 200, 100, 20);
        add(cbTropa3);

        cbTropa4 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa4.setBounds(30, 270, 150, 30);
        add(new JLabel("Tropa 4:")).setBounds(30, 250, 100, 20);
        add(cbTropa4);

        cbTropa5 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa5.setBounds(30, 320, 150, 30);
        add(new JLabel("Tropa 5:")).setBounds(30, 300, 100, 20);
        add(cbTropa5);

        // ------------ IMÁGENES (derecha) ----------------
        lblRey = new JLabel(escalarImagen("stickman_rey.png", 120, 120));
        lblRey.setBounds(300, 225, 120, 120); // posición y tamaño
        add(lblRey);

        
        lblTropa1 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa1.setBounds(480, 150, 100, 100);
        add(lblTropa1); // izquierda menos<-- --> derecha mas
                        //altura mas . desaltura menos

        lblTropa2 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa2.setBounds(480, 300, 100, 100);
        add(lblTropa2);

        
        lblTropa3 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa3.setBounds(650, 75, 100, 100);
        add(lblTropa3);

        lblTropa4 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa4.setBounds(650, 225, 100, 100);
        add(lblTropa4);

        lblTropa5 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa5.setBounds(650, 375, 100, 100);
        add(lblTropa5);

        // ------------ EVENTOS ----------------
        cbRey.addActionListener(e -> {
            String seleccion = cbRey.getSelectedItem().toString();
            switch (seleccion) {
                case "Rey Arquero":
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_arquero.png", 120, 120));
                    break;
                case "Rey Lanzatonio":
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_lanzatonio.png", 120, 120));
                    break;
                case "Rey Espadachin":
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_espadachin.png", 120, 120));
                    break;
            }
        });

        ActionListener tropaListener = e -> {
            JComboBox cb = (JComboBox) e.getSource();
            JLabel destino;
            if (cb == cbTropa1) {
                destino = lblTropa1;
            } else if (cb == cbTropa2) {
                destino = lblTropa2;
            } else if (cb == cbTropa3) {
                destino = lblTropa3;
            } else if (cb == cbTropa4) {
                destino = lblTropa4;
            } else {
                destino = lblTropa5;
            }

            String seleccion = cb.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    destino.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 100, 100));
                    break;
                case "Lanzatonio":
                    destino.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 100, 100));
                    break;
                case "Espadachin":
                    destino.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 100, 100));
                    break;
            }
        };

        cbTropa1.addActionListener(tropaListener);
        cbTropa2.addActionListener(tropaListener);
        cbTropa3.addActionListener(tropaListener);
        cbTropa4.addActionListener(tropaListener);
        cbTropa5.addActionListener(tropaListener);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ----------- FUNCIÓN PARA ESCALAR IMÁGENES -----------
    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoTropas::new);
    }
}
