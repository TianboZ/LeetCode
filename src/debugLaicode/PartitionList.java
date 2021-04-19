package debugLaicode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode one = new ListNode(0); // dummy node, nodes < x
        ListNode two = new ListNode(0); //dummy node,  nodes >= x
        ListNode curr1 = one;
        ListNode curr2 = two;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;

                curr1 = curr1.next;
            } else {
                curr2.next = head;

                curr2 = curr2.next;
            }
            head= head.next;
        }

        curr1.next = two.next;
        curr2.next = null;
        return one.next;
    }
}
