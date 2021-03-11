package debugLaicode;

public class DeleteNodeAtIndex {
    public ListNode deleteNode(ListNode head, int index) {
        // Write your solution here
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode curr = d;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                ListNode next = curr.next;
                if (next == null) {
                    curr.next = null;
                } else {
                    curr.next = next.next;
                }
                return d.next;
            }
            curr = curr.next;
            count++;
        }
        return d.next;
    }
}
