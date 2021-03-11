package debugLaicode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // Write your solution here
        ListNode d1 = new ListNode(0); // dummy head, append odd nodes
        ListNode d2 = new ListNode(0);

        ListNode c1 = d1; // curr node
        ListNode c2 = d2;

        ListNode curr = head;
        int i = 1;
        while (curr != null) {
            if (i % 2 != 0) {
                // odd
                c1.next = curr;
                c1 = c1.next;

            } else {
                // even

                c2.next = curr;
                c2 = c2.next;


            }
            i++;
            curr = curr.next;
        }

        // merge odd and even linked list
        c1.next = d2.next;
        c2.next = null;
        return d1.next;
    }
}
