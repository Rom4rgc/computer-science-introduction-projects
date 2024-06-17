/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él, para
 * no afectar a otros estudiantes que lo utilicen para sus cursos.
 */
package icc.mundo;

import java.io.IOException;
import java.awt.Point;

/**
 * El personaje se impulsa hacia arriba y vuelve a caer, habiéndose
 * desplazado horizontalmente.
 */
class AcciónSaltando extends Acción {

	/**
	 * Constructor.
     * @param nombre identificador de los recursos para el tipo
     *               de personaje.
     * @throws IOException si no logra abrir el archivo con las imágenes
     *         correspondientes a esta acción.
	 */
	AcciónSaltando(String nombre) throws IOException {
		super(Estado.Saltando, nombre, new Point(Personaje.LADO / 4, 0), 4);
	}
    
}
 
