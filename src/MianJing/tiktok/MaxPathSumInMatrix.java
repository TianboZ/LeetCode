package MianJing.tiktok;

public class MaxPathSumInMatrix {
    // https://www.geeksforgeeks.org/maximum-path-sum-matrix/

    Integer[][] memo;
    int[] dy = {-1, 0, 1};
    int[] dx = {1, 1, 1};

    public int maxPathSumFromTopToBottom(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Integer[m][n];

        int max  = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            max = Math.max(max, dfs(grid, 0, j));
        }
        System.out.println(max);
        return max;
    }
    private int dfs(int[][] m, int i, int j) {
        // basecase
        Integer val = memo[i][j];
        if (val != null) return val;

        // recursive rule
        memo[i][j] = m[i][j];
        int max = Integer.MIN_VALUE;

        for (int k = 0; k < 3; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            boolean inBound = x >= 0 && y >= 0 && x < m.length && y < m[0].length;
            if (inBound) {
                max = Math.max(max, dfs(m, x, y));
            }
        }

        memo[i][j] = max == Integer.MIN_VALUE ?  m[i][j] : m[i][j] + max;
        return memo[i][j];
    }

    public static void main(String[] args) {
        MaxPathSumInMatrix sol = new MaxPathSumInMatrix();
        int[][] matrix = {
                {1 , 2,  3},
                {9,  8 , 7},
                {4 , 5,  6}
        };
        sol.maxPathSumFromTopToBottom(matrix);
    }
}
