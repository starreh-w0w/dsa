package data_structures.Heaps;

public abstract class Heaps {
    
    private int[] heap;
    private int capacity;
    private int size;

    public Heaps(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    protected int[] getHeap() {
        return heap;
    }

    protected int getParent(int i) {
        return (i - 1) / 2;
    }

    protected int getLeft(int i) {
        return 2 * i + 1;
    }

    protected int getRight(int i) {
        return 2 * i + 2;
    }

    protected boolean isFull() {
        return size == capacity;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    protected void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    protected void incrementSize() {
        size++;
    }
    protected void decrementSize() {
        size--;
    }
    protected void setSize(int size) {
        this.size = size;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap empty");
        }
        return heap[0];
    }

    public abstract void insert(int value);
    public abstract int extract();
    public abstract void display();
}
