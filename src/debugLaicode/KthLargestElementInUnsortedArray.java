package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInUnsortedArray {
    public int findKthLargest(int[] nums, int k) {
        // Write your solution here
        // create a min heap
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] <= pq.peek()) {
                continue;
            } else {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInUnsortedArray kthLargestElementInUnsortedArray = new KthLargestElementInUnsortedArray();
        int[] arr = {3,2,1,5,6,4};
        kthLargestElementInUnsortedArray.findKthLargest(arr, 2);
    }
}
