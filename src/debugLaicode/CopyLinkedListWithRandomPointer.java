package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    static class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int value) {
            this.value = value;
        }
    }

    // sol1:
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return head;
        }

        RandomListNode original = head;
        // key: original    value: copied
        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
        RandomListNode cur = new RandomListNode(head.value);
        lookup.put(head, cur);

        while (head != null) {
            // copy next
            if (head.next != null) {
                if (lookup.containsKey(head.next)) {
                    cur.next = lookup.get(head.next);
                } else {
                    RandomListNode copy = new RandomListNode(head.next.value);
                    lookup.put(head.next, copy);
                    cur.next = copy;
                }
            }

            // copy random
            if (head.random != null) {
                if (lookup.containsKey(head.random)) {
                    cur.random = lookup.get(head.random);
                } else {
                    RandomListNode copy = new RandomListNode(head.random.value);
                    lookup.put(head.random, copy);
                    cur.random = copy;
                }
            }
            cur = cur.next;
            head = head.next;
        }
        return lookup.get(original);
    }

    // sol2:
    // method:
    // use Map<Node, Node> map, key: original node, value: copied node
    // map is used to record the nodes that is already copied!
    public RandomListNode copy1(RandomListNode head) {
        // Write your solution here.
        RandomListNode ori = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // first pass, to record all the nodes
        while (head != null) {
            RandomListNode copy = map.get(head);
            if (copy == null) {
                RandomListNode node = new RandomListNode(head.value);
                map.put(head, node);
            }
            head = head.next;
        }
        // second pass, link copied nodes
        head = ori;
        while (head != null) {
            if (head.next != null) {
                map.get(head).next = map.get(head.next);
            }
            if (head.random != null) {
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }

        return map.get(ori);
    }
}


