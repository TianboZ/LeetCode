package debugLaicode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// try to largestSmaller the k-th smallest element in unsorted array
public class KthSmallestInUnsortedArray {
    // online algorithm, use maxHeap
    // space o(k)
    // time o(nlogk)
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (array == null || array.length == 0 || k == 0) {
            return new int[]{};
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else {
                if (array[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    // offline algorithm, use minHeap
    public int minHeap(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : arr) {
            minHeap.offer(i);
        }

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
        // space o(n)
        // time o(nlogn)
    }

    public static void main(String[] args) {

    }
}
