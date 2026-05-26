import java.util.Scanner;
import java.util.List;

/**
 * Clase que gestiona la pantalla y lo que el usuario escribe en consola.
 * @author Victor
 */
public class View {

    /**
     * Muestra el menú de opciones por consola y procesa la opción elegida.
     */
    public void menu() {
        Controller c = new Controller();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== GESTIÓN DE PARKING ===");
            System.out.println("1. Agregar Coche");
            System.out.println("2. Quitar Coche");
            System.out.println("3. Avanzar Coche");
            System.out.println("4. Añadir velocidad");
            System.out.println("5. Mostrar velocidad del coche");
            System.out.println("6. Coches en el parking");
            System.out.println("7. Meter Gasolina");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Agregar Coche ---");
                    System.out.print("Introduce el modelo: ");
                    String modelo = teclado.nextLine();
                    System.out.print("Introduce la matricula: ");
                    String matricula = teclado.nextLine();
                    boolean Agregar = c.AgregarCoche(modelo, matricula);
                    if (Agregar) {
                        System.out.println("¡Coche aparcado con éxito!");
                    } else {
                        System.out.println("¡FALLO FATAL!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Quitar Coche ---");
                    System.out.print("Introduce la matrícula del coche para quitar: ");
                    String matricula2 = teclado.nextLine();
                    Coche cocheQuitado = c.atenderQuitarCoche(matricula2);
                    if (cocheQuitado != null) {
                        System.out.println("Éxito: El coche con matrícula " + matricula2 + " ha sido retirado.");
                    } else {
                        System.out.println("Error: No se encontró ningún coche con la matrícula " + matricula2 + " en el parking.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Avanzar Coche ---");
                    System.out.print("Introduce la matrícula: ");
                    String matricula3 = teclado.nextLine();
                    Coche avanza = c.atenderAvanzarCoche(matricula3);
                    if (avanza != null) {
                        System.out.println("¡Avanzado! Kilómetros actuales de: " + avanza.km + " | Gasolina restante: " + avanza.gasolina + " L");
                    } else {
                        System.out.println("Error: El coche con matrícula " + matricula3 + " no está en el parking o no tiene suficiente gasolina.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Cambiar Velocidad ---");
                    System.out.print("Introduce la matrícula: ");
                    String matricula4 = teclado.nextLine();
                    System.out.print("Introduce la nueva velocidad: ");

                    try {
                        Integer v = Integer.parseInt(teclado.nextLine());
                        int velocidadNueva = c.atenderCambiarVelocidad(matricula4, v);
                        System.out.println("Velocidad actualizada con éxito a: " + velocidadNueva + " km/h.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Introduce un número válido para la velocidad.");
                    } catch (NullPointerException e) {
                        System.out.println("Error: No se encontró ningún coche con la matrícula " + matricula4);
                    }
                    break;

                case 5:
                    System.out.println("\n--- Mostrar velocidad del coche ---");
                    System.out.print("Introduce la matrícula del coche: ");
                    String matricula5 = teclado.nextLine();
                    try {
                        int velocidad = c.atenderMostrarVelocidad(matricula5);
                        System.out.println("Velocidad actual del coche: " + velocidad + " km/h.");
                    } catch (NullPointerException e) {
                        System.out.println("Error: No se encontró ningún coche con la matrícula " + matricula5);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Coches en el parking ---");
                    List<Coche> lista = c.atenderMostrarLista();
                    if (lista.isEmpty()) {
                        System.out.println("El parking está vacío.");
                    } else {
                        for (Coche ch : lista) {
                            System.out.println("Modelo: " + ch.modelo + " | Matrícula: " + ch.matricula + " | Velocidad: " + ch.velocidad + " km/h | Recorrido: " + ch.km + " km | Gasolina: " + ch.gasolina + " L");
                        }
                        System.out.println("----------------------------");
                    }
                    break;

                case 7:
                    System.out.println("\n--- Meter Gasolina ---");
                    System.out.print("Introduce la matrícula: ");
                    String matriculaGasolina = teclado.nextLine();
                    System.out.print("Introduce los litros a repostar: ");
                    try {
                        int litros = Integer.parseInt(teclado.nextLine());
                        Coche cocheGasolina = c.atenderRepostar(matriculaGasolina, litros);
                        if (cocheGasolina != null) {
                            System.out.println("¡Éxito! El coche ahora tiene " + cocheGasolina.gasolina + " litros de gasolina.");
                        } else {
                            System.out.println("Error: No se encontró ningún coche con la matrícula " + matriculaGasolina);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Introduce una cantidad válida de litros.");
                    }
                    break;

                case 8:
                    System.out.println("\nSaliendo del programa... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 8.");
                    break;
            }

        } while (opcion != 8);

        teclado.close();
    }
}