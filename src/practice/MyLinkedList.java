package practice;

public class MyLinkedList {
    // fields
    static class ListNode { //不希望被外界看到
        // fields
        int value;
        ListNode next;
        ListNode prev;

        // constructors
        public ListNode(int value) {
            this.value = value;
        }
    }

    ListNode dummyHead;  //不希望被外界看到
    ListNode tail;  //不希望被外界看到
    int size;  //不希望被外界看到

    // constructors
    public MyLinkedList() {
        dummyHead = new ListNode(0); // it is dummy head
        tail = dummyHead;
        this.size = 0;
    }

    // API

    public void add(int value) {
        ListNode node = new ListNode(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++; // easy to forget
    }

    // return the deleted element value
    public Integer remove(int index) {
        if (index >= size) {
            return null;
        }
        ListNode curr = dummyHead.next; // !!!
        int count = 0;
        while (curr != null && count < index) {
            count++;
            curr = curr.next;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
        return curr.value;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, int value) {
        if (index >= size) {
            return;
        }
        ListNode curr = dummyHead.next; // !!!
        int count = 0;
        while (curr != null && count < index) {
            count++;
            curr = curr.next;
        }
        ListNode newNode = new ListNode(value);
        ListNode prev = curr.prev;
        curr.prev = newNode;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = curr;
        size++;
    }

    public Integer get(int index) {
        if (index >= size) {
            return null;
        }
        ListNode curr = dummyHead.next; // !!! we used dummy head, so use head.next as current
        int count = 0;
        while (curr != null && count < index) {
            count++;
            curr = curr.next;
        }
        return curr.value;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);

        int size = myLinkedList.size();
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(myLinkedList.dummyHead.next.value + " " + myLinkedList.tail.value);
        System.out.println();

        myLinkedList.remove(1);
        //myLinkedList.remove(1);
        size = myLinkedList.size();
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(myLinkedList.dummyHead.next.value + " " + myLinkedList.tail.value);
        System.out.println();

        myLinkedList.add(1, 100);
        size = myLinkedList.size();
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(myLinkedList.dummyHead.next.value + " " + myLinkedList.tail.value);
        System.out.println();

    }
}
