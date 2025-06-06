package data_structures.Queues;

public class LinearQueues extends Queues{

    public LinearQueues(int size) {
        super(size);
    }

    @Override
    public void enqueue(int value) {
        if (rear == size - 1) {
            throw new IllegalStateException("Queue Overflow");
        }
        if (isEmpty()) front = 0;
        queue[++rear] = value;
    }

    @Override
    public int dequeue() {
        if (isEmpty() || front > rear) {
            throw new IllegalStateException("Queue Underflow");
        }
        int val = queue[front++];
        if (front > rear) front = rear = -1;
        return val;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}
