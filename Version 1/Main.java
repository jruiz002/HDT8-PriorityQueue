import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear un BinaryHeap de pacientes
        BinaryHeap<Paciente> pacientes = new BinaryHeap<>();

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
                    pacientes.insert(new Paciente(nombre, sintoma, prioridad));
                } else {
                    System.err.println("Error: La línea no tiene el formato esperado: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        while (!pacientes.isEmpty()) {
            Paciente paciente = pacientes.deleteMin();
            System.out.println("- " + paciente.getNombre() + " con prioridad: " + paciente.getPrioridad());
        }
    }
}