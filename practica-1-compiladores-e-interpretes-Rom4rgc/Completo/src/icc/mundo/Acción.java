/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import java.io.IOException;
import icc.mundo.Sprite;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Contiene la informaición y métodos necesarios para animar
 * un acción del personaje.
 */
public class Acción {

	/**
	 * Objeto identificador de la acción.
	 */
	protected Estado estado;

	/**
	 * Manejador para los recursos para la animación correspondiente
	 * a esta acción.
	 */
	protected Sprite sprite;

	/**
	 * Constructor.
	 * @param estado objeto identificador de la acción.
	 * @param nombre nombre identificador del personaje que realiza la acción, debe
	 *        corresponder con un nombre disponible entre los recursos de la aplicación.
	 * @param desplazamiento desplazamientos x,y que deben aplicarse después de ejecutar
	 *        un cuadro de esta acción.
	 * @param numCuadros número de cuadros que tiene la animación.
	 * @throws IOException si no logra abrir el archivo con las imágenes
     *         correspondientes a esta acción.
	 */
	public Acción(Estado estado, String nombre, Point desplazamiento, int numCuadros) throws IOException {
		this.estado = estado;
		sprite = new Sprite("/recursos/" + nombre + "/" +
		                    nombre + "_" + estado.nombreId() + ".png",
							Personaje.LADO, desplazamiento, numCuadros);
	}

	/**
	 * Dibuja el siguiente cuadro en la animación de la acción.
	 * @param g objeto donde se dibujará la imagen.
	 * @param posX coordenada x.
	 * @param posY coordenada y.
	 * @return posición que debería ocupar el personaje para el siguiente cuadro.
	 */
	public Point dibuja(Graphics g, int posX, int posY) {
		return sprite.dibújate(g, posX, posY);
	}

	/**
	 * Si la acción ya fue completada.
	 * @return si ya no hay más cuadros que mostrar.  De ser el caso, la próxima vez
	 *         que se invoque <code>dibuja()</code> no aparecerá ninguna imagen.
	 */
	public boolean terminó() {
		return sprite.terminó();
	}

	/**
	 * Reinicia el objeto acción para poder ejecutarla otra vez.
	 */
	public void reinicia() {
		sprite.reinicia();
	}
}