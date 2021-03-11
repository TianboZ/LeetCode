package debugLaicode;

public class ReverseLinkedList {
    // iterative
    public ListNode reverse(ListNode head) {
        // sanity check
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // recursive
    public ListNode reverse1(ListNode head) {
        // base-case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive rule
        ListNode next = head.next;
        ListNode newHead = reverse1(head.next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = reverseLinkedList.reverse(node1);
        System.out.println("finish");
    }
}
