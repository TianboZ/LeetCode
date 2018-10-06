package debugLaicode;

import java.util.*;

public class InsertDeleteGetRandom {
    // Design a data structure that supports all following operations in average O(1) time.
    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int len = 0;
    Map<Integer, List<Node>> map;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        this.map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        List<Node> nodes = map.get(val);
        if (nodes == null) {
            nodes = new ArrayList<>();
            map.put(val, nodes);
        }
        Node node = new Node(val);
        nodes.add(node);

        // append to the tail of DDL
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        len++;
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            List<Node> nodes = map.get(val);
            Node node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0) map.remove(val);

            if (node.prev != null && node.next != null) {
                // node in the middle of DDL
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            } else if (node.next == null && node.prev != null) {
                // node is tail
                tail = node.prev;
                tail.next = null;
                node.prev = null;
            } else if (node.next != null && node.prev == null) {
                // node is head
                head = node.next;
                head.prev = null;
                node.next = null;
            } else {
                // node is only element in DDL
                head = null;
                tail = null;
            }
            len--;
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        int count = random.nextInt(len);
        Node curr = head;

        while (count > 0) {
            curr = curr.next;
            count--;
        }
        return curr.val;
    }
}
