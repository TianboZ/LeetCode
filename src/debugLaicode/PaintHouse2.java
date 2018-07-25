package debugLaicode;

public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        // Write your solution here
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        // Write your solution here
        int k = costs[0].length;
        int[][] dp = new int[costs.length][k];

        // base-case
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        // inductive rule
        // houses
        for (int i = 1; i < dp.length; i++) {
            // colors
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int h = 0; h < k; h++) {
                    if (h == j) {
                        // skip the same color of adjacent rows
                        continue;
                    } else {
                        min = Math.min(min, dp[i - 1][h]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }
}
