package debugLaicode;

public class RotateListByKPlaces {
    public ListNode rotateKplace(ListNode head, int n) {
        // Write your solution here
        if (head == null) return head;

        int len  = getLen(head);
        int half = n % len;
        if (half == 0) return head;

        int index = len - half; // index to rotate
        ListNode curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }  // curr is last node before rotate

        ListNode h1 = curr.next;
        curr.next = null;

        ListNode tail = h1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return h1;
    }



    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n0.next = n1; n1.next = n2; n2.next = n3;

        RotateListByKPlaces sol = new RotateListByKPlaces();
        sol.rotateKplace(n0, 1);

    }
}
