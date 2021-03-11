package debugLaicode;

public class CheckIfLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        if (head == null) return true;

        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head2 = reverse(head2);
        return compare(head, head2);
    }

    private boolean compare(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.value != h2.value) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
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
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
