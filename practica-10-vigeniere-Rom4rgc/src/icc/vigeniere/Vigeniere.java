package icc.vigeniere;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

/**
 * Clase que implementa el algoritmo de Vigeniere.
 */
public class Vigeniere {

    private String path; //Ruta del archivo
    private String secret; //Palabra clave
    /**
     * Constructor.
     * @param path Ruta del archivo donde se encuentra
     *        el texto a descifrar.
     * @param secret La palabra clave para descifrar el
     *        código.
     */
    public Vigeniere(String path, String secret) {
        this.path = path; //Parametro para la ruta del archivo
        this.secret = secret;//Parametro para palabra clave
    }

    
    /**
     * Lee el contenido de un archivo especificado por la ruta
     * 
     * @return El contenido del archivo
     */
    private String readFile() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = in.readLine()) != null) {
                text.append(line);
            }
            return text.toString().toLowerCase();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo");
            return "";
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
            return "";
        }
    }


    /**
     * Escribe el contenido cifrado en un nuevo archivo
     */
    private void writeFile(String text) {
        String extension = " ";
        int index = this.path.lastIndexOf('.');

        if (index > 0) {
            extension = this.path.substring(index + 1);
            System.out.println(extension);
        }

        try {
            String newExtension;
            if (extension.equals("encoded")) {
                newExtension = "decoded";
            } else {
                newExtension = "encoded";
            }

            String newFilePath = this.path.substring(0, index + 1) + newExtension;
            File file = new File(newFilePath);

            try (PrintStream fout = new PrintStream(file)) {
                fout.println(text);
            }

            System.out.println("Archivo creado exitosamente: " + newFilePath);
        } catch (FileNotFoundException | SecurityException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    /**
     * Genera la clave a partir del texto y la clave proporcionados.
     * @param text El texto a cifrar o descifrar.
     * @param secret La palabra clave para descifrar el código.
     * @return La clave generada.
     */
    private static String generarLlave (String text, String secret){
      StringBuilder llave = new StringBuilder();
        for (int i = 0, j = 0; i < text.length();i++) {
            char actual = text.charAt(i);
            if (Character.isLetter(actual)){
                llave.append (Character.toLowerCase(secret.charAt(j % secret.length()))); 
                j++;
            } else {
                llave.append(actual);
            }
        }
            return llave.toString ();
    } 

     /**
     * Genera la tabla de Vigenere.
     * @return La tabla de Vigenere.
     */
    private char [] [] generarTabla (){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[][] table = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++){
                table [i][j] = abc.charAt ((i + j) % 26);
            }
        }
        return table;
    }

    /**
     * Obtiene la columna correspondiente de la tabla de Vigenere.
     * @param fila La letra de la fila.
     * @param letra La letra actual del texto.
     * @param table La tabla de Vigenere.
     * @return La letra original obtenida de la tabla de Vigenere.
     */
    private char obtenerColumna (char fila, char letra, char [] [] table){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int indiceFila = abc.indexOf (fila);
        for (int i = 0; i < 26; i++){
            if (table [i] [indiceFila] == letra){
                return abc.charAt(i);
            }
        }
        return ' ';
    }

   /**
     * Cifra el contenido del archivo 
     */
    public void encode() {
        String text = this.readFile();
        StringBuilder encodedText = new StringBuilder();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String llave = generarLlave(text, this.secret);
        char[][] table = generarTabla();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (!Character.isLetter(currentChar)) {
                encodedText.append(currentChar);
                continue;
            }
            char encodedChar = table[abc.indexOf(Character.toLowerCase(currentChar))][abc.indexOf(llave.charAt(i))];
            encodedText.append(Character.toUpperCase(encodedChar));
        }
        this.writeFile(encodedText.toString());
    }

    /**
     * Descifra el contenido del archivo 
     */
    public void decode() {
        String text = this.readFile();
        StringBuilder decodedText = new StringBuilder();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String llave = generarLlave(text, this.secret);
        char[][] table = generarTabla();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (!Character.isLetter(currentChar)) {
                decodedText.append(currentChar);
                continue;
            }
            char decodedChar = obtenerColumna(llave.charAt(i), currentChar, table);
            decodedText.append(Character.toUpperCase(decodedChar));
        }
        this.writeFile(decodedText.toString());
    }
}