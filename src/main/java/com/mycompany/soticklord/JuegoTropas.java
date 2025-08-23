package com.mycompany.soticklord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoTropas extends JFrame {

    // Combobox para seleccionar
    private JComboBox<String> cbRey, cbTropa1, cbTropa2, cbTropa3, cbTropa4, cbTropa5;

    // Labels donde aparecerán las imágenes
    private JLabel lblRey, lblTropa1, lblTropa2, lblTropa3, lblTropa4, lblTropa5;

    public JuegoTropas() {
        setTitle("Selecciona tu ejército");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new GridLayout(1, 2)); // dos mitades pantalla

        // ----------- PANEL IZQUIERDO (Opciones) -----------
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(7, 2, 5, 5));

        // Opciones rey y tropas
        cbRey = new JComboBox<>(new String[]{"Rey Arquero", "Rey Lanzatonio", "Rey Espadachin"});
        cbTropa1 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa2 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa3 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa4 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa5 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});

        panelIzquierdo.add(new JLabel("Rey:"));
        panelIzquierdo.add(cbRey);
        panelIzquierdo.add(new JLabel("Tropa 1:"));
        panelIzquierdo.add(cbTropa1);
        panelIzquierdo.add(new JLabel("Tropa 2:"));
        panelIzquierdo.add(cbTropa2);
        panelIzquierdo.add(new JLabel("Tropa 3:"));
        panelIzquierdo.add(cbTropa3);
        panelIzquierdo.add(new JLabel("Tropa 4:"));
        panelIzquierdo.add(cbTropa4);
        panelIzquierdo.add(new JLabel("Tropa 5:"));
        panelIzquierdo.add(cbTropa5);

        // ----------- PANEL DERECHO (Imágenes) -----------
        JPanel panelDerecho = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);

        // Labels con imágenes por defecto
        lblRey = new JLabel(new ImageIcon("stickman_rey.png"));
        lblTropa1 = new JLabel(new ImageIcon("stickman_tropa.png"));
        lblTropa2 = new JLabel(new ImageIcon("stickman_tropa.png"));
        lblTropa3 = new JLabel(new ImageIcon("stickman_tropa.png"));
        lblTropa4 = new JLabel(new ImageIcon("stickman_tropa.png"));
        lblTropa5 = new JLabel(new ImageIcon("stickman_tropa.png"));

        // Posiciones en el panel (Rey atrás, tropas en filas)
        gbc.gridx = 1; gbc.gridy = 2; panelDerecho.add(lblRey, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0; panelDerecho.add(lblTropa1, gbc);
        gbc.gridx = 2; panelDerecho.add(lblTropa2, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0; panelDerecho.add(lblTropa3, gbc);
        gbc.gridx = 1; panelDerecho.add(lblTropa4, gbc);
        gbc.gridx = 2; panelDerecho.add(lblTropa5, gbc);

        // ----------- EVENTOS -----------

        // Rey
        cbRey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = cbRey.getSelectedItem().toString();
                switch (seleccion) {
                    case "Rey Arquero":
                        lblRey.setIcon(new ImageIcon("rey_arquero.png"));
                        break;
                    case "Rey Lanzatonio":
                        lblRey.setIcon(new ImageIcon("rey_lanzatonio.png"));
                        break;
                    case "Rey Espadachin":
                        lblRey.setIcon(new ImageIcon("rey_espadachin.png"));
                        break;
                }
            }
        });

        // Tropas (mismo diseño, cambia según elección)
        ActionListener tropaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String seleccion = cb.getSelectedItem().toString();
                JLabel destino;

                if (cb == cbTropa1) destino = lblTropa1;
                else if (cb == cbTropa2) destino = lblTropa2;
                else if (cb == cbTropa3) destino = lblTropa3;
                else if (cb == cbTropa4) destino = lblTropa4;
                else destino = lblTropa5;

                switch (seleccion) {
                    case "Arquero":
                        destino.setIcon(new ImageIcon("arquero_tropa.png"));
                        break;
                    case "Lanzatonio":
                        destino.setIcon(new ImageIcon("lanzatonio_tropa.png"));
                        break;
                    case "Espadachin":
                        destino.setIcon(new ImageIcon("espadachin_tropa.png"));
                        break;
                }
            }
        };

        cbTropa1.addActionListener(tropaListener);
        cbTropa2.addActionListener(tropaListener);
        cbTropa3.addActionListener(tropaListener);
        cbTropa4.addActionListener(tropaListener);
        cbTropa5.addActionListener(tropaListener);

        // ----------- AGREGAR A LA VENTANA -----------
        add(panelIzquierdo);
        add(panelDerecho);

        setLocationRelativeTo(null); // centrar
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoTropas::new);
    }
}
