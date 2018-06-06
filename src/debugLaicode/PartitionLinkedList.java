package debugLaicode;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode cur1 = small;
        ListNode cur2 = large;

        while (head != null) {
            if (head.val < target) {
                cur1.next = head;
                cur1 = head;
                head = head.next;
            } else {
                cur2.next = head;
                cur2 = head;
                head = head.next;
            }
        }

        // connect
        cur1.next = large.next;
        // de-link
        cur2.next = null;

        return small.next;
    }
}
