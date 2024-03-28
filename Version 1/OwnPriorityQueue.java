// Interfaz para la cola de prioridad
public interface OwnPriorityQueue<K extends Comparable<K>, V> {
    /**
     * Inserta un nuevo nodo con la clave y valor especificados en el árbol.
     * @param key La clave del nuevo nodo.
     * @param value El valor del nuevo nodo.
     */
    void insert(K key, V value);

    /**
     * Extrae el nodo con la clave mínima del árbol y lo elimina del árbol.
     * @return El nodo con la clave mínima.
     */
    Node<K, V> extractMin();

    /**
     * Verifica si el árbol está vacío.
     * @return true si el árbol está vacío, false de lo contrario.
     */
    boolean isEmpty();

}