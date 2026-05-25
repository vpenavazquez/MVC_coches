import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario (Entradas y Salidas)
 */
public class View {

    /**
     * Muestra el menú por pantalla y captura la opción seleccionada
     */
    public int mostrarMenu(Scanner teclado) {
        System.out.println("\n--- GESTIÓN DE PARKING (MVC) ---");
        System.out.println("1. Crear un coche y meterlo en el parking");
        System.out.println("2. Mostrar velocidad de un coche");
        System.out.println("3. Salir del sistema");
        System.out.print("Elige una opción: ");

        int opcion = teclado.nextInt();
        teclado.nextLine(); // Limpiamos el buffer del Scanner
        return opcion;
    }

    /**
     * Pide al usuario los datos para registrar un coche nuevo
     * @return un Array de String donde [0] es el modelo y [1] es la matrícula
     */
    public String[] pedirDatosNuevoCoche(Scanner teclado) {
        System.out.print("Introduce el modelo del coche: ");
        String modelo = teclado.nextLine();
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = teclado.nextLine();
        return new String[]{modelo, matricula};
    }

    /**
     * Pide una matrícula para realizar búsquedas
     */
    public String pedirMatricula(Scanner teclado) {
        System.out.print("Introduce la matrícula del coche a consultar: ");
        return teclado.nextLine();
    }

    /**
     * Muestra un mensaje informativo general por pantalla
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra la velocidad de un coche
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("El coche con matrícula [" + matricula + "] va a: " + v + " km/hr");
        return true;
    }
}