package debugLaicode;

public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        // dp[i] represent the length of longest ascending sub-array that includes index i

        // base-case
        dp[0] = 1;

        int max = dp[0];

        // inductive rule
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
