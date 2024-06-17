package icc.ajedrez;

import java.util.LinkedList;
import java.util.List;

public class Rey extends Pieza {

    public Rey(Posición posición) {
        super(posición);
    }

    @Override
    public List<Posición> posiblesMovimientos() {
        List<Posición> movimientos = new LinkedList<>();
        int renglonDef = getPosición().getRenglón();
        char columnaDef = getPosición().getColumna();

        int[] movimientosRenglon = { -1, 0, 1 };
        int[] movimientosColumna = { -1, 0, 1 };

        for (int i : movimientosRenglon) {
            for (int j : movimientosColumna) {
                if (i != 0 || j != 0) {
                    int nuevoRenglon = renglonDef + i;
                    char nuevaColumna = (char) (columnaDef + j);
                    if (nuevoRenglon >= 1 && nuevoRenglon <= 8 && nuevaColumna >= 'a' && nuevaColumna <= 'h') {
                        movimientos.add(new Posición(nuevoRenglon, nuevaColumna));
                    }
                }
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
