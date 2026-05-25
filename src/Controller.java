import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        // Instanciamos el Scanner, la Vista y el Modelo
        Scanner teclado = new Scanner(System.in);
        View miView = new View();
        Model miModel = new Model();

        int opcion;

        do {
            // 1. La Vista muestra el menú y nos devuelve la opción que elige el usuario
            opcion = miView.mostrarMenu(teclado);

            // 2. El Controlador procesa la opción interactuando con el Modelo y la Vista
            switch (opcion) {
                case 1:
                    // Solicitamos los datos a través de la vista
                    String[] datos = miView.pedirDatosNuevoCoche(teclado);

                    // Registramos el coche en el Modelo
                    miModel.crearCoche(datos[0], datos[1]);

                    miView.mostrarMensaje("¡Coche guardado con éxito en el parking!");
                    break;

                case 2:
                    // Solicitamos la matrícula a buscar a través de la vista
                    String matriculaBuscar = miView.pedirMatricula(teclado);

                    // Comprobamos primero en el Modelo si el coche existe para evitar errores
                    Coche cocheEncontrado = miModel.getCoche(matriculaBuscar);

                    if (cocheEncontrado != null) {
                        // Si existe, le pedimos la velocidad al modelo y la mandamos a pintar a la vista
                        int velocidad = miModel.getVelocidad(matriculaBuscar);
                        miView.muestraVelocidad(matriculaBuscar, velocidad);
                    } else {
                        miView.mostrarMensaje("Error: No existe ningún coche con esa matrícula en el parking.");
                    }
                    break;

                case 3:
                    miView.mostrarMensaje("Cerrando la aplicación del Parking. ¡Hasta pronto!");
                    break;

                default:
                    miView.mostrarMensaje("Opción no válida. Por favor, introduce 1, 2 o 3.");
                    break;
            }

        } while (opcion != 3); // El bucle se repite hasta que elijan la opción 3 de salir

        // Cerramos el flujo del teclado al terminar el programa
        teclado.close();
    }
}