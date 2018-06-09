package practice;

import java.util.NoSuchElementException;

public class MinHeap {
    // fields
    private int[] array;
    private int size;

    // constructor
    public MinHeap (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        this.array = new int[capacity];
        this.size = 0;
    }

    // constructor, only place uses heapify()
    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // API
    ////////////////////////////////////////////////////////public method///////////////////////////////////////////////
    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        // if the size == capacity, array is full now, need to enlarge the original array
        if (size == array.length) {
            System.out.println("enlarging");
            int[] largeArray = new int[size * 2];
            copy(array, largeArray);
            array = largeArray;
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void update(int newValue, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of boundary");
        }
        int original = array[index];
        array[index] = newValue;
        if (original < array[index]) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
    }

    ////////////////////////////////////////////// private method///////////////////////////////////////////////////////
    private void heapify() {
        // the range of indices need to perform percolateDown is [0, (size - 2) / 2]
        for (int i = (size - 2) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int index) {
        // check the validation of index
        // last index' parent = (size - 2) / 2
        while (index <= (size - 2) / 2) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;

            // smallest among left and right children
            int swapCandidate = leftChildIndex;
            if (rightChildIndex <= size - 1 && array[rightChildIndex] < array[leftChildIndex]) {
                swapCandidate = rightChildIndex;
            }

            // swap if necessary
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            } else {
                break;
            }
            index = swapCandidate;
        }
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, index, parentIndex);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void copy(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // test
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(9);
        minHeap.offer(-1);
        minHeap.offer(100);
        minHeap.offer(100);
        minHeap.offer(13);
        minHeap.offer(54);
        minHeap.offer(-33);
        minHeap.offer(1111);
        minHeap.offer(100);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.peek());
            minHeap.poll();
        }
    }
}
