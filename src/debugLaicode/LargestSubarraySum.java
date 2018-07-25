package debugLaicode;

public class LargestSubarraySum {
    public int largestSum(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return -1;
        }
        // dp[i] represents the largest subarray sum
        // including index i
        int[] dp = new int[array.length];

        // base-case
        dp[0] = array[0];
        int max = array[0];

        // inductive rule
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int[] largestSum1(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return new int[] {};
        }

        int left = 0;
        int solLeft = 0;
        int solRight = 0;

        // dp[i] represents the largest subarray sum
        // including index i
        int[] dp = new int[array.length];

        // base-case
        dp[0] = array[0];
        int max = array[0];

        // inductive rule
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] + array[i] < array[i]) {
                left = i; // new begin of left bound
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            // update global max
            if (dp[i] > max) {
                max = dp[i];
                solRight = i;
                if (left <= i) {
                    solLeft = left;
                }
            }
        }
        return new int[] {max, solLeft, solRight};
    }
}
