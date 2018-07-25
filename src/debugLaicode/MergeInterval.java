package debugLaicode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MergeInterval {


    private class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int length(List<Interval> intervals) {
        // Write your solution here.
        Collections.sort(intervals, new MyComparator());

        List<Interval> merged = new ArrayList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }

        return 0;
    }
    // sort based on start
    private class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start == b.start) {
                return 0;
            }
            return a.start < b.start ? -1: 1;
        }
    }
}
