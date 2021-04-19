package MianJing.ixl.onsite;

public class UniquePaths {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return dfs(0, 0, m, n);
    }
    private int dfs(int i, int j, int m, int n) {
        // base case
        Integer res = memo[i][j];
        if (res != null) return res;
        if (i == m - 1 && j == n - 1) return 1;

        // recursive rule
        // case1: go right
        int cnt = 0;
        if (j + 1 < n) {
            cnt += dfs(i, j + 1, m, n);
        }
        //case2: go down
        if (i + 1 < memo.length) {
            cnt += dfs(i + 1, j, m, n);
        }

        memo[i][j] = cnt;
        return cnt;
    }
}
