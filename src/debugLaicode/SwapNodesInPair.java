package debugLaicode;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        // basecase
        if (head == null || head.next == null) return head;

        // recursive rule
        ListNode next = head.next;
        ListNode next2 = next.next;
        next.next = head;
        head.next = swapPairs(next2);
        return next;
    }
}
