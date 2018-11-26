package practice;

public class MaxHeap {
    // fields
    int[] array;
    int start = 0;
    int end = 0; // end points to the next available position of array

    // constructor
    MaxHeap() {
        array = new int[1000]; // assume the min heap is fixed, 1000
    }

    // API
    public int poll() {
        if (end == 0) return -1; // empty

        int res = array[0];
        array[0] = array[end - 1];
        end--;

        percolateDown(0);

        return res;
    }

    private void percolateDown(int i) {
        int index = i;

        while (index < end) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            //System.out.println("b");
            int larger = index;

            if (left < end && array[left] > array[larger]) larger = left;
            if (right < end && array[right] > array[larger]) larger = right;

            if (larger == index) {
                break;
            } else {
                swap(array, larger, index);
                index = larger;
            }
        }
    }

    //
    public void offer(int val) {
        if (end == array.length) return;  // full

        array[end] = val;
        end++;
        percolateUp();
    }

    private void percolateUp() {
        int index = end - 1;
        int parent = (index - 1) / 2;
        while (parent >= 0) {
            if (array[parent] < array[index]) {
                swap(array, parent, index);
                index = parent;
                parent = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmpt = arr[i];
        arr[i] = arr[j];
        arr[j] = tmpt;
    }

    public void heapify() {
        for (int i = end - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4 , 5};
        MaxHeap maxHeap = new MaxHeap();
        for (int i : arr) {
            maxHeap.offer(i);
        }

        for (int i = 0; i < maxHeap.array.length; i++) {
            System.out.println(maxHeap.array[i]);
        }
        int count = 5;
        while (count > 0) {
            System.out.println(maxHeap.poll());
            count--;
        }

    }


}
