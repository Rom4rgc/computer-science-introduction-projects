package icc.util;

/**
 * Clase que representa una lista enlazada simple que almacena datos de tipo IComparable de manera ordenada.
 */
public class ListaSL {
    
    private Nodo cabeza; // Nodo inicial de la lista

   
    public void inserta(IComparable n) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDatos(n);

        // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            Nodo anterior = null;

            // Busca la posición correcta para insertar el nuevo nodo
            while (actual != null && n.comparaCon(actual.getDatos()) > 0) {
                anterior = actual;
                actual = actual.getSiguiente();
            }

            // Si el nuevo nodo debe ser insertado al principio
            if (anterior == null) {
                nuevoNodo.setSiguiente(cabeza);
                cabeza = nuevoNodo;
            } else {
                // Si el nuevo nodo debe ser insertado en medio o al final
                nuevoNodo.setSiguiente(actual);
                anterior.setSiguiente(nuevoNodo);
            }
        }
    }

    /**
     * Obtiene la cabeza de la lista.
     * @return El nodo inicial de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos: ");
        sb.append("\n");
        Nodo actual = cabeza;

        while (actual != null) {
            sb.append(actual.getDatos().toString());
            sb.append("\n");
            actual = actual.getSiguiente();
        }

        return sb.toString();
    }
}
