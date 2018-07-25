package debugLaicode;


import java.util.Arrays;
import java.util.Comparator;

public class MaxWeightsSumOfIntervals {
    public int maxWeightSum(IntervalW[] intervals) {
        // Write your solution here.
        Arrays.sort(intervals, new MyComparator());
        int[] dp = new int[intervals.length];
        // dp[i] represent from interval 0 to i, the max weight
        // can get, includes i-th interval
        dp[0] = intervals[0].weight;

        int max = dp[0];

        // inductive rule
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = intervals[i].weight;
            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + intervals[i].weight);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    // sort based on end time
    private class MyComparator implements Comparator<IntervalW> {
        @Override
        public int compare(IntervalW i1, IntervalW i2) {
            if (i1.end == i2.end) {
                return 0;
            }
            return i1.end < i2.end ? -1 : 1;
        }
    }
    private class IntervalW {
        public int start;
        public int end;
        public int weight;
        public IntervalW(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
