/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.Image;
import java.io.InputStream;

/**
 * Ventana principal donde se mostrarán el mundo y el personaje.
 */
class VistaMundo extends JFrame {

    private final static int ANCHO = 576;
    private final static int ALTO = 324;

    private Personaje personaje;
    private Timer temporizador;

    /**
     * Construye la ventana e inicia el temporizador para presentar
     * los cuadros de animación.
     * @throws IOException Si no logra abrir el archivo con la imagen
     *         de fondo.
     */
    VistaMundo() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final InputStream in = getClass().getResourceAsStream("/recursos/Background.png");
        final Image backgroundImage = javax.imageio.ImageIO.read(in);          

        JPanel canvas = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, null);
                if(personaje != null) {
                    personaje.dibújate(g);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(ANCHO, ALTO);
            }
        };
        setContentPane(canvas);

        ActionListener animador = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
            }
        };
        temporizador = new Timer(250, animador);
        temporizador.start();

        pack();
        setVisible(true);
    }

    /**
     * Asigna al personaje que se mostrará en la ventana.
     * @param personaje
     */
    void muestraPersonaje(Personaje personaje) {
        personaje.asignaPosiciónX(personaje.LADO);
        personaje.asignaPosiciónY(ALTO - personaje.LADO * 2);
        this.personaje = personaje;
    }
}
