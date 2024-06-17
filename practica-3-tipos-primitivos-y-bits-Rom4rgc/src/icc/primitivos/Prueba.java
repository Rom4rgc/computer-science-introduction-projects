package icc.primitivos;
 public class Prueba {

   public static void main(String[] args) {
    int max = Integer.MAX_VALUE;
    int uno = 1;
    double nan = Double.NaN;
    double minf = Double.NEGATIVE_INFINITY;
    double pinf = Double.POSITIVE_INFINITY;
    double cero = 0.0;
    double mcero = -0.0;
    float cerofloat= 0.0f;
    float mcerofloat = -0.0f;
    short permisos = 0754;
    short permisosEscritura = 0200; 
        permisos = (short) (permisos | permisosEscritura);
  
    int resultadoSuma = max + uno;
        
        System.out.println("Resultado en base 10: " + resultadoSuma);
        
        String binario = Integer.toBinaryString(resultadoSuma);
        System.out.println("Representación en binario: " + binario);

    ImpresoraBinario p = new ImpresoraBinario() ;
    p.imprime (uno) ;


        System.out.println("Representación binaria de NaN para double:");
        imprimirBinario(nan);

        System.out.println("\nRepresentación binaria de NEGATIVE_INFINITY:");
        imprimirBinario(minf);

        System.out.println("\nRepresentación binaria de POSITIVE_INFINITY:");
        imprimirBinario(pinf);
         
        System.out.println("Representación Cero binario double"); 
        imprimirBinario(cero);
        
        System.out.println("Representación Cero binario negativo double");
        imprimirBinario(mcero);

        System.out.println("Representación Cero binario float"); 
        imprimirBinario(cerofloat);
        
        System.out.println("Representación Cero binario negativo float");
        imprimirBinario(mcerofloat);
        
        System.out.println("Valor de permisos en base 10: " + permisos);
  
        System.out.println("Valores originales de permisos en decimal y binario:");
        
        System.out.println("Decimal: " + permisos);
       
        System.out.println("Binario: " + Integer.toBinaryString(permisos));
         
        permisos = (short) (permisos << 3);

        
        System.out.println("Valores resultantes de permisos después de 3  corrimientos en decimal y binario:");
        
        System.out.println("Decimal: " + permisos);
        
        System.out.println("Binario: " + Integer.toBinaryString(permisos));

        System.out.println("Valor modificado de permisos en binario: " + Integer.toBinaryString(permisos));
    }

    public static void imprimirBinario(double valor) {
        long bits = Double.doubleToLongBits(valor);
        System.out.println(valor + " - " + Long.toBinaryString(bits));
   
    }

    public static void imprimirBinario(float valor) {
        int bits = Float.floatToIntBits(valor);
        System.out.println(valor + " - " + Integer.toBinaryString(bits));
 }
}
