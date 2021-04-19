package debugLaicode;
import java.util.*;
/*
* BFS and DFS both ok
*
* */
public class MaxAreaOfIsland {
    boolean[][] visit;
    int max = 0;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int area = 0;

    class Cell {
        int x;
        int y;
        Cell(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    // sol1
                    //bfs(grid, i, j);

                    // sol2
                    area = 0;
                    dfs(grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }
    // sol2: dfs1
    private void dfs(int[][] grid, int i, int j) {
        // base case

        // recursive rule
        visit[i][j] = true;
        area++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            boolean inBound = x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
            if (inBound && !visit[x][y] && grid[x][y] == 1) {
                visit[x][y] = true;
                dfs(grid, x, y);
            }
        }
    }


    // sol1: bfs
    private void bfs(int[][] grid, int i, int j) {
        Queue<Cell> q = new LinkedList<>();

        // initial
        q.offer(new Cell(i, j));
        visit[i][j]= true;
        int area = 1;

        // terminate
        while (!q.isEmpty()) {
            Cell curr = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = curr.x + dx[k];
                int y = curr.y + dy[k];

                boolean inBound = x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
                if (inBound && !visit[x][y] && grid[x][y] == 1) {
                    area++;
                    q.offer(new Cell(x, y));
                    visit[x][y] = true;
                }
            }
        }

        // update global max
        max  = Math.max(max, area);

    }
}
