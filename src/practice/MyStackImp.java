package practice;

public class MyStackImp {
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

    static class BoundedStack {
        // fields
        Integer[] array;
        int size;
        int tail;

        // constructors
        public BoundedStack(int capacity) {
            this.array = new Integer[capacity];
            size = 0;
            tail = 0;
        }
        // APIs
        public boolean push(Integer ele) {
            if (size == array.length) {
                return false;
            }
            array[tail] = ele;
            tail++;
            size++;
            return true;
        }

        public Integer pop() {
            if (size == 0) {
                return null;
            }
            int res = array[tail - 1];
            tail--;
            size--;
            return res;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            int res = array[tail - 1];
            return res;
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

        BoundedStack boundedStack = new BoundedStack(10);
        boundedStack.push(1);
        boundedStack.push(2);
        boundedStack.push(3);
        boundedStack.push(4);
        System.out.println("boundedStack");
        while (!boundedStack.isEmpty()) {
            System.out.println(boundedStack.pop());
        }
    }
}
