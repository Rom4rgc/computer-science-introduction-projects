/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 *
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no esta permitido transferirlo resuelto a estudiantes actuales o
 * potenciales.
 */
package icc.primitivos;

public class PruebasPrimitivos {
    public static void main(String[] args) {
        System.out.println("Ejercicios");

        ImpresoraBinario impresora = new ImpresoraBinario(); 

        int entero = -456;
        long largo = -456L;
        float flotante = -456.0f; 
        double doble = -456.0;

        impresora.imprime(entero);  
        impresora.imprime(largo);  
        impresora.imprime(flotante);  
        impresora.imprime(doble);   

        int mascara = 0b1111; 
        mascara = mascara << 4; 

        impresora.imprime(mascara);  

       
        int num = 1408;
        int resultadoAnd = num & mascara;
        int resultadoOr = num | mascara;
        int resultadoXor = num ^ mascara;
        int complementoUno = ~num;

        impresora.imprime(resultadoAnd);
        System.out.println("Resultado num & máscara: " + resultadoAnd);

        impresora.imprime(resultadoOr);
        System.out.println("Resultado num | máscara: " + resultadoOr);

        impresora.imprime(resultadoXor);
        System.out.println("Resultado num ˆ máscara: " + resultadoXor);

        impresora.imprime(complementoUno);
        System.out.println("Complemento a uno de num: " + complementoUno);
    }
}
