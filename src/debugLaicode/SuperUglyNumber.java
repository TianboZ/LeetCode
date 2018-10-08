package debugLaicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        // use hash set to deduplicate
        Set<Long> set = new HashSet<>();

        // use minheap to get nth ugly number
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // initial
        minHeap.add(1l);

        for (int i = 1; i < n; i++) {
            // expand
            long min = minHeap.poll();
            // generate
            for (int j = 0; j < primes.length; j++) {
                if (set.add(min * primes[j])) {
                    minHeap.add(min * primes[j]);
                }
            }
        }
        return minHeap.poll().intValue();
    }
}


// time o(n*log(n*k))   k is primes.length
// space o(nk)