package Clases;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;




public class Batalla extends JFrame {
    
    // Coordenadas (x,y,w,h) para texto y tropas jugador 1
    private final Rectangle[] coordsVidaJ1 = {
        new Rectangle(50, 200, 100, 20),
        new Rectangle(230, 125, 100, 20),
        new Rectangle(230, 275, 100, 20),
        new Rectangle(400, 50, 100, 20),
        new Rectangle(400, 200, 100, 20),
        new Rectangle(400, 350, 100, 20)
    };
    private final Rectangle[] coordsTropaJ1 = {
        new Rectangle(50, 225, 120, 120),
        new Rectangle(230, 150, 120, 120),
        new Rectangle(230, 300, 120, 120),
        new Rectangle(400, 75, 120, 120),
        new Rectangle(400, 225, 120, 120),
        new Rectangle(400, 375, 120, 120)
    };

    // Coordenadas jugador 2
    private final Rectangle[] coordsVidaJ2 = {
        new Rectangle(910, 200, 100, 20),
        new Rectangle(740, 125, 100, 20),
        new Rectangle(740, 275, 100, 20),
        new Rectangle(570, 50, 100, 20),
        new Rectangle(570, 200, 100, 20),
        new Rectangle(570, 350, 100, 20)
    };
    private final Rectangle[] coordsTropaJ2 = {
        new Rectangle(910, 225, 120, 120),
        new Rectangle(740, 150, 120, 120),
        new Rectangle(740, 300, 120, 120),
        new Rectangle(570, 75, 120, 120),
        new Rectangle(570, 225, 120, 120),
        new Rectangle(570, 375, 120, 120)
    };

    public Batalla(String ejercitoJugador1, String ejercitoJugador2) {
        // Configuración de ventana
        setTitle("Campo de Batalla");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(216, 209, 151));

        // Mostrar tropas de ambos jugadores
        mostrarEjercito(ejercitoJugador1, coordsVidaJ1, coordsTropaJ1, 1);
        mostrarEjercito(ejercitoJugador2, coordsVidaJ2, coordsTropaJ2, 2);

        JButton btnBatalla = new JButton("Empezar Batalla");
        btnBatalla.setBounds(450, 500, 200, 40);
        add(btnBatalla);

        btnBatalla.addActionListener(e -> preguntarTurnoInicial());

    }

    private void preguntarTurnoInicial() {
        String[] opciones = {"Jugador 1", "Jugador 2"};
        int eleccion = JOptionPane.showOptionDialog(
                this,
                "¿Qué jugador iniciará primero?",
                "Turno inicial",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (eleccion == 0) {
            iniciarBatalla(1);
        } else if (eleccion == 1) {
            iniciarBatalla(2);
        }
    }

    private void iniciarBatalla(int jugadorInicial) {
        JOptionPane.showMessageDialog(this,
                "La batalla ha comenzado. Empieza el Jugador " + jugadorInicial);
        // TODO: lógica de turnos y ataques
    }

    // Mostrar tropas en el panel según jugador
    private void mostrarEjercito(String ejercitoTexto, Rectangle[] coordsVida, Rectangle[] coordsTropa, int jugador) {
        if (ejercitoTexto == null || ejercitoTexto.isEmpty()) {
            return;
        }

        String[] lineas = ejercitoTexto.split("\n");
        int index = 0;

        for (String linea : lineas) {
            if (linea.trim().isEmpty() || index >= coordsVida.length) {
                continue;
            }

            // Extraer solo la vida con regex
            String vidaTexto = extraerVida(linea);

            // Texto de vida
            JLabel vidaLabel = new JLabel(vidaTexto, SwingConstants.CENTER);
            vidaLabel.setFont(new Font("Arial", Font.BOLD, 12));
            vidaLabel.setBounds(coordsVida[index]);
            add(vidaLabel);

            // Imagen de tropa/reino
            JLabel imgLabel = new JLabel();
            String ruta = obtenerImagen(linea, jugador);
            if (ruta != null) {
                ImageIcon icono = new ImageIcon(ruta);
                Image img = icono.getImage().getScaledInstance(
                        coordsTropa[index].width,
                        coordsTropa[index].height,
                        Image.SCALE_SMOOTH
                );
                imgLabel.setIcon(new ImageIcon(img));
            }
            imgLabel.setBounds(coordsTropa[index]);
            add(imgLabel);

            index++;
        }
    }

    // Devuelve la ruta según jugador y tipo de tropa/rey
    private String obtenerImagen(String linea, int jugador) {
        String base = "recursos/";
        String carpeta = (jugador == 1) ? "jugador1/" : "jugador2/";

        // Reyes primero
        if (linea.contains("Rey Arquero")) {
            return base + "rey/" + carpeta + "rey_arquero.png";
        }
        if (linea.contains("Rey Espadachin")) {
            return base + "rey/" + carpeta + "rey_espadachin.png";
        }
        if (linea.contains("Rey Lanzatonio")) {
            return base + "rey/" + carpeta + "rey_lanzatonio.png";
        }

        // Tropas
        if (linea.contains("Arquero")) {
            return base + "Tropas/" + carpeta + "arquero_tropa.png";
        }
        if (linea.contains("Espadachin")) {
            return base + "Tropas/" + carpeta + "espadachin_tropa.png";
        }
        if (linea.contains("Lanzatonio")) {
            return base + "Tropas/" + carpeta + "lanzatonio_tropa.png";
        }

        return null;
    }

    // Extraer solo "Vida: X" de la línea
    private String extraerVida(String linea) {
        Pattern p = Pattern.compile("\\(Vida: (\\d+)\\)");
        Matcher m = p.matcher(linea);
        if (m.find()) {
            return "Vida: " + m.group(1);
        }
        return "Vida: ?";
    }
}
