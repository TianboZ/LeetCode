package debugLaicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        Set<Long> visited = new HashSet<>();
        Queue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1l);
        visited.add(1l);
        for (long i = 1; i < n; i++) {
            // expand
            long tmp = minHeap.poll();
            // generate
            if (visited.add(tmp * 2)) {
                minHeap.add(tmp * 2);
            }
            if (visited.add(tmp * 3)) {
                minHeap.add(tmp * 3);
            }
            if (visited.add(tmp * 5)) {
                minHeap.add(tmp * 5);
            }
        }
        return minHeap.poll().intValue();

    }
}

// time o(nlogn)
// space o(n)
