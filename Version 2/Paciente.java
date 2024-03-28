/**
 * Clase que representa un paciente en un sistema de atención médica.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;      // Nombre del paciente
    private String sintoma;     // Síntoma del paciente
    private String prioridad;   // Prioridad del paciente

    /**
     * Constructor para crear un nuevo paciente con el nombre, síntoma y prioridad especificados.
     *
     * @param nombre     El nombre del paciente.
     * @param sintoma    El síntoma del paciente.
     * @param prioridad  La prioridad del paciente.
     */
    public Paciente(String nombre, String sintoma, String prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     *
     * @return El síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene la prioridad del paciente.
     *
     * @return La prioridad del paciente.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Compara este paciente con otro paciente basado en su prioridad.
     *
     * @param otro El otro paciente con el que se compara.
     * @return Un valor negativo si este paciente tiene una prioridad menor que el otro paciente,
     *         un valor positivo si este paciente tiene una prioridad mayor que el otro paciente,
     *         o cero si ambos pacientes tienen la misma prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        // Comparar pacientes basados en su prioridad
        return this.prioridad.compareTo(otro.prioridad);
    }

    /**
     * Devuelve una representación en forma de cadena de este paciente.
     *
     * @return Una cadena que representa el nombre, síntoma y prioridad del paciente.
     */
    @Override
    public String toString() {
        return nombre + " (Síntoma: " + sintoma + ", Prioridad: " + prioridad + ")";
    }
}
