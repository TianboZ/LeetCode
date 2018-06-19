package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheGenerics<K, V> {
    // fields
    // each node contains the key, value pair, and it also is a double linked list node
    static class Node<K, V> {
        // fields
        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        // constructor
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        // API
        public void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int limit;

    // record all the time the head and tail of double linked list
    private Node<K, V> head;
    private Node<K, V> tail;

    // maintains the relationship of key and its corresponding node in the double linked list
    private Map<K, Node<K, V>> map;

    // constructor
    // limit is the max capacity of the cache
    public LRUCacheGenerics(int limit) {
        this.limit = limit;
        this.map = new HashMap<>();
    }

    // APIs
    public void set(K key, V value) {
        Node<K, V> node = null;
        if (map.containsKey(node)) {
            // 1. if the map contains key, we need to update its value and move it to
            // the head(head is most recent position)
            node = map.get(key);
            node.value = value;
            remove(node);
            append(node);
        } else if (map.size() < limit) {
            // 2. if the key is not in the map and we still have space, we can append
            // a node to the head
            node = new Node<>(key, value);
            append(node);
        } else {
            // 3. if the key is not in the map and we do not have space, we need to remove
            // the tail node,
      /*
      node = tail;
      remove(node);
      node.update(key, value);
      append(node);
      */
            remove(tail);
            node = new Node<>(key, value);
            append(node);
        }
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        // even it is a read operation, it is still a write operation to the double linked list
        // move the node to head
        remove(node);
        append(node);
        return node.value;
    }

    private Node<K, V> append(Node<K, V> node) {
        map.put(node.key, node);
        if (head == null) {
            tail = node;
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }

    private Node<K, V> remove(Node<K, V> node) {
        map.remove(node.key);
        if (node.prev != null && node.next != null) {
            // node in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        } else if (node.prev != null && node.next == null) {
            // node is tail
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        } else if (node.prev == null && node.next != null) {
            // node is head
            head = node.next;
            head.prev = null;
            node.next = null;
        } else {
            // only one node in the double linked list
            head = null;
            tail = null;
        }
        return node;
    }

    public static void main(String[] args) {
        LRUCacheGenerics lruCacheGenerics = new LRUCacheGenerics(3);
        lruCacheGenerics.set(1, "a");
        lruCacheGenerics.set(2, "b");
        lruCacheGenerics.set(3, "c");
        lruCacheGenerics.set(4, "d");

        System.out.println(lruCacheGenerics.head.value.toString() + lruCacheGenerics.tail.value.toString());
    }
}
