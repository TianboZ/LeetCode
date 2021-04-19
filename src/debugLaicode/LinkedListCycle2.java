package debugLaicode;


/*
* step1
* find intersection point
* one from head, one from intersection point, same speed traverse, when they meet, then is it entry point of cycle
*
* */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode meetNode = null;
        // find the meet node
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = slow;
                break;
            }
        }

        if (meetNode != null) {
            // cycle
            slow = head;
            fast = meetNode;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
