package Prueba;

public class UnaAplicacion {

    public static void main(String[] args) {
        // Crear instancias de las clases Salida y Entrada
        Salida objSalida = new Salida();
        Entrada objEntrada = new Entrada();

        // Mostrar mensaje para que el usuario ingrese un número
        objSalida.enviar("Ingrese un numero:");
        
        // Capturar la entrada del usuario como una cadena de texto
        String entradaStr = objEntrada.capturar();

        try {
            // Intentar convertir la entrada en un número
            int numero = Integer.parseInt(entradaStr);

            // Calcular el doble del número ingresado
            int resultado = numero * 2;

            // Mostrar el resultado al usuario
            objSalida.enviar("El doble del numero ingresado es: " + resultado);
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la conversión falla (entrada no es un número válido)
            objSalida.enviar("Error: Ingrese un numero valido.");
        }
    }
}


