package data_structures.Heaps;

public class MaxHeaps extends Heaps{

    public MaxHeaps(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap full");
        }

        int[] heap = getHeap();
        int i = getSize();
        heap[i] = value;
        incrementSize();

        while (i != 0 && heap[getParent(i)] < heap[i]) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }

    @Override
    public int extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap empty");
        }

        int[] heap = getHeap();
        int root = heap[0];
        heap[0] = heap[getSize() - 1];
        decrementSize();

        heapify(0);
        return root;
    }

    private void heapify(int i) {
        int[] heap = getHeap();
        int largest = i;
        int left = getLeft(i);
        int right = getRight(i);

        if (left < getSize() && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < getSize() && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    @Override
    public void display() {
        if (getSize() == 0) {
            throw new IllegalStateException("Heap empty");
        }

        for (int i = 0; i < getSize(); i++) {
            System.out.print(getHeap()[i] + " ");
        }
    }
}
