package debugLaicode;

public class DeleteNodesAtIndices {


    public ListNode deleteNodes(ListNode head, int[] indices) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        for (int index : indices) {
            helper(dummy, index - count);
            count++;
        }
        return dummy.next;
    }
    private void helper(ListNode dummy, int index) {
        int i = 0;
        ListNode curr = dummy;
        while (curr != null) {
            if (i == index) {
                if (curr.next != null) {
                    curr.next = curr.next.next;
                    return;
                } else {
                    return;
                }
            } else {
                i++;
                curr = curr.next;
            }
        }
        return;
    }
}
