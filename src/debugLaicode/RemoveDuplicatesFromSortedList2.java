package debugLaicode;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (head != null) {
            int len = 1;
            while (head.next != null && head.val == head.next.val) {
                len++;
                head = head.next;
            }

            if (len > 1) {
                // duplicates
                head = head.next;
            } else {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }

        }
        curr.next = null;

        return dummy.next;
    }
}
