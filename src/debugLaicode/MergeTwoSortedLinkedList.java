package debugLaicode;

public class MergeTwoSortedLinkedList {
    // iterative
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (one != null && two != null) {
            if (one.value <= two.value) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        // remaining linkedlist
        if (one != null) {
            curr.next = one;
        }

        if (two != null) {
            curr.next = two;
        }

        return dummy.next;
    }
    // time o(n + m)
    // space o(1)

    // recursive
    // merge two sorted linked path, return the new head
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
