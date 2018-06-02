package debugLaicode;

import java.util.HashMap;
import java.util.Map;


public class FlattenMultilevelLinkedList {
    public static  void main(String[] args) {
        FlattenMultilevelLinkedList flattenMultilevelLinkedList = new FlattenMultilevelLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node2.child = node5;
        node4.child = node7;
        node5.next = node6;
        node5.child = node8;

        // key: level          value: head and tail of linkedlist
        Map<Integer, Pair> map = new HashMap<>();
        flattenMultilevelLinkedList.dfs(node1, map, 0);
        System.out.println("aaa");

    }
    public  void  dfs(Node head, Map<Integer, Pair> map, int level) {
        // base-case
        if (head == null) {
            return;
        }
        // recursive rule
        Node copyN = new Node(head.val);
        if (map.containsKey(level)) {
            map.get(level).tail.next = copyN;
            map.get(level).tail = copyN;
        } else {
            Pair pair = new Pair();
            pair.head = copyN;
            pair.tail = copyN;
            map.put(level, pair);
        }

        // go child
        dfs(head.child, map, level + 1);

        // go next
        dfs(head.next, map, level);
    }

    static class Node {
        Node next;
        Node child;
        int val;
        public Node (int val) {
            this.val = val;
        }
    }
    class Pair {
        Node head;
        Node tail;

    }
}
