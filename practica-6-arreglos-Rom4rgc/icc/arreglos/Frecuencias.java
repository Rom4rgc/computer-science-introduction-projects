import java.util.Random;

public class Frecuencias {

    public static void main(String[] args) {
        // Crear un objeto que genera números aleatorios
        Random generador = new Random();

        // Inicializar un arreglo para almacenar la frecuencia de cada cara
        int[] frecuencias = new int[50];

        // Simular 10,000 lanzamientos
        for(int i = 0; i < 10000; i++) {
            int dado = generador.nextInt(50) + 1; // Genera enteros en [1, 50]
            frecuencias[dado - 1] += 1; // Incrementa la frecuencia del número obtenido
        }

        // Imprimir la frecuencia de cada cara
        System.out.println("Cara\tSalida");
        int suma = 0;
        for(int i = 0; i < frecuencias.length; i++) {
            System.out.println((i + 1) + "\t" + frecuencias[i]);
            suma += frecuencias[i]; // Calcular la suma de las frecuencias
        }

        // Verificar que la suma de las frecuencias sea 10,000
        System.out.println("La suma de las frecuencias es = " + suma);
        if(suma == 10000) {
            System.out.println("El conteo fue correcto.");
        } else {
            System.out.println("El conteo fue incorrecto.");
        }
    }
}


