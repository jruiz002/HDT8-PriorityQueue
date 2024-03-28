public class Node<E> {
    private E data; // Datos almacenados en el nodo
    private Node<E> left; // Referencia al hijo izquierdo
    private Node<E> right; // Referencia al hijo derecho
    private Node<E> parent; // Referencia al padre

    // Constructor
    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    // Métodos getters y setters
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }
}
