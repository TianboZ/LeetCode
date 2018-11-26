package debugLaicode;

public class DesignCircularQueue {
    private int[] arr;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public DesignCircularQueue(int k) {
        arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // full
        if (size == arr.length) return false;

        // not full
        arr[tail] = value;
        tail = (tail + 1) % arr.length;
        size++;
        // System.out.println("---------");
        // for (int i = head; i < tail; i++) System.out.println(arr[i]);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        // empty
        if (size == 0) return false;

        // not empty
        int res = arr[head];
        head = (head + 1) % arr.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;

        return arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;

        if (tail - 1 < 0) {
            return arr[arr.length - 1];
        }
        return arr[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}

// solution2:
class DesignCircularQueue2 {
    private int[] arr;
    private int head = 0; // head + 1 points the first element in queue
    private int tail = 1; // tail points to next availble position in queue

    public DesignCircularQueue2(int k) {
        arr = new int[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // full
        if (head == tail) return false;

        // not full
        arr[tail] = value;
        tail = (tail + 1) % arr.length;
        // System.out.println("---------");
        // for (int i = head; i < tail; i++) System.out.println(arr[i]);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        // empty
        if (isEmpty()) return false;

        // not empty
        head = (head + 1) % arr.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        System.out.println(head);
        return arr[head + 1];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;

        if (tail - 1 < 0) {
            return arr[arr.length - 1];
        }
        return arr[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (head + 1) % arr.length == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == tail;
    }
}
