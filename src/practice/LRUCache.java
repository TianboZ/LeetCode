package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // fields
    class Node {
        Node next;
        Node prev;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;

    Map<Integer, Node> map;

    int capacity;

    // constructor
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    // API
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            remove(node);
            append(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
            append(node);
        } else if (map.size() < capacity) {
            Node newNode = new Node(key, value);
            append(newNode);
        } else {
            remove(tail);
            Node newNode = new Node(key, value);
            append(newNode);
        }
    }

    // remove entry from the map
    private void remove(Node node) {
        map.remove(node.key);
//        if (node.prev != null) {
//            node.prev.next = node.next;
//        }
//        if (node.next != null) {
//            node.next.prev = node.prev;
//        }
//        if (node == head) {
//            head = head.next;
//        }
//        if (node == tail) {
//            tail = tail.prev;
//        }
//        node.next = node.prev = null;

        // more clear
        if (node.prev != null && node.next != null) {
            // node in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        } else if (node.prev != null && node.next == null) {
            // node is tail
            node.prev.next = null;
            node.prev = null;
        } else if (node.prev == null && node.next != null) {
            // node is head
            node.next.prev = null;
            node.next = null;
        } else {
            // only one node in the double linked list
            head = null;
            tail = null;
        }
    }

    // append the node to the head
    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        System.out.println("head: " + lruCache.head.value + " tail : " + lruCache.tail.value);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println("head: " + lruCache.head.value + " tail : " + lruCache.tail.value);


        lruCache.put(4, 4);
        System.out.println("head: " + lruCache.head.value + " tail : " + lruCache.tail.value);

    }
}
