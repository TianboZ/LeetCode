package debugLaicode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        Queue<ListNode> pq = new PriorityQueue<>((ListNode n1, ListNode n2) -> {
            return n1.value == n2.value ? 0 : (n1.value < n2.value ? -1 : 1);
        }); // pq is min heap

        ListNode dummy = new ListNode(1);
        ListNode currNode = dummy;

        // initial
        for (ListNode node : listOfLists) {
            pq.offer(node);
        }

        // terminate condition
        while (!pq.isEmpty()) {
            // expand
            ListNode curr = pq.poll();
            currNode.next = curr;
            currNode = currNode.next;


            // generate
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }

}

// space o(k)
// time (logk * n)    n is total # of nodes
