package icc.ajedrez;

import java.util.LinkedList;
import java.util.List;

public class Caballo extends Pieza {

    public Caballo(Posición posición) {
        super(posición);
    }

    @Override
    public List<Posición> posiblesMovimientos() {
        List<Posición> movimientos = new LinkedList<>();
        int renglonDef = getPosición().getRenglón();
        char columnaDef = getPosición().getColumna();

        int[][] movimientosRelativos = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
        };

        for (int[] movimiento : movimientosRelativos) {
            int nuevoRenglon = renglonDef + movimiento[0];
            char nuevaColumna = (char) (columnaDef + movimiento[1]);

            if (nuevoRenglon >= 1 && nuevoRenglon <= 8 && nuevaColumna >= 'a' && nuevaColumna <= 'h') {
                movimientos.add(new Posición(nuevoRenglon, nuevaColumna));
            }
        }

        return movimientos;
    }

    @Override
    public boolean esValida(Posición posición) {
        List<Posición> movimientosPosibles = posiblesMovimientos();
        return movimientosPosibles.contains(posición);
    }
}

