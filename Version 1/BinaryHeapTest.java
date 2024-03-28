import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryHeapTest {
    
    /**
     * Prueba unitaria para verificar la inserción y extracción de elementos en la cola de prioridad BinaryHeap.
     */
    @Test
    public void testInsertAndExtractMin() {
        // Crear un BinaryHeap
        BinaryHeap<String, Paciente> heap = new BinaryHeap<>();

        // Insertar elementos
        heap.insert("D", new Paciente("Jose", "Gripe", "D"));
        heap.insert("C", new Paciente("Alejandro", "dolor de cabeza severo", "C"));
        heap.insert("B", new Paciente("Fredy", "dolor abdominal agudo", "B"));
        heap.insert("A", new Paciente("Julio", "apendicitis", "A"));

        // Extraer el mínimo
        Node<String, Paciente> minNode = heap.extractMin();

        // Verificar que el mínimo sea el esperado
        assertEquals("A", minNode.getKey());
        assertEquals("Julio", minNode.getValue().getNombre());
        assertEquals("apendicitis", minNode.getValue().getSintoma());
        assertEquals("A", minNode.getValue().getPrioridad());

        // Extraer más elementos y verificar
        minNode = heap.extractMin();
        assertEquals("B", minNode.getKey());
        assertEquals("Fredy", minNode.getValue().getNombre());
        assertEquals("dolor abdominal agudo", minNode.getValue().getSintoma());
        assertEquals("B", minNode.getValue().getPrioridad());

        minNode = heap.extractMin();
        assertEquals("C", minNode.getKey());
        assertEquals("Alejandro", minNode.getValue().getNombre());
        assertEquals("dolor de cabeza severo", minNode.getValue().getSintoma());
        assertEquals("C", minNode.getValue().getPrioridad());

        minNode = heap.extractMin();
        assertEquals("D", minNode.getKey());
        assertEquals("Jose", minNode.getValue().getNombre());
        assertEquals("Gripe", minNode.getValue().getSintoma());
        assertEquals("D", minNode.getValue().getPrioridad());
    }

    /**
     * Prueba unitaria para verificar el método isEmpty() de la clase BinaryHeap.
     */
    @Test
    public void testIsEmpty() {
        // Crear un BinaryHeap
        BinaryHeap<String, Paciente> heap = new BinaryHeap<>();

        // Verificar si está vacío al principio
        assertTrue(heap.isEmpty());

        // Insertar un elemento y verificar que no está vacío
        heap.insert("C", new Paciente("Alejandro", "dolor de cabeza severo", "C"));
        assertFalse(heap.isEmpty());

        // Extraer el elemento y verificar que está vacío nuevamente
        heap.extractMin();
        assertTrue(heap.isEmpty());
    }
}
