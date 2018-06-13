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
}


