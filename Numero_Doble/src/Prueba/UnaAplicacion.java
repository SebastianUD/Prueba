package Prueba;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class UnaAplicacion {

    public static void main(String[] args) {
        Salida objSalida = new Salida();
        Entrada objEntrada = new Entrada();
        String ubicacion = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Prueba.txt";

        OUTER:
        while (true) {
            String[] opciones = {"Escribir", "Leer", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Opciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:
                    // Opción "Escribir"
                    // Capturar el mensaje del usuario mediante un cuadro de diálogo
                    String mensaje = JOptionPane.showInputDialog(null, "Ingrese un mensaje:");
                    try {
                        // Guardar el mensaje en un archivo .txt
                        guardarEnArchivo(ubicacion, mensaje);
                        JOptionPane.showMessageDialog(null, "Mensaje guardado exitosamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage());
                    }   break;
                case 1:
                    // Opción "Leer"
                    try {
                        // Leer el contenido del archivo .txt y mostrarlo en un cuadro de diálogo
                        String contenidoArchivo = leerArchivo(ubicacion);
                        JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + contenidoArchivo);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
                    }   break;
                case 2:
                    // Opción "Salir"
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break OUTER; // Salir del ciclo
                default:
                    break;
            }
        }
    }

    // Método para guardar contenido en un archivo
    public static void guardarEnArchivo(String nombreArchivo, String contenido) throws IOException {
        FileWriter fileWriter = new FileWriter(nombreArchivo);
        fileWriter.write(contenido);
        fileWriter.close();
    }

    // Método para leer contenido de un archivo
    public static String leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(nombreArchivo));
        StringBuilder contenido = new StringBuilder();
        String linea;

        while ((linea = bufferedReader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }

        bufferedReader.close();
        return contenido.toString();
    }
}