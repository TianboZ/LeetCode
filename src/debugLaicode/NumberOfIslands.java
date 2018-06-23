package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int numIslands(char[][] grid) {
        // Write your solution here
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Point> q = new LinkedList<>();
        // initial
        q.offer(new Point(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            // expand
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            // generate
            for (int k = 0; k < 4; k++) {
                x = x + dx[k];
                y = y + dy[k];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                        && grid[x][y] == '1' && !visited[x][y]) {
                    q.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
