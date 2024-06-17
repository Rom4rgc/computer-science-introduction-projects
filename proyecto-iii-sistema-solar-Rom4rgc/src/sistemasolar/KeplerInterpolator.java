/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.animation.Interpolator;



public class KeplerInterpolator extends Interpolator {

	/**
	 * Mapea el rango [0, 1] al mismo rango de modo que haya más puntos cerca de
	 * los extremos y menos en medio.
	 * @param t
	 * @return 
	 */
    protected double curve(double t) {
        return (Math.cos(Math.PI * t) + 1) / 2;
    }

     

}
