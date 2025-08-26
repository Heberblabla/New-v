package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Seleccion extends JFrame {

    private JComboBox<String> cbRey, cbTropa1, cbTropa2, cbTropa3, cbTropa4, cbTropa5;
    private JLabel lblRey, lblTropa1, lblTropa2, lblTropa3, lblTropa4, lblTropa5;
    private JLabel vidaRey, vidaT1, vidaT2, vidaT3, vidaT4, vidaT5;

    // 🔹 Variable que guarda el ejército
    private String ejercito = null;

    public Seleccion() {
        setTitle("Selecciona tu ejército");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        getContentPane().setBackground(Color.decode("#d8d197"));
        setLayout(null);

        // ------------ OPCIONES IZQUIERDA ----------------
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

        // ------------ IMÁGENES DERECHA ----------------
        lblRey = new JLabel(escalarImagen("stickman_rey.png", 120, 120));
        lblRey.setBounds(300, 225, 120, 120);
        add(lblRey);

        lblTropa1 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa1.setBounds(480, 150, 100, 100);
        add(lblTropa1);

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

        // ------------ VIDA LABELS ----------------
        vidaRey = new JLabel("Vida: -");
        vidaRey.setBounds(300, 200, 120, 20);
        add(vidaRey);

        vidaT1 = new JLabel("Vida: -");
        vidaT1.setBounds(480, 130, 100, 20);
        add(vidaT1);

        vidaT2 = new JLabel("Vida: -");
        vidaT2.setBounds(480, 280, 100, 20);
        add(vidaT2);

        vidaT3 = new JLabel("Vida: -");
        vidaT3.setBounds(650, 55, 100, 20);
        add(vidaT3);

        vidaT4 = new JLabel("Vida: -");
        vidaT4.setBounds(650, 205, 100, 20);
        add(vidaT4);

        vidaT5 = new JLabel("Vida: -");
        vidaT5.setBounds(650, 355, 100, 20);
        add(vidaT5);

        // ------------ EVENTOS ----------------
        cbRey.addActionListener(e -> {
            String seleccion = cbRey.getSelectedItem().toString();
            switch (seleccion) {
                case "Rey Arquero":
                    lblRey.setIcon(escalarImagen("recursos/rey/jugador1/rey_arquero.png", 120, 120));
                    vidaRey.setText("Vida: 300");
                    break;
                case "Rey Lanzatonio":
                    lblRey.setIcon(escalarImagen("recursos/rey/jugador1/rey_lanzatonio.png", 120, 120));
                    vidaRey.setText("Vida: 350");
                    break;
                case "Rey Espadachin":
                    lblRey.setIcon(escalarImagen("recursos/rey/jugador1/rey_espadachin.png", 120, 120));
                    vidaRey.setText("Vida: 400");
                    break;
            }
        });

        ActionListener tropaListener = e -> {
            JComboBox cb = (JComboBox) e.getSource();
            JLabel destino;
            JLabel vidaLabel;
            if (cb == cbTropa1) {
                destino = lblTropa1;
                vidaLabel = vidaT1;
            } else if (cb == cbTropa2) {
                destino = lblTropa2;
                vidaLabel = vidaT2;
            } else if (cb == cbTropa3) {
                destino = lblTropa3;
                vidaLabel = vidaT3;
            } else if (cb == cbTropa4) {
                destino = lblTropa4;
                vidaLabel = vidaT4;
            } else {
                destino = lblTropa5;
                vidaLabel = vidaT5;
            }

            String seleccion = cb.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    destino.setIcon(escalarImagen("recursos/Tropas/jugador1/arquero_tropa.png", 100, 100));
                    vidaLabel.setText("Vida: 100");
                    break;
                case "Lanzatonio":
                    destino.setIcon(escalarImagen("recursos/Tropas/jugador1/lanzatonio_tropa.png", 100, 100));
                    vidaLabel.setText("Vida: 120");
                    break;
                case "Espadachin":
                    destino.setIcon(escalarImagen("recursos/Tropas/jugador1/espadachin_tropa.png", 100, 100));
                    vidaLabel.setText("Vida: 150");
                    break;
            }
        };

        cbTropa1.addActionListener(tropaListener);
        cbTropa2.addActionListener(tropaListener);
        cbTropa3.addActionListener(tropaListener);
        cbTropa4.addActionListener(tropaListener);
        cbTropa5.addActionListener(tropaListener);

        // ------------ BOTÓN GUARDAR ----------------
        JButton btnGuardar = new JButton("Guardar Ejército");
        btnGuardar.setBounds(30, 400, 150, 40);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            ejercito
                    = cbRey.getSelectedItem() + " (" + vidaRey.getText() + ")\n"
                    + cbTropa1.getSelectedItem() + " (" + vidaT1.getText() + ")\n"
                    + cbTropa2.getSelectedItem() + " (" + vidaT2.getText() + ")\n"
                    + cbTropa3.getSelectedItem() + " (" + vidaT3.getText() + ")\n"
                    + cbTropa4.getSelectedItem() + " (" + vidaT4.getText() + ")\n"
                    + cbTropa5.getSelectedItem() + " (" + vidaT5.getText() + ")";

            JOptionPane.showMessageDialog(this, ejercito, "Ejército Guardado", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // 🔹 cerrar la ventana después de guardar
        });

        setLocationRelativeTo(null);
    }

    // ----------- FUNCIÓN PARA ESCALAR IMÁGENES -----------
    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    // 🔹 Método para obtener el ejército guardado
    public String getEjercito() {
        return ejercito;
    }
}
