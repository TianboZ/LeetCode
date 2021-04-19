package debugLaicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        Set<Integer> visit = new HashSet<>();
         Queue<Integer> pq = new PriorityQueue<>();

         pq.offer(1);

         int cnt = 0;

         while (!pq.isEmpty()) {
             int curr = pq.poll();
             cnt++;
             if (cnt == n) {
                 return (int)curr;
             }

             if (visit.add(curr * 2)) {
                 pq.offer(curr * 2);
             }
             if (visit.add(curr * 3)) {
                 pq.offer(curr * 3);
             }
             if (visit.add(curr * 5)) {
                 pq.offer(curr * 5);
             }
         }
         return -1;
    }
}

// time o(nlogn)
// space o(n)
