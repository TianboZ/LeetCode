package practice;

public class MyQueueImp {
    // method 1: using linked list
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

    /*---------------------------------------------------------------------------------------------*/

    // two solutions:
    // 1. use size to differenciate the empty and full condition

    // x x x x x
    // h
    // t
    // array is empty   head == tail  && size == 0

    // v v v v v
    // h
    // t
    // array is full   head == tail && size == array.length

    // head: points to next element element in queue
    // tail: points to next available position

    // capacity is the array.length




    // 2.
    // x x x x x
    // h t
    // array empty   (head + 1) % array.legnth == tail

    // x v v v v x
    // h         t
    // array not full

    // x v v v v v
    // h
    // t
    // array full   head == tail

    // head: head + 1 points to next element element in queue
    // tail: points to next available position

    // capacity  = array.length - 1


    // method2.1 : using circular array, use size to differenciate the empty and full condition
    static class BoundedQueue {
        // fields
        private int head; // points to next element element in queue
        private int tail; //  points to next available position
        private int size;
        private Integer[] array;

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
            //tail = tail + 1 == array.length ? 0 : tail + 1;
            tail = (tail + 1) % array.length;
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
            //head = head + 1 == array.length ? 0 : head + 1;
            head = (head + 1) % array.length;
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

    static class BoundedQueue2 {
        // fields
        private int head; // head + 1 points to next element element in queue
        private int tail; //  points to next available position
        private Integer[] array;

        // constructors
        public BoundedQueue2(int capacity) {
            head = 0;
            tail = 1;
            this.array = new Integer[capacity];
        }

        // API
        public boolean offer(Integer ele) {
            // case1: array is full
            if (isFull()) {
                return false;
            }
            // case2: array is not full
            array[tail] = ele;
            tail = (tail + 1) % array.length;
            return true;
        }

        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return array[head + 1];
        }

        public Integer poll() {
            if (isEmpty()) {
                return null;
            }
            Integer res = array[(head + 1) % array.length];
            head = (head + 1) % array.length;
            return res;
        }

//        public int size() {
//            return
//        }

        public boolean isFull() {
            return head == tail;
        }

        public boolean isEmpty() {
            return (head + 1) % array.length == tail;
        }
    }


    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        System.out.println("queue");
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }


        BoundedQueue boundedQueue = new BoundedQueue(5);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);
        boundedQueue.offer(6);

        //boundedQueue.poll();
        //boundedQueue.poll();
        //boundedQueue.offer(6);

        System.out.println("boundedQueue");
        while (!boundedQueue.isEmpty()) {
            System.out.println(boundedQueue.poll());
        }
    }
}
