package practice;

public class MyHashMap1<K, V> {
    // helper class
    private class Node<K, V> {
        // fields
        private K key;
        private V value;
        private Node<K, V> next;

        // constructor
        private Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        // api
        private K getKey() {
            return this.key;
        }

        private V getValue() {
            return this.value;
        }

        private void setValue(V v) {
            this.value = v;
        }
    }

    // fields
    private int size;
    private double LOAD_FACTOR = 0.7;
    private int INIT_CAPACITY = 16;
    private Node<K, V>[] array; // bucket array

    // constructor
    public MyHashMap1() {
        this.array = (Node<K, V>[]) new Node[INIT_CAPACITY];
    }

    // api
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // medium
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) {
            if (equalsKey(head.getKey(), key)) {
                return head.getValue();
            } else {
                head = head.next;
            }
        }
        return null;
    }

    // easy
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) {
            if (equalsKey(head.getKey(), key)) {
                return true;
            } else {
                head = head.next;
            }
        }
        return false;
    }

    // hard
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) {
            // case1, this entry exist in bucket array
            if (equalsKey(head.getKey(), key)) {
                head.setValue(value);
                return value;
            } else {
                head = head.next;
            }
        }
        // case2, this entry is new one
        Node<K, V> node = new Node<>(key, value);
        array[index] = node;
        size++;

        if (needRehash()) {
            rehash();
        }
        return null;
    }
    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> prev = null;
        Node<K, V> curr = head;
        while (curr != null) {
            if (equalsKey(curr.getKey(), key)) {
                if (prev == null) {
                    // delete head of linked list
                    array[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.getValue();
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    private boolean needRehash() {
        return size > array.length * LOAD_FACTOR;
    }

    private void rehash() {
        // todo
        Node<K, V>[] old = array;
        array = (Node<K,V>[]) new Node[old.length * 2]; // enlarge
        for (Node<K, V> head : old) {
            while (head != null) {
                Node<K, V> next = head.next;
                int index = getIndex(head.getKey());
                Node<K, V> oriHead = array[index];
                head.next = oriHead;
                array[index] = head;
                head = next;
            }
        }
    }

    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || (k1!= null && k1.equals(k2));
    }

    private int getIndex(K key) {
        int code = getHashCode(key);
        return code % array.length;
    }

    private int getHashCode(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode());
    }

    public static void main(String[] args) {
        MyHashMap1<Integer, Integer> map = new MyHashMap1();
        for (int i = 0; i < 30; i++) {
            map.put(i, i + 1);
        }

        map.put(null, 1);
        map.put(null, 2);
        //map.remove(29);
        System.out.println("size: " + map.size());
        System.out.println(map.get(null));
    }
}



