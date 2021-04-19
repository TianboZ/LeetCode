package debugLaicode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* sol1:
*
* pq
*
* sol2:
* iterative
* */
public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        Queue<ListNode> pq = new PriorityQueue<>(( n1,  n2) -> {
            return n1.value - n2.value;
        }); // pq is min heap

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // initial
        for (ListNode node : listOfLists) {
            pq.offer(node);
        }

        // terminate condition
        while (!pq.isEmpty()) {
            // expand
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;


            // generate
            if (n.next != null) {
                pq.offer(n.next);
            }
        }
        return dummy.next;
    }

}

// space o(k)
// time (logk * n)    n is total # of nodes
