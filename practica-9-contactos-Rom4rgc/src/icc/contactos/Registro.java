package icc.contactos;
import icc.util.IComparable;

public class Registro implements IComparable {

    // Atributos de la clase Registro
    private String nombre;
    private String dirección;
    private String teléfono;

    /**
     * Constructor de la clase Registro.
     * @param nombre Nombre del contacto.
     * @param dirección Dirección del contacto.
     * @param teléfono Teléfono del contacto.
     */
    public Registro(String nombre, String dirección, String teléfono) {
        // Verifica y asigna valores por defecto si se reciben valores nulos
        if (nombre != null) {
            this.nombre = nombre;
        } else {
            this.nombre = "Sin Nombre";
        }

        if (dirección != null) {
            this.dirección = dirección;
        } else {
            this.dirección = "Sin Dirección";
        }

        if (teléfono != null) {
            this.teléfono = teléfono;
        } else {
            this.teléfono = "Sin Teléfono";
        }
    }

    /**
     * Obtiene el nombre del contacto.
     * @return El nombre del contacto.
     */
    public String getNombre() {
        if (this.nombre != null) {
            return this.nombre;
        } else {
            return "Sin Nombre";
        }
    }

    /**
     * Establece el nombre del contacto.
     * @param nombre El nombre a asignar al contacto.
     */
    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        } else {
            this.nombre = "Sin Nombre";
        }
    }

    /**
     * Obtiene la dirección del contacto.
     * @return La dirección del contacto.
     */
    public String getDirección() {
        if (this.dirección != null) {
            return this.dirección;
        } else {
            return "Sin Dirección";
        }
    }

    /**
     * Establece la dirección del contacto.
     * @param dirección La dirección a asignar al contacto.
     */
    public void setDirección(String dirección) {
        if (dirección != null) {
            this.dirección = dirección;
        } else {
            this.dirección = "Sin Dirección";
        }
    }

    /**
     * Obtiene el teléfono del contacto.
     * @return El teléfono del contacto.
     */
    public String getTeléfono() {
        if (this.teléfono != null) {
            return this.teléfono;
        } else {
            return "Sin Teléfono";
        }
    }

    /**
     * Establece el teléfono del contacto.
     * @param teléfono El teléfono a asignar al contacto.
     */
    public void setTeléfono(String teléfono) {
        if (teléfono != null) {
            this.teléfono = teléfono;
        } else {
            this.teléfono = "Sin Teléfono";
        }
    }

    /**
     * Devuelve una representación en cadena del registro.
     * @return Una cadena con los datos del registro.
     */
    @Override
    public String toString() {
        return "Registro: Nombre: " + this.getNombre() + ", Dirección: " + this.getDirección() + ", Teléfono: " + this.getTeléfono();
    }

    /**
     * Compara este registro con otro basándose en el nombre.
    
     * @return Un número menor que cero si este registro es menor que el objeto comparado,
     *         cero si son iguales, o un número mayor que cero si es mayor.
     */
    @Override
    public int comparaCon(Object o) {
        if (o instanceof Registro) {
            Registro otroRegistro = (Registro) o;
            return this.nombre.compareTo(otroRegistro.nombre);
        } else {
            throw new IllegalArgumentException("No se puede comparar con un objeto que no es de tipo Registro.");
        }
    }
    public static void main(String[] args) {
        Registro registro1 = new Registro("Enrique", "Calle Morelos  #139", "5567890981");
        Registro registro2 = new Registro(null, "Calle Oliva #123" , null);

        System.out.println(registro1);
        System.out.println(registro2);
    }
}
