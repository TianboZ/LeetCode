package debugLaicode;

public class MergeTwoSortedLinkedList {
    // iterative
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

    // recursive
    // merge two sorted linked list, return the new head
    public ListNode merge1(ListNode one, ListNode two) {
        // base-case
        if (one == null) {
            return one;
        }
        if (two == null) {
            return two;
        }
        // recursive rule
        if (one.val < two.val) {
            one.next = merge(one.next, two);
            return one;
        } {
            two.next = merge(one, two.next);
            return two;
        }
    }
    // time o(n)
    // space o(n)
}
