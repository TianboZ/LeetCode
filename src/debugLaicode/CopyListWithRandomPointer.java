package debugLaicode;


import java.util.*;


/*
solution1:
    1 --> 2 --> 3 --> 4
    |-----------|
          p     c

    1'---2'----3'---4

first pass: iterate all the nodes, copy each of them, store them in the map<key: original node, value: copy node>

socond pass: iterate all the original nodes, connect copied nodes

time O(n)
space O(n)

solution2:
one pass
when iterate all the node, same time we copy and connect

*/
public class CopyListWithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        // sanity check
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;

        // first pass, copy all the nodes
        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.label);
            map.put(curr, node);
            curr = curr.next;
        }

        // second pass, connect nodes
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }

    // solution2:
    public RandomListNode copyRandomList1(RandomListNode head) {
        // sanity check
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);

        while (curr != null) {
            // copy next
            if (curr.next != null) {
                if (!map.containsKey(curr.next)) {
                    map.put(curr.next, new RandomListNode(curr.next.label));
                }
                map.get(curr).next = map.get(curr.next);
            }

            // copy random
            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    map.put(curr.random, new RandomListNode(curr.random.label));
                }
                map.get(curr).random = map.get(curr.random);
            }

            curr = curr.next;
        }
        return newHead;
    }
}