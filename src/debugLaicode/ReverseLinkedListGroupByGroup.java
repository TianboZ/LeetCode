package debugLaicode;

public class ReverseLinkedListGroupByGroup {
    public ListNode reverseInGroups(ListNode head, int k) {
        // Write your solution here
        // base-case
        if (head == null || head.next == null) {
            return head;
        }
        // rule
        if (isEnoughK(head, k)) {
            ListNode tail = findTail(head, k);
            ListNode next = tail.next;
            tail.next = null;

            ListNode newHead = reverseInGroups(next, k);
            head = reverse(head);
            tail = findTail(head, k);
            tail.next = newHead;
            return head;
        } else {
            return head;
        }
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode findTail(ListNode head, int k) {
        int count = 1;
        while (head.next != null && count < k) {
            head = head.next;
            count++;
        }
        return head;
    }
    public boolean isEnoughK(ListNode head, int k) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
            if (count == k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseLinkedListGroupByGroup reverseLinkedListGroupByGroup = new ReverseLinkedListGroupByGroup();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        System.out.println(reverseLinkedListGroupByGroup.isEnoughK(node1, 3));
        System.out.println(reverseLinkedListGroupByGroup.findTail(node1, 3).val);

        ListNode res = reverseLinkedListGroupByGroup.reverseInGroups(node1, 2);


    }
}
