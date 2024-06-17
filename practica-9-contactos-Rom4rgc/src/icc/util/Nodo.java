package icc.util;

/**
 * Clase que representa un nodo en una lista enlazada que almacena datos de tipo IComparable.
 */
public class Nodo {
    private IComparable datos; // Datos almacenados en el nodo
    private Nodo siguiente;    // Referencia al siguiente nodo en la lista

    /**
     * Obtiene los datos almacenados en el nodo.
     */
    public IComparable getDatos() {
        return datos;
    }

   
    public void setDatos(IComparable datos) {
        this.datos = datos;
    }

    
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
