package debugLaicode;

public class AddTwoNumbers1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry  = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

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
            curr.next = node;
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
