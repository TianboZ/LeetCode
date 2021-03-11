package practice;

import java.util.HashMap;
import java.util.Map;

// leetcode solution is better than laicode, use dummy head and tail
// https://leetcode.com/problems/lru-cache/solution/
public class LRUCache {
    // fields
    Node head;
    Node tail;

    private static class Node {
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private Map<Integer, Node> map;

    private int size;

    // constructor
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new Node(1,1); // dummy
        tail = new Node(1,1); // dummy
        head.next = tail;
        tail.prev = head;
    }

    // APIs
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node); // remove node from double linked list
            append(node); // append node to the head of DDL
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node); // remove node from double linked list
            append(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == size) {
                remove(tail.prev);
                append(node);
            } else {
                append(node);
            }
        }
    }
    // 2020
    // helper methods
    private void remove(Node node) {
        map.remove(node.key);

        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    // append to head, head node is the most recently one
    private void append(Node node) {
        map.put(node.key, node);

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 2018
//    private void remove(Node node) {
//        map.remove(node.key);
//        if (node.prev != null && node.next != null) {
//            // node is in the middle
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            node.next = null;
//            node.prev = null;
//        } else if (node.prev == null && node.next != null) {
//            // node is head
//            node.next.prev = null;
//            head = node.next;
//            node.next = null;
//        } else if (node.prev != null && node.next == null) {
//            // node is tail
//            tail = node.prev;
//            tail.next = null;
//            node.prev = null;
//        } else {
//            // node is only one in the double linked list
//            head = null;
//            tail = null;
//        }
//    }
//    private void appendToHead(Node node) {
//        map.put(node.key, node);
//        if (head == null) {
//            head = node;
//            tail = node;
//        } else {
//            node.next = head;
//            head.prev = node;
//            head = node;
//        }
//    }
}