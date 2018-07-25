package debugLaicode;

public class PaintFence {
    public int numWays(int n, int k) {
        if (n ==0 || k == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }
        // Write your solution here
        int[] dp = new int[n];
        // dp[i] represnet number of ways to paint 0th to ith fences

        // base-case
        dp[0] = k;
        dp[1] = k * (k - 1) + k;
        // inductive rule
        for (int i = 2; i < n; i++) {
            // case1: adjacent same
            int tmpt1 = dp[i - 2] * (k - 1);

            // case2: adjacent not same
            int tmpt2 = dp[i - 1] * (k - 1);

            dp[i] = tmpt1 + tmpt2;
        }

        return dp[dp.length - 1];
    }
}
