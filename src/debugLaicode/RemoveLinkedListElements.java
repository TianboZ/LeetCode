package debugLaicode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Write your solution here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;

        // sol1:
        // while (curr != null) {
        //     next = curr.next;
        //     if (curr.value != val) {
        //       prev.next = curr;
        //       prev = curr;
        //     }
        //     curr = curr.next;
        // }
        // prev.next = curr;

        // sol2:
        while (curr != null) {
            next = curr.next;
            if (curr.value == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }


        return dummy.next;
    }
}
