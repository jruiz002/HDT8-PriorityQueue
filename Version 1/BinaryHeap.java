/**
 * Implementación de una cola de prioridad utilizando un Binary Heap.
 *
 * @param <K> Tipo de dato de la clave de prioridad.
 * @param <V> Tipo de dato del valor almacenado en la cola de prioridad.
 */
public class BinaryHeap<K extends Comparable<K>, V> implements OwnPriorityQueue<K, V>{
    private Node<K, V> root; // Raíz del Binary Heap

    /**
     * Inserta un nuevo elemento con la clave y valor especificados en la cola de prioridad.
     *
     * @param key   Prioridad del elemento.
     * @param value El valor del nuevo elemento.
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    /**
     * Método privado para insertar un nuevo nodo con la clave y valor especificados en el árbol.
     *
     * @param node  El nodo actual en el que se está insertando.
     * @param key   La clave del nuevo nodo.
     * @param value El valor del nuevo nodo.
     * @return El nodo resultante después de la inserción.
     */
    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(insert(node.getLeft(), key, value));
        } else {
            node.setRight(insert(node.getRight(), key, value));
        }

        return node;
    }

    /**
     * Extrae y elimina el elemento con la mínima prioridad de la cola de prioridad.
     *
     * @return El nodo con la mínima prioridad.
     */
    public Node<K, V> extractMin() {
        if (root == null) {
            return null;
        }

        Node<K, V> minNode = findMinNode(root);
        root = deleteNode(root, minNode.getKey());
        return minNode;
    }

    /**
     * Método privado para eliminar el nodo con la clave especificada del árbol.
     *
     * @param node El nodo actual en el que se está eliminando.
     * @param key  La clave del nodo que se desea eliminar.
     * @return El nodo resultante después de la eliminación.
     */
    private Node<K, V> deleteNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(deleteNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setKey(findMinNode(node.getRight()).getKey());
            node.setRight(deleteNode(node.getRight(), node.getKey()));
        }

        return node;
    }

    /**
     * Encuentra y devuelve el nodo con la mínima prioridad en el árbol.
     *
     * @param node El nodo actual en el que se está buscando.
     * @return El nodo con la mínima prioridad.
     */
    private Node<K, V> findMinNode(Node<K, V> node) {
        Node<K, V> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * Verifica nodo raiz del arbol esta vacío,
     *
     * @return true si el nodo raiz está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return root == null;
    }

}
