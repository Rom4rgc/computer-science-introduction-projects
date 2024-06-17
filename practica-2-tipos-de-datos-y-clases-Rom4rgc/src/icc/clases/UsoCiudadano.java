package icc.clases;

/**
 * Clase para ejemplificar el uso de la clase <code>Ciudadano</code>.
 * @author 
 */
public class UsoCiudadano {

    public static void main(String[] args) {
        Ciudadano c = new Ciudadano("Laura estrella", "Leon", "Calvo", "09/07/2000");
        String rfc = c.calculaRFC();
        System.out.println("El RFC de Laura es " + rfc);
        
        Ciudadano carmen = new Ciudadano("Carmen Elizabeth Juanita", "de Costa Brava", "Cortez", "30/03/2001");
        rfc = carmen.calculaRFC();
        System.out.println("El RFC de Carmen es: " + rfc);
        
        Ciudadano siqueiros = new Ciudadano("David", "Álfaro", "Siqueiros", "29/12/1896");
        rfc = siqueiros.calculaRFC();
        System.out.println("El RFC de David es : " + rfc);
        
        Ciudadano cantinflas = new Ciudadano("Mario Fortino Alfonso", "Moreno", "Reyes", "12/08/1911");
        rfc = cantinflas.calculaRFC();
        System.out.println("El RFC de Mario es : " + rfc);
    }
  public static void main2() {

        Ciudadano c = new Ciudadano("Laura estrella", "Leon", "Calvo", "09/07/2000");
        System.out.println(c.toString());

        Ciudadano carmen = new Ciudadano("Carmen Elizabeth Juanita", "de Costa Brava", "Cortez", "30/03/2001");
        System.out.println(carmen.toString());

        Ciudadano siqueiros = new Ciudadano("David", "Álfaro", "Siqueiros", "29/12/1896");
        System.out.println(siqueiros.toString());

        Ciudadano cantinflas = new Ciudadano("Mario Fortino Alfonso", "Moreno", "Reyes", "12/08/1911");
        System.out.println(cantinflas.toString());
   }
}






