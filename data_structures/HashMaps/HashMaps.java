package data_structures.HashMaps;


import data_structures.HashMaps.Node.Node;

public class HashMaps<K, V> {
    
    private Node<K, V>[] buckets;
    private int capacity = 16;
    private int size = 0;
    private final float LOAD_FACTOR = 0.75f;

    public HashMaps() {
        buckets = new Node[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void resize() {
        capacity = capacity * 2;
        Node<K, V>[] newBuckets = new Node[capacity];

        for (Node<K, V> head : buckets) {
            while (head != null) {
                Node<K, V> next = head.next;
                int newIndex = Math.abs(head.key.hashCode()) % capacity;
                head.next = newBuckets[newIndex];
                newBuckets[newIndex] = head;
                head = next;
            }
        }
        buckets = newBuckets;
    }

    public void put(K key, V value) {
        if ((float) size / capacity >= LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node<K, V> node = new Node<>(key, value);
        node.next = buckets[index];
        buckets[index] = node;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) prev.next = head.next;
                else buckets[index] = head.next;
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets[i];
            if (head != null) {

                while (head != null) {
                    System.out.print(head.key + ":" + head.value);
                    head = head.next;
                }
            }
        }
    }
}
