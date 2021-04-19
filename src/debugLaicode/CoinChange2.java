package debugLaicode;


/*
* we can use DFS to resolve it
* for each coin, say it is 5, then there are 5 * 0, 5 * 1.... ways to take
* terminate DFS when
* - sum == target
* - used all different coins
*
* complexity:
* time o(branch ^ n)
* space o(n)
*
* branch is branch factor
* n is # of coins
*
* */
public class CoinChange2 {
    int count = 0;
    public int change(int amount, int[] coins) {
        dfs(0, amount, coins, 0);
        return count;
    }

    private void dfs(int sum, int target, int[] coins, int i) {
        // basecase
        if (i == coins.length) {
            if (sum == target) count++;
            return;
        }
        // recursive rule
        int coin = coins[i];
        for (int j = 0; j * coin + sum <= target; j++) {
            dfs(sum + j * coin, target, coins, i + 1);
        }
    }
}
