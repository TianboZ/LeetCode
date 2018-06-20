package debugLaicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestWithOnly357AsFactor {
    public long kth(int k) {
        // Write your solution here.
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        // initial
        minHeap.offer(5 * 7 * 3L);
        visited.add(5 * 7 * 3L);

        // terminte
        for (int i = 1; i <= k - 1; i++) {
            // expend
            long curr = minHeap.poll();
            // generate rule
            // case1
            if (visited.add(3 * curr)) {
                minHeap.offer(3 * curr);
            }
            // case2
            if (visited.add(5 * curr)) {
                minHeap.offer(5 * curr);
            }
            // case3
            if (visited.add(7 * curr)) {
                minHeap.offer(7 * curr);
            }
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        KthSmallestWithOnly357AsFactor kthSmallestWithOnly357AsFactor = new KthSmallestWithOnly357AsFactor();
        long res = kthSmallestWithOnly357AsFactor.kth(30);
        System.out.println(res);
    }
}
