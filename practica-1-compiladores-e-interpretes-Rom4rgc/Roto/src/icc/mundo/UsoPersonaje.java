/**
 * Se permite acceder a este código para uso personal, con fines didácticos.
 * No está permitido realizar trabajos derivados directamente de él o
 * publicar soluciones a los problemas aquí planteados, para
 * no afectar a otros estudiantes que lo utilicen en sus cursos.
 */

package icc.mundo;

import java.io.IOException;

/**
 * Clase que muestra cómo pedir a un personaje que realice acciones en
 * un mundo sencillo.
 */
public class UsoPersonaje {

	/**
	 * Punto de entrada al programa.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		// Crea un objeto de tipo Mundo
		Mundo mundo = new Mundo();

		// Crea un personaje con forma de Cyborg.
		Personaje personaje = new Personaje("Cyborg");

		// Agrega el personaje a la ventana.
		mundo.muestraPersonaje(personaje);

		// Instrucciones para que las ejecute el personaje.
		personaje.corre();
		personaje.salta()
		personaje.corre();
		personaje.espera);
	}
}
