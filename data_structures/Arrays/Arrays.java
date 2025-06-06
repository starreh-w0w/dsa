package data_structures.Arrays;

public class Arrays {

    private int size;
    private int[] arr;
    private int ptr;

    public Arrays (int size) {
        this.size = size;
        this.arr = new int[size];
        this.ptr = 0;
    }

    public void insert (int value) {
        if (isFull()) {
            throw new IllegalStateException("Array full");
        }
        arr[ptr] = value;
        ptr++;
    }

    public void insertAt (int idx, int value) {
        if (isFull()) {
            throw new IllegalStateException("Array full");
        }
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = ptr; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = value;
        size++;
    }

    public void delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Array empty");
        }
        ptr--;
    }

    public void deleteAt(int idx) {
        if (isEmpty()) {
            throw new IllegalStateException("Array empty");
        }
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = idx; i < ptr - 1; i++) {
            arr[i] = arr[i + 1];
        }
        ptr--;
    }

    public void deleteElement(int value) {
        int index = search(value);
        if (index == -1) {
            throw new IllegalArgumentException("Element not found");
        }
        deleteAt(index);
    }

    public int search(int value) {
        for (int i = 0; i < ptr; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int searchAt(int idx) {
        if (idx < 0 || idx >= ptr) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[idx];
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("Array empty");
        }
        for (int i = 0; i < ptr; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private boolean isFull() {
        return ptr == size;
    }
    private boolean isEmpty() {
        return ptr == 0;
    }
}