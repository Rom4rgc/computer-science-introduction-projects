/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.InputStream;

/**
 * Serie de imágenes que representan los cuadros de una animación
 * del personaje.
 */
public class Sprite {    
	private final int salto;
	private final Point desplazamiento;
	private final Image imagen;
	private final int numCuadros;
	private int cuadro;
	private boolean cíclico;

	/**
	 * Constructor
	 * @param nombreArchivo archivo con las imágenes de la animación.
	 * @param salto ancho en pixeles de cada imagen.
	 * @param desplazamiento movimento en la coordenada x donde se debe
	 *        dibujar al personaje después de utilizar la imagen actual.
	 * @param numCuadros número de cuadros de los que consta la animación.
	 * @param cíclico si al terminar la animación se debe volver a empezar.
	 * @throws IOException si no se logra acceder al archivo de imagen.
	 */
	public Sprite(String nombreArchivo, int salto, Point desplazamiento, int numCuadros, boolean cíclico) throws IOException {
		this.salto = salto;
		this.desplazamiento = desplazamiento;
		InputStream in = getClass().getResourceAsStream(nombreArchivo);
		this.imagen = javax.imageio.ImageIO.read(in);
		this.cíclico  = cíclico;
		this.numCuadros = numCuadros;
		cuadro = 0;
	}
	
	/**
	 * Crea un sprite cuya animación no se repite.
	 * @param nombreArchivo archivo con las imágenes de la animación.
	 * @param salto ancho en pixeles de cada imagen.
	 * @param desplazamiento movimento en la coordenada x donde se debe
	 *        dibujar al personaje después de utilizar la imagen actual.
	 * @param numCuadros número de cuadros de los que consta la animación.
	 * @throws IOException si no se logra acceder al archivo de imagen.
	 */ 
	public Sprite(String nombreArchivo, int salto, Point desplazamiento, int numCuadros) throws IOException {
		this(nombreArchivo, salto, desplazamiento, numCuadros, false);
	}

	/**
	 * Asigna si la animación se repite en ciclos.
	 * @param cíclico
	 */
	public void cíclico(boolean cíclico) {
		this.cíclico = cíclico;
	}

	/**
	 * Regresa la animación a su primer cuadro.
	 */
	public void reinicia() {
		cuadro = 0;
	}

	/**
	 * Indica si ya no hay más cuadros qué dibujar.
	 * @return si ya no hay más cuadros qué dibujar.
	 */
	public boolean terminó() {
		if (cíclico) return false;
		else return cuadro == numCuadros;
	}

	/**
	 * Dibuja el cuadro actual de la animación en las coordenadas indicadas.
	 * @param g objeto donde dibuajar la imagen.
	 * @param posX coordenada X.
	 * @param posY coordenada Y, 0 es la parte superior de la imagen.
	 * @return par de coordenadas donde se debería dibujar el cuadro siguiente.
	 */
	public Point dibújate(Graphics g, int posX, int posY) {
		g.drawImage(imagen, posX, posY, posX + salto, posY + salto,
		cuadro * salto, 0, (cuadro + 1) * salto, salto, null);
		if (cíclico) {
			cuadro = (cuadro + 1) % numCuadros;
		} else {
			if (cuadro < numCuadros) cuadro++;
		}
		return new Point(posX + (int)desplazamiento.getX(),
		                 posY + (int)desplazamiento.getY());
	}

} 
