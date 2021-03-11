package debugLaicode;

public class InsertInSortedLinkedList {
    // iterative
    // sol2: use dummy head
    public ListNode insert(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (head != null) {
            if (head.val >= value) {
                ListNode tmp = new ListNode(value);
                cur.next = tmp;
                tmp.next = head;
                cur = head;  // do not forget
                break;
            } else {
                cur.next = head;
                cur = head;
                head = head.next;
            }
        }
        // append at the last position
        if (cur.val < value) {
            cur.next = new ListNode(value);
        }
        return dummy.next;
    }

    // sol1:
    public ListNode insert2(ListNode head, int value) {
        // Write your solution here
        // sanity check
        // 1.append new node before head
        if (head == null || value <= head.value) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }

        // 2. append new node after head
        ListNode curr = head;
        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }

        // insert new head at curr
        ListNode newNode = new ListNode(value);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    // recursive
    public ListNode insert1(ListNode head, int value) {
        // base-case
        if (head == null) {
            ListNode newHead = new ListNode(value);
            return newHead;
        }

        if (value <= head.val) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }
        // rule
        head.next = insert1(head.next, value);
        return head;
    }
    // time o(n)
    // space o(n)
}
