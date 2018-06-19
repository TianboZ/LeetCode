package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacterInStream {
    // field:
    // each node is double linked list node
    // and it contains one distinct character
    static class Node {
        // field
        Character c;
        Node next;
        Node prev;
        // constructor
        public Node(Character c) {
            this.c = c;
        }
    }

    // record the head and tail of double linked list all the time
    // only the character appears one time will appear in double linked list
    private Node head;
    private Node tail;

    // for every character, it has three cases:
    // 1: it only appear once, it will in the double linked list
    // 2: it appear >= 2, it will in the repeated hashset
    // 3: it does not appear yet, then it will not in the hashset and double linked list
    private Set<Character> repeated;
    private Map<Character, Node> singled;

    // constructor:
    public FirstNonRepeatingCharacterInStream() {
        head = new Node('a');
        tail = head;
        repeated = new HashSet<>();
        singled = new HashMap<>();
    }

    // API:
    public void read(char ch) {
        // if the char appears more than once, ignore
        if (repeated.contains(ch)) {
            return;
        }
        Node node = singled.get(ch);
        if (node == null) {
            // it the character appear for the 1st time,
            // add it to the double linked list tail
            node = new Node(ch);
            append(node);
        } else {
            // it appeared before, then need to remove it from the
            // map and put it into repeated set
            remove(node);
        }
    }
    private void append(Node node) {
        singled.put(node.c, node);
        tail.next = node;
        node.prev = tail;
        // node.next = head; ???
        tail = tail.next;
    }

    private void remove(Node node) {
        singled.remove(node.c);
        repeated.add(node.c);
        // use sentinel node so that some of the corner cases will be eliminated

        if (node == tail) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            node.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

    }
    public Character firstNonRepeating() {
        // when head == tail, means only dummy node in the list
        if (head == tail) {
            return null;
        }
        System.out.println(head.next.c);
        return head.next.c;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacterInStream firstNonRepeatingCharacterInStream = new FirstNonRepeatingCharacterInStream();
        firstNonRepeatingCharacterInStream.read('a');
        firstNonRepeatingCharacterInStream.read('b');
        firstNonRepeatingCharacterInStream.read('c');

        firstNonRepeatingCharacterInStream.read('a');
        firstNonRepeatingCharacterInStream.read('c');

        firstNonRepeatingCharacterInStream.firstNonRepeating();

    }
}
