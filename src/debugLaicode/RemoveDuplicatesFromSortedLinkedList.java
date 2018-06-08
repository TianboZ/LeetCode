package debugLaicode;

public class RemoveDuplicatesFromSortedLinkedList {
    public ListNode removeDup(ListNode head) {
        //Input your code here
        if (head == null || head.next == null) {
            return head;
        }

        // length is >= 3
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        // post process
        if (cur.next != null && cur.next.val == cur.val) {
            cur.next = null;
        }
        return head;
    }

}
