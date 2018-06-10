package practice;

public class MyQueueImp {
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

    static class BoundedQueue {
        // fields
        int head;
        int tail;
        int size;
        Integer[] array;

        // constructors
        public BoundedQueue(int capacity) {
            this.size = 0;
            this.head = 0;
            this.tail = 0;
            this.array = new Integer[capacity];
        }

        // API
        public boolean offer(Integer ele) {
            // case1: array is full
            if (size == array.length) {
                return false;
            }
            // case2: array is not full
            array[tail] = ele;
            tail = tail + 1 == array.length ? 0 : tail + 1;
            size++;
            return true;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return array[head];
        }

        public Integer poll() {
            if (size == 0) {
                return null;
            }
            Integer res = array[head];
            head = head + 1 == array.length ? 0 : head + 1;
            size--;
            return res;
        }

        public int size() {
            return size;
        }

        public boolean isFull() {
            return size == array.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("queue");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }


        BoundedQueue boundedQueue = new BoundedQueue(10);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        System.out.println("boundedQueue");
        while (!boundedQueue.isEmpty()) {
            System.out.println(boundedQueue.poll());
        }
    }
}
