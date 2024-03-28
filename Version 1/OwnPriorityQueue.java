// Interfaz para la cola de prioridad
public interface OwnPriorityQueue<E extends Comparable<E>> {
    void insert(E element); // Insertar un elemento en la cola de prioridad
    E deleteMin(); // Eliminar y devolver el elemento mínimo de la cola de prioridad
    int size();
    E peek();
    boolean isEmpty();

}