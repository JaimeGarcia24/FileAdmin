//Jaime Michel Garcia Sostenes
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Act_Stream {

    // Nombre del archivo donde guardaremos las notas
    private static final String ARCHIVO = "MisNotas.txt";

    public static void escribirNota(String nota) throws IOException {
        // El 'true' es muy importante para que no borre las notas anteriores
        OutputStream fos = new FileOutputStream(ARCHIVO, true);

        // Agregamos un salto de línea al final de cada nota para que no queden pegadas
        String linea = nota + "\n";

        fos.write(linea.getBytes());

        fos.flush();
        fos.close();
    }

    public static String leerNotas() throws IOException {
        InputStream fis = new FileInputStream(ARCHIVO);
        StringBuilder contenido = new StringBuilder();
        int byteLeido;

        // Leemos byte por byte hasta llegar al final del archivo (que se representa con -1)
        while ((byteLeido = fis.read()) != -1) {
            // Convertimos cada número byte a su equivalente en caracter (char)
            contenido.append((char) byteLeido);
        }

        fis.close();

        // Devolvemos todo el texto construido
        return contenido.toString();
    }
}