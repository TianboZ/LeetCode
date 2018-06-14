package debugLaicode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // initial
        for (ListNode node : listOfLists) {
            minHeap.offer(node);
        }

        while (!minHeap.isEmpty()) {
            // expand
            ListNode curr = minHeap.poll();
            head.next = curr;
            head = head.next;
            // generate
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }
        }
        return dummy.next;
    }
    class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val == n2.val) {
                return 0;
            }
            return n1.val < n2.val ? -1 : 1;
        }
    }
}
