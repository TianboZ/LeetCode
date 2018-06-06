package debugLaicode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// try to find the k-th smallest element in unsorted array
public class KSmallestInUnsortedArray {
    // online algorithm, use maxHeap
    public int maxHeap(int[] arr, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // initial
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }
        // time o(klogk)

        // add rest elements into max heap
        for (int i = k; i < arr.length; i++) {
            if (!maxHeap.isEmpty() && arr[i] >= maxHeap.peek()) {
                continue;
            } else {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        // time o((n-k)*logk)


        // space o(k)
        return maxHeap.peek();
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
        int[] arr = {10, 9, 8, 3, -1, 100, -20, -20, -20};
        KSmallestInUnsortedArray kSmallestInUnsortedArray = new KSmallestInUnsortedArray();
        int res = kSmallestInUnsortedArray.maxHeap(arr, 3); // should return -20
        System.out.println(res);
    }
}
