package practice;

import java.util.Map;

public class Generics {
    static class Node<K, V, Z> {
        // fields
        Node<K, V, Z> next;
        Node<K, V, Z> prev;

        K key;
        V value;
        Z name;

        // constructor
        public Node(K key, V value, Z name) {
            this.key = key;
            this.value = value;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Node<Integer, String, Integer> node1 = new Node<>(1, "abc", 2);
        Node<Integer, String, Integer> node2 = new Node<>(3, "xyz", 4);
        node1.next = node2;
        node2.prev = node1;

    }
}
