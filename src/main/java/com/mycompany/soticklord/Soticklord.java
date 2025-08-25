package com.mycompany.soticklord;

import Clases.Seleccion;
import Clases.Batalla;

import javax.swing.*;
import java.awt.*;

public class Soticklord {

    static String[] ejercitoJugador1 = {null};
    static String[] ejercitoJugador2 = {null};

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Ventana inicial
            JFrame ventanaInicio = new JFrame("Seleccionar Jugadores");
            ventanaInicio.setSize(600, 300);
            ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaInicio.setLocationRelativeTo(null);
            ventanaInicio.setLayout(null);

            // Labels
            JLabel jugador1Label = new JLabel("Jugador 1", SwingConstants.CENTER);
            jugador1Label.setBounds(50, 30, 200, 30);

            JLabel jugador2Label = new JLabel("Jugador 2", SwingConstants.CENTER);
            jugador2Label.setBounds(350, 30, 200, 30);

            // Botones de seleccionar
            JButton btnJugador1 = new JButton("Seleccionar tropas");
            btnJugador1.setBounds(80, 100, 150, 40);

            JButton btnJugador2 = new JButton("Seleccionar tropas");
            btnJugador2.setBounds(380, 100, 150, 40);

            // Botón luchar (centro)
            JButton btnLuchar = new JButton("Luchar");
            btnLuchar.setBounds(230, 200, 120, 40);
            btnLuchar.setEnabled(false); // Deshabilitado al inicio

            // Acción jugador 1
            btnJugador1.addActionListener(e -> {
                Seleccion ventanaSeleccion = new Seleccion();
                ventanaSeleccion.setVisible(true);

                ventanaSeleccion.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent ev) {
                        ejercitoJugador1[0] = ventanaSeleccion.getEjercito();
                        System.out.println("Jugador 1 eligió:\n" + ejercitoJugador1[0]);
                        if (ejercitoJugador1[0] != null && ejercitoJugador2[0] != null) {
                            btnLuchar.setEnabled(true);
                        }
                    }
                });
            });

            // Acción jugador 2
            btnJugador2.addActionListener(e -> {
                Seleccion ventanaSeleccion = new Seleccion();
                ventanaSeleccion.setVisible(true);

                ventanaSeleccion.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent ev) {
                        ejercitoJugador2[0] = ventanaSeleccion.getEjercito();
                        System.out.println("Jugador 2 eligió:\n" + ejercitoJugador2[0]);
                        if (ejercitoJugador1[0] != null && ejercitoJugador2[0] != null) {
                            btnLuchar.setEnabled(true);
                        }
                    }
                });
            });

            // Acción luchar
            btnLuchar.addActionListener(e -> {
                ventanaInicio.dispose(); // cerramos selección
                new Batalla(ejercitoJugador1[0], ejercitoJugador2[0]).setVisible(true);
            });

            // Agregar componentes
            ventanaInicio.add(jugador1Label);
            ventanaInicio.add(jugador2Label);
            ventanaInicio.add(btnJugador1);
            ventanaInicio.add(btnJugador2);
            ventanaInicio.add(btnLuchar);

            ventanaInicio.setVisible(true);
        });

    }
}
