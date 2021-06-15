package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry  = 0;
        ListNode head = null;

        while (l1 != null || l2!= null) {
            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);


            node.next = head;
            head = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }

    private ListNode reverse(ListNode n) {
        ListNode prev = null;
        while (n != null) {
            ListNode next = n.next;
            n.next  = prev;
            prev = n;
            n = next;
        }
        return prev;
    }

}
