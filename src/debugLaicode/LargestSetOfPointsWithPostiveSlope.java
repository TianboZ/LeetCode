package debugLaicode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPointsWithPostiveSlope {
    public int largest(Point[] points) {
        // Write your solution here.
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new MyComparator());
        int res = helper(points);
        return res == 1 ? 0 : res;
    }

    // find the length of longest ascending subsequence
    private int helper(Point[] arr) {
        // dp[i] represents the length of longest
        // ascending subsequence, including arr[i]
        int[] dp = new int[arr.length];
        int globalMax = 1;

        // base-case
        dp[0] = 1;

        // inductive rule
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i].y > arr[j].y) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, dp[i]);
        }
        return globalMax;
    }

    private class MyComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.x == p2.x) {
                return 0;
            }
            return p1.x < p2.x ? -1 : 1;
        }
    }

    private class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
