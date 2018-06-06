package debugLaicode;

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (head != null) {
            if (head.value >= value) {
                ListNode tmp = new ListNode(value);
                cur.next = tmp;
                tmp.next = head;
                cur = head;  // do not forget
                break;
            } else {
                cur.next = head;
                cur = head;
                head = head.next;
            }
        }
        // append at the last position
        if (cur.val < value) {
            cur.next = new ListNode(value);
        }
        return dummy.next;
    }
}
