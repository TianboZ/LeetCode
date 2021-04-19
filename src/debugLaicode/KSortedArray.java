package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KSortedArray {
    public int[] ksort(int[] array, int k) {
        // Write your solution here
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (int n : array) {
            pq.offer(n);
            if (pq.size() > k + 1) {
                array[i] = pq.poll();
                i++;
            }
        }

        // renaming
        while (!pq.isEmpty()) {
            array[i] = pq.poll();
            i++;
        }
        return array;
    }
}
