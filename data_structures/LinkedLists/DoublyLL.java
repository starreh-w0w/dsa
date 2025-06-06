package data_structures.LinkedLists;

import data_structures.LinkedLists.Node.DoublyNode;

public class DoublyLL extends LinkedLists{

    protected DoublyNode head;

    @Override
    public void insert(int data) {
        DoublyNode node = new DoublyNode(data);
        if (head == null) {
            head = node;
        } else {
            DoublyNode curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
            node.prev = curr;
        }
        ptr++;
    }

    @Override
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            if (head != null) head.prev = null;
            ptr--;
            return;
        }

        DoublyNode curr = head;
        while (curr != null && curr.data != data) curr = curr.next;

        if (curr != null) {
            if (curr.prev != null) curr.prev.next = curr.next;
            if (curr.next != null) curr.next.prev = curr.prev;
            ptr--;
        }
    }

    @Override
    public void display() {
        DoublyNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
