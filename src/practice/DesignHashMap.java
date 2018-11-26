package practice;

public class DesignHashMap {

    private class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] bucket;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        this.bucket = (Node[]) new Node[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = findIndex(key);
        Node head = bucket[index];
        while (head != null) {
            if (head.key == key) {
                head.val = value;
                return;
            } else {
                head = head.next;
            }
        }
        // input key, value pair is not exist
        Node node = new Node(key, value);
        node.next = bucket[index];
        bucket[index] = node;
    }

    private int findIndex(int key) {
        Integer i = new Integer(key);
        return i.hashCode() % bucket.length;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = findIndex(key);
        Node head = bucket[index];
        while (head != null) {
            if (head.key == key) {
                return head.val;
            } else {
                head = head.next;
            }
        }
        return -1; // not found
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = findIndex(key);
        Node head = bucket[index];
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    // first element to be deleted
                    bucket[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            } else {
                prev = head;
                head = head.next;
            }
        }
    }
}
