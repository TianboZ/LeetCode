package debugLaicode;

public class ReverseLinkedListPairByPair {
    // return new head of reversed linked path
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        // base-case
        if (head == null || head.next == null) {
            return head;
        }
        // rule
        ListNode newHead = reverseInPairs(head.next.next);
        ListNode next = head.next;
        next.next = head;
        head.next = newHead;
        return next;
    }
}
