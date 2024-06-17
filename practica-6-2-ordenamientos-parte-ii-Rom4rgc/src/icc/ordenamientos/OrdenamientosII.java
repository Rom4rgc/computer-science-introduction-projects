package icc.ordenamientos;

/**
 * Clase donde se encuentran los algoritmos para
 * ordenar arreglos. 
 */
public class OrdenamientosII {

	/**
	* Método auxiliar. Dado un arreglo y dos índices 
	* (se asumen no negativos y menores a la longitud del arreglo) 
	* intercambia los elementos en esos índices.
	* @param a el arreglo en el que se harán los intercambios.
	* @param i el primer índice.
	* @param j el segundo índice.
	*/
	public static void intercambia(int[] a, int i, int j) {
		// Implemente la función
	 int temp = a[i];
	 a[i] = a[j];
	 a[j] = temp;
	}

	/**
	* Ordena el arreglo recibido usando QuickSort.
	* @param arreglo el arreglo a ordenar.
	*/
	public static void quickSort(int[] arreglo) {
		// Ordenamos el arreglo completo (de 0 a length-1)
		quickSort(arreglo, 0, arreglo.length-1);
	}
     private static void quickSortRecursivo(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(arreglo, inicio, fin);
            quickSortRecursivo(arreglo, inicio, pivote - 1);
            quickSortRecursivo(arreglo, pivote + 1, fin);
        }
    }



private static int particion(int[] arreglo, int inicio, int fin) {
    int pivote = arreglo[fin]; 
    int i = inicio - 1;

    for (int j = inicio; j < fin; j++) {

        if (arreglo[j] <= pivote) {
            i++;
            intercambia(arreglo, i, j);
        }
    }

    intercambia(arreglo, i + 1, fin);
    return i + 1; 
}

	/**
	* Método auxiliar para implementar quicksort de forma recursiva, 
	* usando parámetros extra para indicar el inicio y fin del subarreglo.
	* @param arreglo el arreglo de donde se obtiene el subarreglo a ordenar.
	* @param inicio el índice de inicio del subarreglo a ordenar.
	* @param fin el índice del final del subarreglo a ordenar.
	*/
	private static void quickSort(int[] arreglo, int inicio, int fin){
		// Implemente la función

	    if (inicio < fin) {
        int pivote = particion(arreglo, inicio, fin);
        quickSort(arreglo, inicio, pivote - 1);
        quickSort(arreglo, pivote + 1, fin); 
    }
}



	/**
	* Busca un elemento en un arreglo mediante búsqueda binaria.
	* @param arreglo el arreglo donde se hará la búsqueda.
	* @param elemento el número que se buscará.
	* @return El índice de n en el arreglo o -1 si no se encuentra.
	*/
	public static int busquedaBinaria(int[] arreglo, int elemento){
	    
	    return busquedaBinariaRecursiva(arreglo, elemento, 0, arreglo.length - 1);
		// Implementa la función. 
		/* No te debe tomar más de tres líneas. Toma como ejemplo 
		   El método quickSort que ya se te entregó implementado.*/ 
	}
  	/* Crea tu función recursiva auxiliar para búsqueda Binaria. 
	Usa los parámetros que creas necesarios. Documenta tu función.*/

    private static int busquedaBinariaRecursiva(int[] arreglo, int elemento, int inicio, int fin) {
        if (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == elemento) {
                return medio;
            }
            if (arreglo[medio] < elemento) {
                return busquedaBinariaRecursiva(arreglo, elemento, medio + 1, fin);
            }   else {
                return busquedaBinariaRecursiva(arreglo, elemento, inicio, medio - 1);
            }
        }
        return -1;
    }
}
