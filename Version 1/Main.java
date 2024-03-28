import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author José Ruiz
 * @version 1.0
 * Fecha creación: 27/03/2024
 * 
 */

/**
 * Clase principal que contiene el método main para ejecutar el programa de
 * control citas en un hospital usando un binaryHeap.
 */

public class Main {
    public static void main(String[] args) {
        // Crear un BinaryHeap de pacientes
        BinaryHeap<String, Paciente> pacientes = new BinaryHeap<>();

        // Leer el archivo pacientes.txt
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en nombre, síntoma y prioridad
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    String sintoma = parts[1];
                    String prioridad = parts[2];

                    // Crear un objeto Paciente y agregarlo al BinaryHeap
                    pacientes.insert(prioridad, new Paciente(nombre, sintoma, prioridad));
                } else {
                    System.err.println("Error: La línea no tiene el formato esperado: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        // Extraer y mostrar pacientes del binary heap
        System.out.println();
        System.out.println("Pacientes atendidos por orden de prioridad:");
        while (!pacientes.isEmpty()) {
            Node<String, Paciente> node = pacientes.extractMin();
            Paciente paciente = node.getValue();
            System.out.println("Nombre: " + paciente.getNombre() + ", Síntoma: " + paciente.getSintoma() + ", Prioridad: " + paciente.getPrioridad());
        }
        System.out.println();
    }
}