package debugLaicode;

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode newHead = reverse(tmp);

        return merge(head, newHead);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            cur.next = h1;
            cur = h1;
            h1 = h1.next;
            cur.next = h2;
            cur = h2;
            h2 = h2.next;
        }

        if (h1 != null) {
            cur.next = h1;
        }

        if (h2 !=null) {
            cur.next = h2;
        }

        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
