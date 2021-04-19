package design;


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

import java.util.*;

public class LRU {
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

    public LRU(int capacity) {
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
            // generate a new node
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

    public static void main(String[] strs) {
        LRU lru = new LRU(3);
        lru.put(1,2);
        lru.put(2,3);
        lru.put(3,4);


        lru.put(4,6);
        int res = lru.get(1); // -1
        System.out.println(res);
    }
}
