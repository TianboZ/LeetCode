package practice;

import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) throws IllegalAccessException {
        if (array == null || array.length == 0) {
            throw new IllegalAccessException("input cannot be null or empty");
        }
        this.array = array;
        this.size = array.length;
        heapify();
    }
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    private void percolateDown(int index) {
        // check the validation of index
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

    private void percolateUp(int index)

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

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
}
