package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KDiffSortedArray {
    public void sortKDiff(int[] arr, int k) {
        // sanity check
        Queue<Integer> minHeap = new PriorityQueue<>();

        // initial: put k+1 elements into minheap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        // determint the arr[i] one by one
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
            minHeap.offer(arr[i + k + 1]);
        }
    }


}
