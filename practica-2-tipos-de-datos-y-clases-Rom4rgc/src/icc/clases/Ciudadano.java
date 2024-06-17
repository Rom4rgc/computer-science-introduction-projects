package icc.clases;

public class Ciudadano {
   
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fecha;


    public Ciudadano(String nombre, String apellido1, String apellido2, String fecha) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha = fecha;
    }

  
    public String calculaRFC() {

        char primeraLetraApellido1 = apellido1.charAt(0);


        char primeraVocal = encontrarPrimeraVocal(nombre);

 
        char inicialApellido2 = apellido2.charAt(0);

     
        String[] partesFecha = fecha.split("/");
        String año = partesFecha[2];
        String mes = partesFecha[1];
        String dia = partesFecha[0];

        // Formar el RFC
        String rfc = String.valueOf(primeraLetraApellido1) + primeraVocal + inicialApellido2 + año.substring(2) + mes + dia;

        return rfc.toUpperCase(); 
    }
 // Método toString para representación de cadena
    public String toString() {
        return "Nombre: " + nombre + "\nCumpleaños: " + fecha + "\nRFC: " + calculaRFC();
    }

    private char encontrarPrimeraVocal(String cadena) {
        for (char letra : cadena.toLowerCase().toCharArray()) {
            if ("aeiouáéíóú".indexOf(letra) != -1) {
                return letra;
            }
        }
        return 'X'; 
    }
}
