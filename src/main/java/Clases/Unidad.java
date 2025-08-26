package Clases;

import javax.swing.*;

public class Unidad {
    private String nombre;
    private int vida;
    private JLabel labelVida;

    public Unidad(String nombre, int vida, JLabel labelVida) {
        this.nombre = nombre;
        this.vida = vida;
        this.labelVida = labelVida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void recibirDaño(int dmg) {
        vida -= dmg;
        if (vida < 0) vida = 0;
        actualizarLabel();
    }

    private void actualizarLabel() {
        if (labelVida != null) {
            labelVida.setText("Vida: " + vida);
        }
    }
}
