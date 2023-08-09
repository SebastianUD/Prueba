package Prueba;

import java.util.Scanner;

public class Entrada {

    private Scanner scanner;

    // Constructor que inicializa el Scanner para leer la entrada del usuario
    public Entrada() {
        scanner = new Scanner(System.in);
    }

    // Método para capturar la entrada del usuario y devolverla como una cadena de texto
    public String capturar() {
        return scanner.nextLine();
    }

    // Método para cerrar el Scanner al finalizar
    public void cerrar() {
        scanner.close();
    }
}

