package debugLaicode;


import java.util.HashMap;
import java.util.Map;

/*
*
* solution1:
*
* iterate original linkedlist, for each node, make a copy.
* use hashmap to duplicate
*
* Map<Node, Node>   key: original node, copied node

* complexity:
* time o(n)
* space o(n)
*
*
* solutuion2:
*
* two passes
* 1st pass, copy all original nodes, and put copied node in the Map<Node, Node>
        key: original node, value: copied node
* 2nd pass, connect all copied nodes
 * */
public class DeepCopyLinkdedListWithRandomPointer {
    private static class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int value) {
          this.value = value;
        }
    }

    // recursive
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // initial
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return copy(head, map);
    }

    // return the head of copied random list
    private RandomListNode copy(RandomListNode c, Map<RandomListNode, RandomListNode> map) {
        // base case
        if (c == null) return c;
        RandomListNode node = map.get(c);
        if (node != null) return node;
        // recursive rule

        RandomListNode copyNode = new RandomListNode(c.value);
        map.put(c, copyNode);
        copyNode.next = copy(c.next, map);
        copyNode.random = copy(c.random, map);
        return copyNode;
    }

    // iterative
    public RandomListNode copy1(RandomListNode head) {
        // Write your solution here.
        // sanity check
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // initial
        RandomListNode head2 = new RandomListNode(head.value);
        map.put(head, head2);
        RandomListNode curr1 = head;
        RandomListNode curr2 = head2;

        while (curr1 != null) {
            // copy next
            if (curr1.next != null) {
                RandomListNode nextNode = curr1.next;
                if (!map.containsKey(nextNode)) {
                    map.put(nextNode, new RandomListNode(nextNode.value));
                }
                curr2.next = map.get(nextNode);
            }
            // copy random
            if (curr1.random != null) {
                RandomListNode nextRandom = curr1.random;
                if (!map.containsKey(nextRandom)) {
                    map.put(nextRandom, new RandomListNode(nextRandom.value));
                }
                curr2.random = map.get(nextRandom);
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return head2;
    }
}
