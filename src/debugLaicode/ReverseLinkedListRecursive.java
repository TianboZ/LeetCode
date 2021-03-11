package debugLaicode;

public class ReverseLinkedListRecursive {
    public ListNode reverse(ListNode head) {
        // basecase
        if (head == null || head.next == null) {
            return head;
        }
        // recursive rule
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
