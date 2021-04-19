package MianJing.ixl.onsite;


import java.util.HashMap;
import java.util.Map;

/*
*
* solution:
*
* use hashmap + doubly linked list
* hashmap: efficient to find key
*   - Map<key, Node>
*
* doubly linked list: O(1) time to remove a node
* Node {
*   int key;
*   int val;
*   Node prev;
*   Node next;
* }
*
* */
public class LRU {
    // fields
    // doubly linked node
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    // constructor
    LRU(int size) {
        this.size =size;
        cache = new HashMap<>();
        head = new Node(0, 0); // dummy node
        tail = new Node(0, 0); // dummy node
        head.next = tail;
        tail.prev = head;
    }

    // APIs
    public void put(int key, int value) {
       Node n = cache.get(key);
       if (n == null) {
           if (cache.size() == size) {
               // remove tail node first
               Node t = tail.prev;
               remove(t);
               cache.remove(t.key);
           }

           // put a new node to map
           n = new Node(key, value);
           cache.put(key, n);
           appendHead(n);
       } else {
           // update node value
           n.val = value;
           remove(n);
           appendHead(n);
       }
    }

    public Integer get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            remove(node); // remove node from current linked list position
            appendHead(node); // append this node to head

            return node.val;
        }
    }

    private void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;
    }
    private void appendHead(Node n) {
        Node next = head.next;

        head.next = n;
        n.next = next;

        next.prev = n;
        n.prev = head;
    }

    public static void main(String[] str) {
        LRU lru = new LRU(3);
        lru.put(1, 2);
        lru.put(2, 3);
        lru.put(3, 4);
        lru.put(4, 5);

        // now we have   keys:    4<->3<->2
        //               values:  5<->4<->3

        System.out.println(lru.head);
        int res = lru.get(3); // 4
        System.out.println(res);

    }
}
