package icc.ajedrez;
import java.util.List;
import java.util.LinkedList; 

public abstract class Pieza {
    
    private Posición posición;

    public Pieza(Posición posición) {
        setPosición(posición);
    }
    protected Pieza (Posición posición, boolean color){
        this.posición = posición;
    }
    
    // Obtener los posibles movimientos
    public abstract List<Posición> posiblesMovimientos();
    // Verificar si un movimiento es válido
    public abstract boolean esValida (Posición posición);
    //Obtener posicion con un getter
    public Posición getPosición() {
        return posición;
    }
      // Establecer la posición con setter
    public void setPosición(Posición posición) {
        this.posición = posición;
    }

    // Representar la pieza y su estado actual con toString
    public String toString() {
        return "Pieza en la posición: " + posición.toString();
    }
    
}