package MianJing.ixl;

import debugLaicode.ListNode;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode h2 = mid.next;
        mid.next = null;
        h2 = reverse(h2);
        return compare(head, h2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private boolean compare(ListNode h1, ListNode h2) {
        while (h1 != null && h2!= null) {
            if (h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
}
