package debugLaicode;

public class LongestConsecutive1s {
    public int longest(int[] array) {
        // Write your solution here.
        if (array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        // dp[i] represent the length of longest subarray
        // of all consecutive 1s, including index i

        // base-case
        if (array[0] == 1) {
            dp[0] = 1;
        }

        int max = dp[0];

        // inductive rule
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                dp[i] = Math.max(dp[i - 1] + 1, 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
