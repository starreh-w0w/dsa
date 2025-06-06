package data_structures.Stacks;

public class Stacks {

    private int[] stack;
    private int top;
    private int size;

    public Stacks(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == size - 1;
    }
    
}