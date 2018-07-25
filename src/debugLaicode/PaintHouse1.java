package debugLaicode;

public class PaintHouse1 {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        // Write your solution here
        int[][] dp = new int[costs.length][3];

        // base-case
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // inductive rule
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }

        return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }
}
