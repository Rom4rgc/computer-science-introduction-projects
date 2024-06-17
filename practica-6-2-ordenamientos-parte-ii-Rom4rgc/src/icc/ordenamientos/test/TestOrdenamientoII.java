package icc.ordenamientos.test;

import java.util.Random;
import icc.ordenamientos.OrdenamientosII;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class TestOrdenamientoII {

	
	@Rule public Timeout expiracion = Timeout.seconds(5);

	
	private Random random;

	/* Función que nos regresa si un arreglo está ordenado */
	private static boolean ordenado(int[] arreglo) {
		boolean ordenado = true;
		for (int i = 0; i < arreglo.length-1; i++)
			if (arreglo[i] > arreglo[i+1]){
				ordenado = false;
				break;
			}    
		return ordenado;
	}

	
	private int[] arregloAleatorio(int total) {
		int[] arr = new int[total];
		for (int i = 0; i<total; i++) {
			arr[i] = random.nextInt();
		}
		return arr;
	}

	
	private int[] arregloOrdenado(int total) {
		int[] arr = new int[total];
		for (int i = 0; i<total; i++) {
			arr[i] = i;
		}
		return arr;
	}

	
	private int[] arregloOrdenadoExcluye(int total, int excluído) {
		int[] arr = new int[total];
		int j = 0;
		for (int i = 0; i<total; i++) {
			if (j==excluído)
				j++;
			arr[i] = j++;
		}
		return arr;
	}

	
	public TestOrdenamientoII() {
		random = new Random();
	}

	@Test public void testQuickSort() {
		int total = 100 + random.nextInt(900);
		int[] arreglo = arregloAleatorio(total);
		arreglo[0] = 42;
		arreglo[1] = 41;
		Assert.assertFalse(ordenado(arreglo));
		OrdenamientosII.quickSort(arreglo);
		Assert.assertTrue(ordenado(arreglo));
	}

	@Test public void testBusquedaBinariaElemento() {
		
		int total = 100 + random.nextInt(400);
		int[] arreglo = arregloOrdenado(total);
		int busca = random.nextInt(total);
		for (int i = 0; i<total; i++){
			int índice = OrdenamientosII.busquedaBinaria(arreglo, arreglo[busca]);
		
			Assert.assertTrue(índice==busca);
		}
	}

	@Test public void testBúsquedaBinariaNoElemento(){
		
		int total = 100 + random.nextInt(400);
		int excluye = random.nextInt(total);
		int[] arreglo = arregloOrdenadoExcluye(total, excluye);
		int índice = OrdenamientosII.busquedaBinaria(arreglo, excluye);
		Assert.assertTrue(índice==-1);
		índice = OrdenamientosII.busquedaBinaria(arreglo, -100);
		Assert.assertTrue(índice==-1);
		índice = OrdenamientosII.busquedaBinaria(arreglo, total+100);
		Assert.assertTrue(índice==-1);
	}
     
}
