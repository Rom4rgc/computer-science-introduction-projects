package icc.ordenamientos;
import java.util.Random;
import java.util.Arrays;

/**
 * Clase principal de la práctica de ordenamientos.
 */
public class UsoOrdenamientosII {

	/**
	* Método para crear arreglos aleatorios de una longitud dada.
	*/
	private static int[] arregloAleatorio(int longitud) {
		Random r = new Random();
		int[] aleatorio = new int[longitud];
		for (int i = 0; i < longitud; i++) {
			int llena = r.nextInt()/10000;
			aleatorio[i] = llena;
		}
		return aleatorio;
	}
	    
	/**
	* Método principal. Ordena varios arreglos de diferentes longitudes
	 * y reporta el tiempo que tardó en realizarlo. 
	 * Para probar su programa se 
	 * recomienda mejor ant test.
	 * @param args Para acceder a los argumentos. 
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int[] longitudes = new int[]{1000,10000,50000, 100000, 200000,
		                             400000, 1000000,10000000};

		for (int l = 0; l<longitudes.length; l++) {

			int[] arregloQuick = arregloAleatorio(longitudes[l]); 
			// Corremos quickSort
			long startTime, endTime;
			startTime = System.currentTimeMillis();
			OrdenamientosII.quickSort(arregloQuick);
			endTime = System.currentTimeMillis();

			System.out.printf("QuickSort con %d elementos: %d milisegundos\n", longitudes[l], endTime-startTime);

		}
	}

}
