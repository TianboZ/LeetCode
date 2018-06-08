package debugLaicode;

import java.util.List;

public class SelectionSortLinkedList {
    public ListNode selectionSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {
            ListNode newHead = cur.next;
            int min = cur.val;
            ListNode tmp = cur;
            while (newHead != null) {
                if (newHead.val < min) {
                    tmp = newHead;
                    min = newHead.val;
                }
                newHead = newHead.next;
            }
            swap(tmp, cur);
            System.out.println(cur.val);
            cur = cur.next;
            System.out.println("a");
        }
        return  head;
    }
    private void swap(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
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

        SelectionSortLinkedList selectionSortLinkedList = new SelectionSortLinkedList();
        ListNode res = selectionSortLinkedList.selectionSort(n1);
    }
}
