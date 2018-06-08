package practice;

public class MyHashMap<K, V> {
    // inner class
    public static class Node<K, V> {
        // fields
        private K key;
        private V value;
        public Node<K, V> next = null;

        // constructors
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // APIs
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V v) {
            value = v;
        }
    }
    // fields
    private static final int INIT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.7;

    private Node<K, V>[] array;
    private int size;

    // constructor
    public MyHashMap() {
        this.array = (Node<K, V>[]) new Node[INIT_CAPACITY];
    }

    // API
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public V get(K key) {
        int index = index(key);
        // it is the head of the linked list of Node<K, V>
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.getKey(), key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = index(key);
        // it is the head of the linked list of Node<K, V>
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.getKey(), key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V put(K key, V value) {
        int index = index(key);
        // it is the head of the linked list of Node<K, V>
        Node<K, V> node = array[index];

        // case1, this pair already exist, then just need to update value
        while (node != null) {
            if (equalsKey(node.getKey(), key)) {
                V ondValue = node.getValue();
                node.setValue(value);
                return ondValue;
            }
            node = node.next;
        }
        // case2, this key is the 1st time putted into the map
        Node<K, V> newNode = new Node<>(key, value);
        array[index] = newNode;
        size++;
        if (needRehashing()) {
            rehash();
        }

        return null;
    }

    public V remove(K key) {
        int index = index(key);
        // it is the head of the linked list of Node<K, V>
        Node<K, V> curr = array[index];
        Node<K, V> prev = null;
        while (curr != null) {
            if (equalsKey(curr.getKey(), key)) {
                if (prev == null) {
                    array[index] = curr.next;
                }  else {
                    prev.next = curr.next;
                }
                size--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    //////////////////////////////////////////private///////////////////////////////////////////////////////////////////
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int code = key.hashCode();
        return code & 0x7fffffff;
    }
    private int index(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    private boolean needRehashing() {
        System.out.println(size > LOAD_FACTOR * array.length);
        return size > LOAD_FACTOR * array.length;
    }

    // still confused!!!
    private void rehash() {
        Node<K,V>[] old = array;
        array = (Node<K,V>[]) new Node[old.length * 2];
        for (Node<K, V> e : old) {
            // every e is the head reference of linked list of Node<K, V>!!!
            // tricky part: after we enlarge the array, then the array length changes, then each key's index might
            // change, so we need to iterate every node, re-compute their index, put them in the new position in the
            // enlarged new array!
            while (e != null) {
                // 不要丢掉对头的所有权！
                Node<K, V> next = e.next;
                // this node's new index
                int i = index(e.getKey());
                // append this node to the head, now array[i] could be null or other head
                e.next = array[i];
                // change array[i] to the new head
                array[i] = e;
                // now e points to original e's next
                e = next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(1, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        for (int i = 0; i < 20; i++) {
            map.put(i, i + 1);
        }

        map.remove(19);
        System.out.println(map);
    }
}
