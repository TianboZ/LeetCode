package debugLaicode;

import java.util.*;

/*
solution:
sort intervals by start
iterate each interval
case1: overlap with prev
    next.start <= curr.end
        curr.end = Math.max(curr.end, next.end)
case2: not overlap with prev
    curr.end < next.start
        put curr interval into result
        curr = next;


time O(nlogn)   n is intervals length

*/

class MergeInterval {
    private class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<>();

        // sort by start
        //intervals.sort(new CP());
        intervals.sort((i1, i2) -> i1.start - i2.start); // sort by start, increasing order
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i : intervals) {
            if (i.start <= end) {
                // overlap
                end = Math.max(end, i.end);
            } else {
                // not overlap
                res.add(new Interval(start, end));

                // start from a new interval
                start = i.start;
                end = i.end;
            }
        }

        // add the last interval
        res.add(new Interval(start, end));
        return res;
    }
    class CP implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start == i2.start) return 0;
            return i1.start < i2.start ? -1: 1; // sort by start, increasing order
        }
    }
}
class Solution2 {
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
