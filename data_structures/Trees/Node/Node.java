package data_structures.Trees.Node;


public abstract class Node<T> {
    T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
