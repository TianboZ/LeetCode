package debugLaicode;

public class LinkedListInsertAtIndex {

    // with dummy head
    public ListNode insert(ListNode head, int index, int value) {
        // Write your solution here
        // append at head
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode curr = d;
        int count = 0;

        while (curr != null) {
            if (count == index) {
                ListNode node = new ListNode(value);
                ListNode next = curr.next;
                if (next == null) {
                    curr.next = node;
                } else {
                    curr.next = node;
                    node.next = next;
                }
                return d.next;
            }
            curr = curr.next;
            count++;
        }
        return d.next;
    }
    // no dummy head
    public ListNode insert1(ListNode head, int index, int value) {
        // Write your solution here
        // append at head
        if (index == 0) {
            ListNode h2 = new ListNode(value);
            h2.next = head;
            return h2;
        }
        ListNode prev = null;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            ListNode next = curr.next;
            prev = curr;
            curr = next;
            i++;
            if (i == index) {
                ListNode node = new ListNode(value);
                prev.next = node;
                node.next = curr;
                return head;
            };
        }
        // append tail
        if (index == i) {
            ListNode node = new ListNode(value);
            prev.next = node;

        }
        return head;
    }
}
