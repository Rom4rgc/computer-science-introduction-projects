import java.util.Scanner;

public class Estadisticas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a) Pedir al usuario el número de elementos
        System.out.print("Proporciona el número de datos a proporcionar: ");
        int n = scanner.nextInt();

        // b) Llenar el arreglo con los valores proporcionados por el usuario
        double[] datos = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Dame el " + (i + 1) + " valor: ");
            datos[i] = scanner.nextDouble();
        }

        // c) Calcular la media
        double media = calcularMedia(datos);

        // d) Calcular la varianza
        double varianza = calcularVarianza(datos, media);

        // Imprimir resultados
        System.out.println("La media es: " + media);
        System.out.println("La varianza es: " + varianza);
    }

    // Función para calcular la media
    public static double calcularMedia(double[] datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma / datos.length;
    }

    // Función para calcular la varianza
    public static double calcularVarianza(double[] datos, double media) {
        double sumaCuadrados = 0;
        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }
        return sumaCuadrados / datos.length;
    }
}

