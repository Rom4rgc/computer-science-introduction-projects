package icc.ajedrez;

public class PruebaPosición {

    public static void main (String[] args) {
        // Prueba de los valores válidos
        Posición prueba1 = new Posición(4,'d');
        Posición prueba2 = new Posición(1, 'g');
        Posición prueba3 = new Posición(2, 'h');
        // Prueba de los valores inválidos
        Posición prueba4 = new Posición(8, 'k');
        Posición prueba5 = new Posición(-1, 'z');
        Posición prueba6 = new Posición(24, 'n');
    }

}