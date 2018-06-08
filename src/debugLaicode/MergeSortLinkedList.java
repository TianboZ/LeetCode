package debugLaicode;

public class MergeSortLinkedList {
    // return new head!
    public ListNode mergeSort(ListNode head) {
        // base-case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive rule
        ListNode mid = findMid(head);
        ListNode head1 = mid.next;
        mid.next = null;

        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(head1);
        return merge(h1, h2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge two sorted linkedlist
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                cur.next = h1;
                cur = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                cur = h2;
                h2 = h2.next;
            }
        }

        // remain
        if (h1 != null) {
            cur.next = h1;
        }
        if (h2 != null) {
            cur.next = h2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
        ListNode res = mergeSortLinkedList.mergeSort(n1);
    }
}
