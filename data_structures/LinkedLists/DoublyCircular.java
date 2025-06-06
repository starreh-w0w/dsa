package data_structures.LinkedLists;

import data_structures.LinkedLists.Node.DoublyNode;


public class DoublyCircular extends DoublyLL {

    @Override
    public void insert(int data) {
        DoublyNode node = new DoublyNode(data);
        if (head == null) {
            head = node;
            head.next = head;
            head.prev = head;
        } else {
            DoublyNode last = head.prev;
            node.next = head;
            node.prev = last;
            head.prev = node;
            last.next = node;
        }
        ptr++;
    }

    @Override
    public void delete(int data) {
        if (head == null) return;

        DoublyNode curr = head;
        do {
            if (curr.data == data) {
                if (curr.next == curr) {
                    head = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    if (curr == head) head = curr.next;
                }
                ptr--;
                return;
            }
            curr = curr.next;
        } while (curr != head);
    }

    @Override
    public void display() {
        if (head == null) return;

        DoublyNode curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
    }
}
