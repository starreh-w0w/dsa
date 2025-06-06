package data_structures.Queues;

public abstract class Queues {
    
    protected int[] queue;
    protected int size;
    protected int front;
    protected int rear;

    public Queues(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public abstract void enqueue(int value);
    public abstract int dequeue();
    public abstract void display();

    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
