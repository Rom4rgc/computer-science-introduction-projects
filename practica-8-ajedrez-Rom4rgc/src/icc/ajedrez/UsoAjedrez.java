package icc.ajedrez;

import java.util.List;

public class UsoAjedrez {

    public static void main(String[] args) {

        // Posición inicial de las piezas
        Posición pInicial = new Posición(4, 'e');

        // Crear objetos Reina, Caballo y Rey
        Reina reina = new Reina(pInicial);
        Caballo caballo = new Caballo(pInicial);
        Rey rey = new Rey(pInicial);

        // Posición actual
        System.out.println("La posición actual es: " + pInicial);

        // Movimientos que son posibles para la Reina
        System.out.println("Movimientos que son posibles para la Reina:");
        List<Posición> movimientosReina = reina.posiblesMovimientos();
        for (Posición p : movimientosReina) {
            System.out.println(p);
        }

        // Movimientos que son posibles para el Caballo
        System.out.println("Movimientos que son posibles para el Caballo:");
        List<Posición> movimientosCaballo = caballo.posiblesMovimientos();
        for (Posición p : movimientosCaballo) {
            System.out.println(p);
        }

        // Movimientos que son posibles para el Rey
        System.out.println("Movimientos que son posibles para el Rey:");
        List<Posición> movimientosRey = rey.posiblesMovimientos();
        for (Posición p : movimientosRey) {
            System.out.println(p);
        }
    }
}
