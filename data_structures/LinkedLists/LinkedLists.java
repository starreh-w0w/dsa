package data_structures.LinkedLists;

public abstract class LinkedLists {
    protected int ptr = 0;

    public int getPtr() {
        return ptr;
    }

    public abstract void insert(int data);
    public abstract void delete(int data);
    public abstract void display();
}