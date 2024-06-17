/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 *
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no esta permitido transferirlo resuelto a estudiantes actuales o
 * potenciales.
 */
package icc.primitivos;

/**
 * Imprime la representación binaria de los números.
 *
 * @author blackzafiro
 */
public class ImpresoraBinario {

	/**
	 * Rellena los ceros faltantes a la izquierda.
	 */
	private String completa(String cad, int longitud) {
		if (cad.length() < longitud) {
			String ceros = new String(new char[longitud - cad.length()]).replace('\0', '0');
			cad = ceros + cad;
		}
		return cad;
	}

	/**
	 * Imprime los bits de un número entero
	 *
	 * @param num el número
	 */
	public void imprime(int num) {
		System.out.println(completa(Integer.toBinaryString(num), 32));
	}

	/**
	 * Imprime los bits de un número entero
	 *
	 * @param num el número
	 */
	public void imprime(long num) {
		System.out.println(completa(Long.toBinaryString(num), 64));
	}

	/**
	 * Imprime los bits de un número doble
	 *
	 * @param num el número
	 */
	public void imprime(float num) {
		String snum = Integer.toBinaryString(Float.floatToRawIntBits(num));
		snum = completa(snum, 32);
		System.out.println(snum);
	}

	/**
	 * Imprime los bits de un número doble
	 *
	 * @param num el número
	 */
	public void imprime(double num) {
		String snum = Long.toBinaryString(Double.doubleToRawLongBits(num));
		snum = completa(snum, 64);
		System.out.println(snum);
	}
}
