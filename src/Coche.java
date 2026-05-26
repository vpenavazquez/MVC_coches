/**
 * Clase que representa un coche con sus datos básicos.
 * @author Victor
 */
public class Coche {

    /** Matrícula del coche. */
    public String matricula;

    /** Modelo o marca del coche. */
    public String modelo;

    /** Velocidad actual en km/h. */
    public Integer velocidad;

    /** Kilómetros totales recorridos. */
    public int km;

    /** Gasolina actual en litros. */
    public int gasolina;

    /**
     * Crea un coche nuevo sin kilómetros, sin velocidad y sin gasolina.
     * @param modelo Nombre o marca del coche.
     * @param matricula Matrícula única del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.km = 0;
        this.gasolina = 0;
    }
}