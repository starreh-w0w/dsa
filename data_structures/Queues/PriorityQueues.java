package data_structures.Queues;

class PriorityQueues {
    private int[] queue;
    private int size;
    private int count;

    public PriorityQueues(int size) {
        this.size = size;
        this.queue = new int[size];
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow");
        }

        int i;
        for (i = count - 1; i >= 0 && queue[i] > value; i--) {
            queue[i + 1] = queue[i];
        }
        queue[i + 1] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        return queue[--count];
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }

        for (int i = 0; i < count; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}