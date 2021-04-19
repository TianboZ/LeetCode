package practice;

import java.util.HashMap;
import java.util.Map;

// leetcode solution is better than laicode, use dummy head and tail
// https://leetcode.com/problems/lru-cache/solution/
public class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int v, int k) {
            val = v;
            key = k;
        }
    }

    Map<Integer, Node> map;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // move node to head
        remove(node);
        appendHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            // new node
            if (size == map.size()) {
                Node last = tail.prev;
                remove(last);
                map.remove(last.key);
            }
            node = new Node(value, key);
            appendHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            remove(node);
            appendHead(node);
        }
    }


    private void appendHead(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = head;
    }

    // remove node from doulbe linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
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