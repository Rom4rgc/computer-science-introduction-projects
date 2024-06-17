package icc.contactos;

import icc.util.IComparable;
import icc.util.ListaSL;
import icc.util.Nodo;

/**
 * Clase que almacena y permite buscar datos de contactos en objetos de tipo Registro.
 */
public class Contactos implements IContactos {
   
    private ListaSL listaContactos;

    /**
     * Crea una nueva instancia de Contactos e inicializa la lista de contactos.
     */
    public Contactos() {
        listaContactos = new ListaSL();
    }

    /**
     * Inserta un nuevo contacto en la lista de contactos.
   
     */
    public void insertaContacto(Registro reg) {
        IComparable regComparable = reg; // Casting de Registro a IComparable
        listaContactos.inserta(regComparable);
    }

    /**
     * Imprime la lista de contactos.
     */
    public void imprimeContactos() {
        System.out.println(listaContactos.toString());
    }


    public Registro consultar(String nombre) {
        Nodo actual = listaContactos.getCabeza();
        while (actual != null) {
            Registro reg = (Registro) actual.getDatos(); 
            if (reg.getNombre().contains(nombre)) {
                return reg;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
}
