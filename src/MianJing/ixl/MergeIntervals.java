package MianJing.ixl;
//import Java.util.*;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort intervals by start, increasing order

        List<int[]> res = new ArrayList<>();

        // initial
        res.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = res.get(res.size() - 1);
            if (curr[0] > prev[1]) {
                // no overlap
                res.add(curr);
            } else {
                // overlap
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }

        int[][] ans = new int[res.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
