package debugLaicode;

public class MergeTwoSortedLinkedList {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (one != null && two != null) {
            if (one.val < two.val) {
                cur.next = one;
                cur = one;
                one = one.next;
            } else {
                cur.next = two;
                cur = two;
                two = two.next;
            }
        }

        // remaining
        while (one != null) {
            cur.next = one;
            cur = one;
            one = one.next;
        }

        while (two != null) {
            cur.next = two;
            cur = two;
            two = two.next;
        }

        return dummy.next;
    }
}
