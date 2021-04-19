package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        // Write your solution here
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;

        if (grid == null || n == 0 || m == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    //bfs(grid, visited, i, j);
                    dfs(grid, visited, i, j);
                }
            }
        }
        return cnt;
    }



    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Point> q = new LinkedList<>();
        // initial
        q.offer(new Point(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            // expand
            Point curr = q.poll();

            // generate
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                boolean isInBound
                        = nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length;

                if (isInBound && grid[nx][ny] == '1' && !visited[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // sol2: DFS1
    // mark visited 1, find all reachable nodes
    private void dfs(char[][] gird, boolean[][] visit, int i, int j) {
        // base case
        if (visit[i][j]) return;

        // recursive rule
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            boolean inbound = x >= 0 && y >= 0 && x < gird.length && y < gird[0].length;
            if (inbound && gird[x][y] == '1' && !visit[x][y]) dfs(gird, visit, x, y);
        }
    }
}
