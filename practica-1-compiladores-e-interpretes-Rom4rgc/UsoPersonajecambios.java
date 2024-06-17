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

		if (args.length == 0) {
			/* Para usar colores en una consola de Linux se usan
			 * códigos como '\033[35m' ('\003' ó '\e' son códigos para 'escape').
			 * Si quieres jugar con ellos consulta las opciones en:
			 * https://misc.flogisoft.com/bash/tip_colors_and_formatting */
			System.out.println("\033[31mFavor de indicar  qué personaje utilizar.\033[0m");
			String[] idPersonajes = {"Cyborg", "Biker", "Punk"};
			System.out.println("Los personajes que puedes usar son");
			for(int i = 0; i < idPersonajes.length; i++) {
				System.out.format("\t%s%n", idPersonajes[i]);
			}
			return;
		}

		// Crea un objeto de tipo Mundo
		Mundo mundo = new Mundo();

		// Crea un personaje con forma de Cyborg.
		Personaje personaje = new Personaje(args[0]);

		// Agrega el personaje a la ventana.
		mundo.muestraPersonaje(personaje);

		// Instrucciones para que las ejecute el personaje.
		personaje.corre();
		personaje.salta();
		personaje.corre();
		personaje.espera();
	}
}
