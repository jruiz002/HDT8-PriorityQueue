import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class ColaPrioridad {
    /**
    * Lee un archivo de texto con información de pacientes y los inserta en una cola de espera.
    *
    * @param colaDeEspera La cola de espera donde se insertarán los pacientes.
    */
    public static void insertarPaciente(PriorityQueue<Paciente> colaDeEspera){
                // Leer el archivo TXT y procesar cada línea
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String sintoma = partes[1];
                    String prioridad = partes[2];
                    // Crear objeto Paciente y agregarlo a la PriorityQueue
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                    colaDeEspera.offer(paciente); // Agregar paciente a la cola
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina y muestra los pacientes de la cola de espera según su prioridad.
     *
     * @param colaDeEspera La cola de espera de pacientes.
     */
    public static void eliminarPaciente(PriorityQueue<Paciente> colaDeEspera){
        // Procesar la cola de espera
        System.out.println("Orden de atención de pacientes:");
        while (!colaDeEspera.isEmpty()) {
            Paciente paciente = colaDeEspera.poll(); // Obtener y remover el paciente con mayor prioridad
            System.out.println("- " + paciente);
        }
    }
}