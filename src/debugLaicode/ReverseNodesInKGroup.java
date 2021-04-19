package debugLaicode;

public class ReverseNodesInKGroup {
    private ListNode reverseChunk(ListNode n) {
        ListNode prev = null;
        while (n != null) {
            ListNode next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // basecaes
        if (head == null) return null;

        // recursive rule
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;

        // check current listnode length
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            count++;
            if (count == k) break;
        }

        if (count == k) {
            ListNode next = curr;
            prev.next = null;
            ListNode newH = reverseChunk(head);
            head.next = reverseKGroup(next, k);
            return newH;

        } else {
            return head;
        }
    }
}
