package debugLaicode;

public class uniquePath3 {
    boolean[][] visit;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int m;
    int n;
    int total;
    int empty;
    int dis;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) dfs(i, j, grid);
            }
        }
        return total;
    }

    private void dfs(int i, int j, int[][] g) {
        if (visit[i][j]) return;
        //System.out.println(dis);
        if (g[i][j] == 2) {
            if (dis == empty) {
                //System.out.println(dis);
                total++;
            }
            return;
        }

        visit[i][j] = true;
        if (g[i][j] == 0) dis++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            boolean isInBound = x >= 0 && y >= 0 && x < m && y < n;
            if (isInBound && g[x][y] != -1 )  {
                dfs(x, y, g);
            }
        }

        visit[i][j] = false;
        if (g[i][j] == 0) dis--;
    }
}
