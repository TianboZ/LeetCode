package debugLaicode;

public class ReverseLinkedList {
    // iterative
    public ListNode reverse(ListNode head) {
        // Write your solution here

        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // recursive
    public ListNode reverse1(ListNode head) {
        // base-case
        if (head == null || head.next == null) { /// !!!!!!!!!!
            return head;
        }

        // recursive rule
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverse1(next);
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
