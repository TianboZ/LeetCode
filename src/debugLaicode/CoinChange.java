package debugLaicode;

public class CoinChange {
    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        dfs(0, amount, coins, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    // k is # of coins used so far
    private void dfs(int sum, int target, int[] coins, int i, int k) {
        // basecase
        if (i == coins.length) {
            if (sum == target) min = Math.min(min, k);
            return;
        }
        // recursive rule
        int coin = coins[i];
        for (int j = 0; j * coin + sum <= target; j++) {
            dfs(sum + j * coin, target, coins, i + 1, k + j);
        }
    }
}
