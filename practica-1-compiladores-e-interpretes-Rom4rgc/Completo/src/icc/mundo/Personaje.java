/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import java.io.IOException;
import javax.swing.Timer;
import java.awt.Graphics;
import java.util.EnumMap;
import java.awt.Point;

/**
 * Clase para representar a un personaje animado.
 */
public class Personaje {
    
    /**
     * Número de pixeles que mide cada cuadrito de animación
     * para los personajes en esta aplicación.
     */
	static final int LADO = 48;

    private Acción acción;
    private final String nombre;
    private EnumMap<Estado, Acción> acciones;
	private int posX;
	private int posY;

    /**
     * Constructor.
     * @param nombre identificador del tipo de personaje a representar,
     *        debe corresponder a un paquete de imágenes disponible
     *        entre los recursos de la aplicación.
     */
    public Personaje(String nombre) {
        this.nombre = nombre;
        acciones = new EnumMap<Estado, Acción>(Estado.class);
		try {
            acciones.put(Estado.Quieto, new AcciónQuieto(nombre));
            acciones.put(Estado.Corriendo, new AcciónCorriendo(nombre));
            acciones.put(Estado.Saltando, new AcciónSaltando(nombre));
		} catch(IOException ioe) {
			System.err.println("No fue posible cargar las imágenes");
			System.exit(1);
		}
        espera();
    }

    /**
     * Posición x en la ventana donde se dibujará al personaje.
     * @param posX coordenada x.
     */
	public void asignaPosiciónX(int posX) {
		this.posX = posX;
	}

    /**
     * Posición y en la ventana donde se dibujará al personaje.
     * @param posY coordenada y.  La posición cero se encuentra en la
     *             parte superior de la ventana.
     */
	public void asignaPosiciónY(int posY) {
		this.posY = posY;
	}

    /**
     * Dibuja el cuadro de animación de este personaje, dependiendo
     * de la acción que se encuentre realizando.
     * @param g objeto donde será dibujado.
     */
    public void dibújate(Graphics g) {
        synchronized(this) {
            Point p = acción.dibuja(g, posX, posY);
            posX = (int)p.getX();
            posY = (int)p.getY();
            if (acción.terminó()) notify();
        }
    }

    /**
     * El personaje se balancea sin desplazarse.
     * Esta acción no tiene una duración definida, se
     * interrumpe inmediatamente en cuanto se le de
     * otro comando al personaje.
     */
    public void espera() {
		System.out.println("Quieto");
        acción = acciones.get(Estado.Quieto);
    }

    /**
     * El personaje corre y se desplaza a la derecha.
     * La llamada a este método regresa hasta que se complete
     * la acción.
     */
    public synchronized void corre() {
		System.out.println("Corriendo");
        acción = acciones.get(Estado.Corriendo);

        completaAcción();
    }

    /**
     * El personaje salta y se desplaza a la derecha.
     * La llamada a este método regresa hasta que se complete
     * la acción.
     */
    public synchronized void salta() {
		System.out.println("Saltando");
        acción = acciones.get(Estado.Saltando);

        completaAcción();
    }

    /**
     * Método auxiliar invocado por las acciones que requieren
     * bloquear el hilo hasta ser completadas.
     */
    private void completaAcción() {
        acción.reinicia();
        
        while(!acción.terminó()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
} 
