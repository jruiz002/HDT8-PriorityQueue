import java.util.NoSuchElementException;

public class BinaryHeap<E extends Comparable<E>> implements OwnPriorityQueue<E> {
    private Node<E> root;
    private int size;

    public BinaryHeap() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
        size++;
    }
    
    private void insert(Node<E> node, Node<E> newNode) {
        if (getPriority(newNode.getData()) < getPriority(node.getData())) {
            // Nuevo elemento tiene mayor prioridad, insertar a la izquierda
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                newNode.setParent(node);
            } else {
                insert(node.getLeft(), newNode);
            }
        } else {
            // Nuevo elemento tiene menor o igual prioridad, insertar a la derecha
            if (node.getRight() == null) {
                node.setRight(newNode);
                newNode.setParent(node);
            } else {
                insert(node.getRight(), newNode);
            }
        }
    }
    
    // Método auxiliar para obtener la prioridad de un paciente
    private int getPriority(E patient) {
        String priority = ((Paciente) patient).getPrioridad();
        switch (priority) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            case "E":
                return 5;
            default:
                return 6; // Si la prioridad no es A, B, C, D o E, se considera la prioridad más baja
        }
    }
    
    private void bubbleUp(Node<E> node) {
        Node<E> current = node;
        while (current.getParent() != null && current.getData().compareTo(current.getParent().getData()) < 0) {
            swapData(current, current.getParent());
            current = current.getParent();
        }
    }

    private void swapData(Node<E> node1, Node<E> node2) {
        E temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    @Override
    public E deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("El BinaryHeap está vacío");
        }
        E min = root.getData();
        Node<E> lastNode = getLastNode();
        if (lastNode == root) {
            root = null; // Si solo hay un nodo, eliminarlo y establecer root como null
        } else {
            root.setData(lastNode.getData()); // Reemplazar el dato de la raíz con el dato del último nodo
            removeLastNode(lastNode); // Eliminar el último nodo
            trickleDown(root); // Reajustar el BinaryHeap después de eliminar el mínimo
        }
        size--;
        return min;
    }
    

    private Node<E> getLastNode() {
        if (root == null) {
            return null;
        }
        int nodeCount = size;
        String path = Integer.toBinaryString(nodeCount / 2);
        Node<E> result = root;
        for (int i = 1; i < path.length(); i++) {
            char direction = path.charAt(i);
            if (direction == '0') {
                result = result.getLeft();
            } else {
                result = result.getRight();
            }
        }
        return result;
    }

    private void removeLastNode(Node<E> lastNode) {
        Node<E> parent = lastNode.getParent();
        if (parent == null) {
            return;
        }
        if (parent.getLeft() == lastNode) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    private void trickleDown(Node<E> node) {
        Node<E> current = node;
        while (current != null) {
            Node<E> minChild = findMinChild(current);
            if (minChild != null && minChild.getData().compareTo(current.getData()) < 0) {
                swapData(current, minChild);
                current = minChild;
            } else {
                break;
            }
        }
    }

    private Node<E> findMinChild(Node<E> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        if (node.getRight() == null) {
            return node.getLeft();
        }
        return node.getLeft().getData().compareTo(node.getRight().getData()) < 0 ? node.getLeft() : node.getRight();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("El BinaryHeap está vacío");
        }
        return root.getData();
    }

    private int subtreeSize(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + subtreeSize(node.getLeft()) + subtreeSize(node.getRight());
    }
}