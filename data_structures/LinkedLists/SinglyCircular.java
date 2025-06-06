package data_structures.LinkedLists;

import data_structures.LinkedLists.Node.SinglyNode;


public class SinglyCircular extends SinglyLL {

    @Override
    public void insert(int data) {
        SinglyNode node = new SinglyNode(data);
        if (head == null) {
            head = node;
            head.next = head;
        } else {
            SinglyNode curr = head;
            while (curr.next != head) curr = curr.next;
            curr.next = node;
            node.next = head;
        }
        ptr++;
    }

    @Override
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data && head.next == head) {
            head = null;
            ptr--;
            return;
        }

        SinglyNode curr = head;
        SinglyNode prev = null;
        do {
            if (curr.data == data) {
                if (prev == null) {
                    SinglyNode last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                ptr--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    @Override
    public void display() {
        if (head == null) return;

        SinglyNode curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
    }
}
