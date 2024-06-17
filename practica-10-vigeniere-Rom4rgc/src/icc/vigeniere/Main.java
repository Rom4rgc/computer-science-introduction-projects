package icc.vigeniere;
import java.util.Scanner;

/**
 * Interfaz para el usuario.
 */
public class Main {

    /**
     * Imprime el menú.
     */
    private static void printMenu() {
        System.out.println("¡Bienvenido al programa Vigeniere!");
        System.out.println("Selecciona una de las siguientes opciones:");
        System.out.println("1. Cifrar");
        System.out.println("2. Descifrar");
        System.out.println("3. Salir");
    }

    /**
     * Inicio.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            printMenu();
            option = sc.nextInt();
            sc.nextLine(); // Read end of line \n
            switch(option) {
                case 1:
                case 2:
                    System.out.printf("Escribe la ruta del archivo que quieres %s:\n", (option == 1) ? "CIFRAR": "DESCRIFRAR");
                    String path = sc.nextLine();

                    System.out.println("Dame la palabra SECRETA:");
                    String secret = sc.nextLine();

                    Vigeniere vg = new Vigeniere(path, secret);
                    if (option == 1) {
                        vg.encode();
                    } else {
                        vg.decode();
                    }

                    System.out.printf("El archivo fue correctamente %s.\n", (option == 1) ? "cifrado": "descifrado");
                    break;
                case 3:
                    System.out.println("Vuelva pronto!");
                    break;
                default:
                    System.out.println(">>> La opcion es INVALIDA. Intenta de nuevo. \n");
            }
        } while(option != 3);
    }
}
