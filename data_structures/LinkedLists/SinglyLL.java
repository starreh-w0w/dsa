package data_structures.LinkedLists;

import data_structures.LinkedLists.Node.SinglyNode;

public class SinglyLL extends LinkedLists {

    protected SinglyNode head;

    @Override
    public void insert(int data) {
        SinglyNode node = new SinglyNode(data);
        if (head == null) {
            head = node;
        } else {
            SinglyNode curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
        ptr++;
    }

    @Override
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            ptr--;
            return;
        }

        SinglyNode curr = head;
        while (curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
            ptr--;
        }
    }

    @Override
    public void display() {
        SinglyNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
