package icc.util;

/**
 * Interfaz que representa objetos comparables entre sí.
 */
public interface IComparable {

	/**
	 * Compara este objeto (<code>this</code>) con <code>o</code> de
	 * acuerdo a una relación de orden.
	 * @returns Un número menor que cero si este objeto es menor que
	 * <code>o</code>, cero si son iguales o un valor positivo si es mayor.
	 * @throws IllegalArgumentExcepcion Si los objetos no son de la
	 * misma clase.
	 */
	public int comparaCon(Object o);
}

