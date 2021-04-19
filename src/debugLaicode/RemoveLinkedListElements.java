package debugLaicode;

public class RemoveLinkedListElements {
    // see lC solution, it tells how dummy is useful and other usecases, like LRU cache
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        curr.next = head;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }
        }
        curr.next = null; //!!
        return dummy.next;

    }

    public static void main(String[] args) {
        RemoveLinkedListElements sol  = new RemoveLinkedListElements();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        sol.removeElements(n1, 2);
    }
}
