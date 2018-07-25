package debugLaicode;

public class maxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here
        // dp[i] represent the max product to cut length of i rop
        int[] dp = new int[length + 1];

        // base-case
        dp[0] = 1;
        dp[1] = 1;

        // inductive rule
        for (int i = 2; i <= length; i++) {
            int curMax = -1;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(dp[j], j) * (i - j));
            }
            dp[i] = curMax;
        }

        return dp[length];
    }
}
