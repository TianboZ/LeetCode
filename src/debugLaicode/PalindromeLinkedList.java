package debugLaicode;


import java.util.List;

/*
*
* solution1:
* - find mid, cut linked list to half 1 and half2
* - reverse half 2
* - tow pointers, compare nodes in half1 and half2
*
* time o(n)
* space o(1)
*
*
* solution2:
* recursion
*
* time o(n)
 * space o(n)
* */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);

        ListNode h2 = mid.next;
        mid.next = null; // de-link half1 and half2

        h2 = reverse(h2);
        return helper(head, h2);
    }

    private boolean helper(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node  = next;
        }
        return prev;
    }
    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // so2

    ListNode front;
    public boolean isPalindrome2(ListNode head) {
        front = head;
        return helper(head);
    }


    // traverse the linked list, return false if detected not palindrome
    private boolean helper(ListNode node) {
        if (node == null) return true;

        if(!helper(node.next)) return false;
        if (node.val != front.val) return false;
        front = front.next;
        return true;
    }

}
