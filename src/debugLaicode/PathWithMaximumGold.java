package debugLaicode;

public class PathWithMaximumGold {
    boolean[][] visit;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, dfs(i, j, grid));
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] g) {
        // base case
        if (visit[i][j]) return 0;

        // recursive rule
        visit[i][j] = true;
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            boolean inBound = x >= 0 && y >= 0 && x < g.length && y < g[0].length;
            if (inBound && g[x][y] != 0) {
                max = Math.max(max, dfs(x, y, g));
            }
        }
        max += g[i][j];
        visit[i][j] = false;
        return max;
    }
}
