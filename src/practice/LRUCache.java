package practice;

import java.util.HashMap;
import java.util.Map;

/*


use cases:
1. we need to find out quickly if an entry is in the cache or not --> hashmap
2. we need to quickly insert an entry into the cache --> linkedlist
3. we need to quickly delete an entry from the cache --> linkedlist
4. we need to quickly adjust the priority of each entry in the cache, whick means to remove the current node and append it to the head of linledlist --> double linkedlist, head, tail

HashMap<key: Integer, value: ListNode reference>

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;
}

assumptions:
if the entry not exist, return Integer.MAX_VALUE


*/

public class LRUCache {
    // fields
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // constructor
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // APIs
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            // update priority
            remove(node);
            appendToHead(node);

            return node.value;
        }
    }
    private void remove(Node node) {
        map.remove(node.key);
        if (node.prev != null && node.next != null) {
            // node is in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        } else if (node.prev == null && node.next != null) {
            // node is head
            node.next.prev = null;
            head = node.next;
            node.next = null;
        } else if (node.prev != null && node.next == null) {
            // node is tail
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        } else {
            // node is only one in the double linked list
            head = null;
            tail = null;
        }
    }
    private void appendToHead(Node node) {
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

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, val);
            if (map.size() >= capacity) {
                remove(tail);
                appendToHead(node);
            } else {
                appendToHead(node);
            }
        } else {
            node.value = val;
            remove(node);
            appendToHead(node);
        }
    }
}