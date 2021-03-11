package debugLaicode;

public class DesignLinkedList {
    ListNode head;
    ListNode tail;
    int length;

    public DesignLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null) return -1;
        if (index < 0 || index >= length) return -1;
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            length++;
            return;
        }
        ListNode head2 = new ListNode(val);
        head2.next = head;
        head = head2;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
            length++;
            return;
        }
        ListNode tail2 = new ListNode(val);
        tail.next  = tail2;
        tail = tail2;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // get ListNode at index-1
        ListNode curr = head;
        for (int i = 0; i <= index - 2; i++) {
            curr = curr.next;
        }
        ListNode node = new ListNode(val);
        ListNode next = curr.next; // can be null
        curr.next = node;
        node.next = next;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) return;
        if (index < 0 || index >= length) return;

        // get ListNode at index-1
        ListNode curr = head;
        for (int i = 0; i <= index - 2; i++) {
            curr = curr.next;
        }

        ListNode next = curr.next; // can be null

        length--;
    }

}
