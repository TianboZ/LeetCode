package debugLaicode;

public class MinimumPathSum {
    Integer[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Integer[m][n];

        return dfs(0, 0, grid);
    }
    private int dfs(int i, int j, int[][] g) {
        Integer val = memo[i][j];
        if (val != null) return val;

        // recursive rule
        memo[i][j] = g[i][j];

        int down = Integer.MAX_VALUE;
        if (i + 1 < g.length) {
            down = dfs(i + 1, j, g);
        }

        int right = Integer.MAX_VALUE;
        if (j + 1 < g[0].length) {
            right = dfs(i, j + 1, g);
        }

        int min = Math.min(right, down);
        if (min == Integer.MAX_VALUE) min = 0;

        memo[i][j] = min + g[i][j];
        return memo[i][j];

    }
}
