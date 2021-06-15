package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KDiffSortedArray {
    public int[] ksort(int[] array, int k) {
        // sanity check
        // todo

        Queue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);

            if (pq.size() > k + 1) {
                res[j] = pq.poll();
                j++;
            }
        }

        while (!pq.isEmpty()) {
            res[j] = pq.poll();
            j++;
        }

        return res;
    }


}
