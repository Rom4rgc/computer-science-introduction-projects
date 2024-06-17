package icc.funciones;

/**
 * Esta clase contiene un detector de números primos.
 */
public class DetectorDePrimos {

    /**
     * Método principal, tu código comienza a ejecutarse aquí.
     * @param args Esta variable permite acceder a cada argumento.
     *             Los argumentos son cadenas de caracteres <code>String</code>.
     */
    public static void main(String[] args) {

        System.out.println("Argumentos recibidos: ");
        for (String arg : args) {
        System.out.println(arg);
        }
        if (args.length == 0) {
            System.out.println("\033[31mNo se recibieron indicaciones.\033[0m");
            return;
        }

        int n = Integer.parseInt(args[0]);

        if (esPrimo(n)) {
            System.out.println(n + " es un número primo.");
        } else {
            System.out.println(n + " no es un número primo.");
        }
    }

    /**
     * Esta función verifica si un número es primo o no.
     * @param num El número que se va a verificar.
     * @return <code>true</code> si el número es primo, <code>false</code> en caso contrario.
     */
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
