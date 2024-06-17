/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import java.io.IOException;

/**
 * Ventana principal de la aplicación, muestra un mundo 2D.
 * Recursos descargados de:
 * https://craftpix.net/freebies/free-industrial-zone-tileset-pixel-art/
 */
public class Mundo extends Thread {

    private VistaMundo vMundo;

    /**
     * Constructor e inicio del hilo que mostrará al mundo mundo.
     */
    public Mundo() {
        this.start();
        esperaVentana();
    }

    /**
     * El hilo de la interfaz gráfica crea la ventana que muestra al mundo.
     */
    public void run() {
        try {
            vMundo = new VistaMundo();
        } catch(IOException ioe) {
            System.err.println("No fue posible cargar las imágenes.");
        }
    }

    /**
     * Usado por el hilo principal para asegurarse de que la ventana ya fue
     * creada antes de asignarle un personaje.
     */
    private synchronized void esperaVentana() {
        while(vMundo == null) {
            try {
                wait();
            } catch(InterruptedException e) {}
        }
    }

    /**
     * Asigna el personaje a la venta y comienza a dibujarlo.
     * @param personaje
     */
    synchronized void muestraPersonaje(Personaje personaje) {
        vMundo.muestraPersonaje(personaje);
    }
    
}
