package data_structures.Trees;

public abstract class Tree<T> {
    protected int ptr = 0;

    public int getPtr() {
        return ptr;
    }

    public abstract void insert(T data);
    public abstract void display();
}