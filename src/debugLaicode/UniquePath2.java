package debugLaicode;

public class UniquePath2 {
    Integer[][] memo;
    int[][] grid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        grid = obstacleGrid;

        memo = new Integer[m][n];
        return dfs(0, 0, m, n);
    }
    private int dfs(int i, int j, int m, int n) {
        // base case
        Integer res = memo[i][j];
        if (res != null) return res;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] == 1 ? 0 : 1; // bottom right is obstacle, stupid!
        }
        if (grid[i][j] == 1) return 0;
        // recursive rule

        // case1: go right
        int cnt = 0;
        if (j + 1 < n && grid[i][j + 1] != 1) {
            cnt += dfs(i, j + 1, m, n);
        }
        //case2: go down
        if (i + 1 < memo.length && grid[i + 1][j] != 1) {
            cnt += dfs(i + 1, j, m, n);
        }

        memo[i][j] = cnt;
        return cnt;
    }
}
