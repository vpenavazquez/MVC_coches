import java.util.ArrayList;
import java.util.List;

/**
 * Clase que guarda la lista de coches y gestiona sus datos.
 * @author Victor
 */
public class Model {

    /** Lista donde se guardan todos los coches del parking. */
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Registra un coche nuevo en el parking.
     * @param modelo Marca del coche.
     * @param matricula Matrícula del coche.
     * @return El coche que se acaba de crear.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche en el parking por su matrícula.
     * @param matricula Matrícula a buscar.
     * @return El coche encontrado, o null si no existe.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Saca un coche del parking usando su matrícula.
     * @param matricula Matrícula del coche a quitar.
     * @return El coche eliminado, o null si no se encontró.
     */
    public Coche quitarCoche(String matricula) {
        Coche cocheEncontrado = getCoche(matricula);
        if (cocheEncontrado != null) {
            parking.remove(cocheEncontrado);
            return cocheEncontrado;
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche.
     * @param matricula Matrícula del coche.
     * @param v Nueva velocidad.
     * @return La velocidad que se ha guardado.
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Hace que un coche sume 1 km si tiene gasolina (gasta 1 litro).
     * @param matricula Matrícula del coche.
     * @return El coche modificado, o null si no se pudo mover.
     */
    public Coche hacerAvanzarCoche(String matricula) {
        Coche aux = getCoche(matricula);
        if (aux != null && aux.gasolina > 0) {
            aux.km++;
            aux.gasolina--;
            return aux;
        }
        return null;
    }

    /**
     * Devuelve la velocidad actual de un coche.
     * @param matricula Matrícula del coche.
     * @return Velocidad en km/h.
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la lista con todos los coches apuntados.
     * @return Lista de coches en el parking.
     */
    public List<Coche> getListaParking() {
        return parking;
    }

    /**
     * Añade litros de gasolina al depósito de un coche.
     * @param matricula Matrícula del coche.
     * @param litros Litros de combustible a meter.
     * @return El coche con la gasolina actualizada, o null si no existe.
     */
    public Coche repostarGasolina(String matricula, int litros) {
        Coche aux = getCoche(matricula);
        if (aux != null && litros > 0) {
            aux.gasolina += litros;
        }
        return aux;
    }
}