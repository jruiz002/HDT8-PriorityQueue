import java.util.PriorityQueue;

/**
 * @author José Ruiz
 * @version 1.0
 * Fecha creación: 27/03/2024
 * 
 */

/**
 * Clase principal que contiene el método main para ejecutar el programa de
 * control citas en un hospital usando PriorityQueue de JCF
 */

public class Main {
    public static void main(String[] args) {
        // Crear una PriorityQueue de Pacientes
        PriorityQueue<Paciente> colaDeEspera = new PriorityQueue<>();
        // Insertar pacientes en la cola de espera
        ColaPrioridad.insertarPaciente(colaDeEspera);
        // Eliminar y mostrar pacientes atendidos en orden de prioridad
        ColaPrioridad.eliminarPaciente(colaDeEspera);
    }
}