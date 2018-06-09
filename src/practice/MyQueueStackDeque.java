package practice;

public class MyQueueStackDeque {
    static class ListNode {
        // fields
        int val;
        ListNode next;
        ListNode prev;

        // constructors
        public ListNode(int val) {
            this.val = val;
        }
    }

    static class MyStack {
        // fields
        private int size;
        private ListNode head;

        // constructors
        public MyStack() {
            this.head = null;
            this.size = 0;
        }

        // APIs
        public Integer pop() {
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            head = head.next;
            pre.next = null;
            size--;
            return pre.val;
        }

        public void push(Integer ele) {
            ListNode newHead = new ListNode(ele);
            newHead.next = head;
            head = newHead;
            size++;
        }

        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    static class MyQueue {
        // fields
        ListNode head;
        ListNode tail;
        int size;

        // constructors
        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        // APIs
        public void offer(Integer ele) {
            if (head == null) {
                ListNode node = new ListNode(ele);
                head = node;
                tail = node;
                size++;
            } else {
                ListNode node = new ListNode(ele);
                tail.next = node;
                tail = tail.next;
                size++;
            }
        }

        public Integer poll() {
            if (head == null) {
                return null;
            }
            ListNode prev = head;
            head = head.next;
            prev.next = null;
            size--;
            return prev.val;
        }

        public Integer peek(Integer ele) {
            if (head == null) {
                return null;
            }
            return head.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("queue");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
