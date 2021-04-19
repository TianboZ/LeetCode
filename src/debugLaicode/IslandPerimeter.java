package debugLaicode;

public class IslandPerimeter {
    int length = 0;  // Perimeter

    boolean[][] visit;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return length;
    }

    // traverse graph, find connected area
    private void dfs(int[][] grid, int i, int j) {
        // base case
        if (visit[i][j]) return;


        // recursive rule
        visit[i][j] = true;
        // count perimeter for current position
        length += countPerimeter(grid, i, j);

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j  + dy[k];

            boolean inBound = x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;

            if (inBound && grid[x][y] == 1 && !visit[x][y]) {
                dfs(grid, x, y);
            }
        }
    }

    private int countPerimeter(int[][] grid, int i, int j) {
        int len = 0;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j  + dy[k];

            boolean inBound = x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
            if (inBound) {
                if (grid[x][y] == 0) {
                    len++;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
