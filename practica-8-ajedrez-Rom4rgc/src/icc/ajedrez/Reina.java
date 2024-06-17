package icc.ajedrez;

import java.util.LinkedList;
import java.util.List;

public class Reina extends Pieza {

    public Reina(Posición posición) {
        super(posición);
    }

    @Override
    public List<Posición> posiblesMovimientos() {
        List<Posición> movimientos = new LinkedList<>();
        int renglonDef = getPosición().getRenglón();
        char columnaDef = getPosición().getColumna();

        // Movimientos horizontales
        for (char c = 'a'; c <= 'h'; c++) {
            if (c != columnaDef) {
                movimientos.add(new Posición(renglonDef, c));
            }
        }

        // Movimientos verticales
        for (int i = 1; i <= 8; i++) {
            if (i != renglonDef) {
                movimientos.add(new Posición(i, columnaDef));
            }
        }

        // Movimientos diagonales
        for (int i = 1; i <= 8; i++) {
            for (char c = 'a'; c <= 'h'; c++) {
                if (Math.abs(renglonDef - i) == Math.abs(columnaDef - c) && i != renglonDef) {
                    movimientos.add(new Posición(i, c));
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
