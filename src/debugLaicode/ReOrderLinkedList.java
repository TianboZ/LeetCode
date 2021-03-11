package debugLaicode;


public class ReOrderLinkedList {
    /*
    * solution
    * steps:
    * 1. find middle
    * 2. reverse 2nd half linked list
    * 3. merge two short linked list
    *
    *
    * time: o(n)
    * space: o(1)
    *
    * */
    public ListNode reorder(ListNode head) {
       // sanity check
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        // de-link original long linked list
        ListNode headTwo = mid.next;
        mid.next = null;
        headTwo = reverse(headTwo);
        return  merge(head, headTwo);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (h1 != null && h2 != null) {
            curr.next = h1;
            h1 = h1.next;
            curr = curr.next;

            curr.next = h2;
            h2 = h2.next;
            curr = curr.next;
        }
        if (h1 !=null) {
            curr.next = h1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ReOrderLinkedList reOrderLinkedList = new ReOrderLinkedList();
        ListNode res = reOrderLinkedList.reverse(n1);

        System.out.println(res);
    }
}
