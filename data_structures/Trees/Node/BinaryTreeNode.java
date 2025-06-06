package data_structures.Trees.Node;

public class BinaryTreeNode<T> extends Node<T> {
    BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        super(data);
    }
}
