package Clases;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Batalla extends JFrame {

    private final Map<String, String> imagenes = new HashMap<>();

    // Coordenadas (x,y,w,h) para texto y tropas
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
        // Inicializar mapa de imágenes
        cargarImagenes();

        // Configuración de ventana
        setTitle("Campo de Batalla");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Posiciones absolutas
        getContentPane().setBackground(new Color(216, 209, 151));

        // Mostrar tropas de ambos jugadores
        mostrarEjercito(ejercitoJugador1, coordsVidaJ1, coordsTropaJ1);
        mostrarEjercito(ejercitoJugador2, coordsVidaJ2, coordsTropaJ2);
    }

    // Mostrar tropas con base en las coordenadas
    private void mostrarEjercito(String ejercitoTexto, Rectangle[] coordsVida, Rectangle[] coordsTropa) {
        if (ejercitoTexto == null || ejercitoTexto.isEmpty()) {
            return;
        }

        String[] lineas = ejercitoTexto.split("\n");
        int index = 0;

        for (String linea : lineas) {
            if (linea.trim().isEmpty() || index >= coordsVida.length) {
                continue;
            }

            // Texto de vida
            JLabel vidaLabel = new JLabel(linea, SwingConstants.CENTER);
            vidaLabel.setFont(new Font("Arial", Font.BOLD, 12));
            vidaLabel.setBounds(coordsVida[index]);
            add(vidaLabel);

            // Imagen de tropa
            JLabel imgLabel = new JLabel();
            String ruta = obtenerImagen(linea);
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

    // Devuelve la ruta de la imagen según el tipo de tropa
    private String obtenerImagen(String linea) {
        for (String clave : imagenes.keySet()) {
            if (linea.contains(clave)) {
                return imagenes.get(clave);
            }
        }
        return null;
    }

    // Cargar rutas de imágenes
    private void cargarImagenes() {
        // Reyes
        imagenes.put("Rey Arquero", "recursos/rey/rey_arquero.png");
        imagenes.put("Rey Espadachin", "recursos/rey/rey_espadachin.png");
        imagenes.put("Rey Lanzatonio", "recursos/rey/rey_lanzatonio.png");

        // Tropas
        imagenes.put("Arquero", "recursos/Tropas/arquero_tropa.png");
        imagenes.put("Espadachin", "recursos/Tropas/espadachin_tropa.png");
        imagenes.put("Lanzatonio", "recursos/Tropas/lanzatonio_tropa.png");
    }
}
