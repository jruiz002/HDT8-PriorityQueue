/**
 * Clase que representa un nodo en un árbol binario.
 *
 * @param <K> Prioridad
 * @param <V> Valor del nodo en este caso el paciente
 */
public class Node<K, V> {
    private K key;             // Clave del nodo
    private V value;           // Valor almacenado en el nodo
    private Node<K, V> left;   // Referencia al hijo izquierdo del nodo
    private Node<K, V> right;  // Referencia al hijo derecho del nodo

    /**
     * Constructor para crear un nuevo nodo con la clave y valor especificados.
     *
     * @param key   Prioridad
     * @param value Valor del nodo en este caso el paciente
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
    /**
     * Obtiene la clave almacenada en el nodo.
     *
     * @return La clave del nodo.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return El valor almacenado en el nodo.
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece la clave del nodo.
     *
     * @param key La clave a establecer.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Establece el valor del nodo.
     *
     * @param value El valor a establecer.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Obtiene la referencia al hijo izquierdo del nodo.
     *
     * @return La referencia al hijo izquierdo del nodo.
     */
    public Node<K, V> getLeft() {
        return left;
    }

    /**
     * Establece la referencia al hijo izquierdo del nodo.
     *
     * @param left La referencia al hijo izquierdo a establecer.
     */
    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    /**
     * Obtiene la referencia al hijo derecho del nodo.
     *
     * @return La referencia al hijo derecho del nodo.
     */
    public Node<K, V> getRight() {
        return right;
    }

    /**
     * Establece la referencia al hijo derecho del nodo.
     *
     * @param right La referencia al hijo derecho a establecer.
     */
    public void setRight(Node<K, V> right) {
        this.right = right;
    }
}
