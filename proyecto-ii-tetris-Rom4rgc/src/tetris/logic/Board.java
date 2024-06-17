package tetris.logic;

import java.util.Arrays;

/**
 * Tablero de tetris.
 */
public class Board {
    public static final int WIDTH = 10;
    public static final int HEIGTH = 20;
    private int[][] matrix;

    /**
     * Constructor.
     */
    public Board() {
        this.matrix = new int[Board.HEIGTH][Board.WIDTH];
    }

    /**
     * Devuelve el valor en las coordenadas indicadas.
     * El sistema de coordenadas va de izquierda a derecha y de arriba
     * a abajo.
     */
    public int get(int x, int y) {
        return this.matrix[y][x];
    }

    /**
     * Asigna el valor.
     */
    public void set(int x, int y, int value) {
        this.matrix[y][x] = value;
    }

    public int computeFilledRows() {
        return this.deleteFilledRows(0);
    }

    /*
     * Elimina todos los renglones que están llenos en el
     * tablero y regresa cuántos de ellos se eliminaron.
     */
    private int deleteFilledRows(int numRowsDeleted) {
        // Esta funcion debe ser recursiva
        // Inicializa el índice de la fila más baja del tablero

         int nrow =  Board.HEIGTH - 1; 
        // Encuentra la primera fila llena
        int numRows = Board.HEIGTH - 1;
        while(numRows >= 0 && !isRowFilled(numRows)) {
            numRows--;
        }
        // Si se encontró una fila llena y la elimina
        if (numRows>= 0) {
            numRowsDeleted++;
            // Desplaza las filas hacia abajo y llena el espacio vacío
            for(int i = numRows; i > 0; i--){
                for (int j = 0; j < Board.WIDTH; j++){
                    matrix[i][j] = matrix[i - 1][j];
                }
            }

        
        for (int j = 0; j < Board.WIDTH; j ++){
            matrix[0][j] = 0;
            }
        // Llama recursivamente a la función para eliminar mas filas
        return deleteFilledRows(numRowsDeleted);
        }
        return numRowsDeleted;
    }

    /*
     * Verifica si el último renglón está completamente lleno.
     * Un renglón esta lleno si todos sus valores son distintos de 0.
     * @return <code>true</code> si el último renglón del tablero está lleno.
     *         <code>false</code> en otro caso.
     */
    private boolean isRowFilled(int numRen) {
        // Verifica si cada valor en la fila es distinto de cero
           for(int i = 0; i < 10 ; i++){
                if (get(i, numRen) == 0)
           
            // Si se encuentra un valor cero, la fila no está llena
                   return false;
        }
           // Si no se encontró ningún valor cero, la fila está llena
    return true;
    }
}
