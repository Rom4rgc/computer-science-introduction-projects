package icc.ajedrez;

public class Posición {

    private int renglón;
    private char columna;

    public Posición(int renglón, char columna) {
        this.renglón = renglónV(renglón);
        this.columna = columnaV(columna);
    }

    public int getRenglón() {
        return renglón;
    }

    public int renglónV(int renglón) {
        if (renglón < 1 || renglón > 8) {
            throw new IllegalArgumentException("El valor del renglón debe estar entre 1 y 8.");
        }
        return renglón;
    }

    public char getColumna() {
        return columna;
    }

    public char columnaV(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("El valor de la columna debe estar entre a y h.");
        }
        return columna;
    }

    @Override
    public String toString() {
        return String.valueOf(columna) + renglón;
    }
}
