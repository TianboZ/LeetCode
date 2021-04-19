package debugLaicode;

// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = getLen(headA);
        int lenb = getLen(headB);
        int diff = Math.abs(lena - lenb);

        if (lena > lenb) {
            while (headA != null && diff > 0) {
                headA= headA.next;
                diff--;
            }
        } else if (lena < lenb) {
            while (headB != null && diff > 0) {
                headB= headB.next;
                diff--;
            }
        }

        while  (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA  = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node  = node.next;
        }
        return len;
    }
}
