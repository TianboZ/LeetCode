package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbers2 {
    //        [7,        2,        4,      3
    //        [         5,         6,       4
    // curry: 0
    // sum:   [7, 0, 7+1, 7
    // result:[7, 8, 0, 7
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        pushIntoStack(s1, l1);
        pushIntoStack(s2, l2);

        // store the sum
        Deque<Integer> res = new LinkedList<>();

        int carry = 0;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            int num1 = s1.pollFirst();
            int num2 = s2.pollFirst();

            int newCarry = (num1 + num2 + carry) / 10;
            int digit = (num1 + num2 + carry) % 10;
            carry = newCarry;
            res.offerFirst(digit);
        }

        // s1 is remaining
        while (!s1.isEmpty()) {
            int num1 = s1.pollFirst();

            int newCarry = (num1 + carry) / 10;
            int digit = (num1 + carry) % 10;
            carry = newCarry;
            res.offerFirst(digit);
        }
        // s2 is remaining
        while (!s2.isEmpty()) {
            int num2 = s2.pollFirst();

            int newCarry = (num2 + carry) / 10;
            int digit = (num2 + carry) % 10;
            carry = newCarry;
            res.offerFirst(digit);
        }

        if (carry != 0) res.offerFirst(carry); // key point

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // create linked list
        while (!res.isEmpty()) {
            curr.next = new ListNode(res.pollFirst());
            curr = curr.next;
        }
        return dummy.next;
    }

    private void pushIntoStack(Deque<Integer> stack, ListNode head) {
        while (head!= null) {
            stack.offerFirst(head.val);
            head = head.next;
        }
    }
}
