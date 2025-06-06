package data_structures.Queues;

public class CircularQueues extends Queues{

    public CircularQueues(int size) {
        super(size);
    }

    @Override
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow");
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = value;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        int val = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }

        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
    }
}
