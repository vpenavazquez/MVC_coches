import java.util.List;

/**
 * Controlador que conecta lo que ve el usuario (View) con los datos (Model).
 * @author Victor
 */
public class Controller {

    /** Conexión con la pantalla del menú. */
    static View miView = new View();

    /** Conexión con los datos del parking. */
    Model database = new Model();

    /**
     * Arranca la aplicación mostrando el menú principal.
     */
    public static void main(String[] args) {
        miView.menu();
    }

    /**
     * Pide al modelo crear un coche y comprueba que se guardó bien.
     * @return true si se guardó correctamente, false si falló.
     */
    public boolean AgregarCoche(String modelo, String matricula){
        Coche creado = database.crearCoche(modelo, matricula);
        if (creado == database.getCoche(matricula)) {
            return true;
        }
        return false;
    }

    /**
     * Pide al modelo quitar un coche usando su matrícula.
     * @return El coche retirado, o null si no existía.
     */
    public Coche atenderQuitarCoche(String matricula) {
        return database.quitarCoche(matricula);
    }

    /**
     * Pide al modelo que un coche avance.
     * @return El coche con sus nuevos kilómetros, o null si falló.
     */
    public Coche atenderAvanzarCoche(String matricula) {
        return database.hacerAvanzarCoche(matricula);
    }

    /**
     * Cambia la velocidad de un coche en el modelo.
     * @return La nueva velocidad asignada.
     */
    public int atenderCambiarVelocidad(String matricula, Integer nuevaVelocidad) {
        return database.cambiarVelocidad(matricula, nuevaVelocidad);
    }

    /**
     * Consigue la velocidad de un coche desde el modelo.
     * @return Velocidad actual del coche.
     */
    public int atenderMostrarVelocidad(String matricula) {
        return database.getVelocidad(matricula);
    }

    /**
     * Trae la lista completa de todos los coches apuntados.
     * @return Lista con los vehículos.
     */
    public List<Coche> atenderMostrarLista() {
        return database.getListaParking();
    }

    /**
     * Pide al modelo repostar gasolina en un coche.
     * @return El coche modificado, o null si no se encontró.
     */
    public Coche atenderRepostar(String matricula, int litros) {
        return database.repostarGasolina(matricula, litros);
    }
}