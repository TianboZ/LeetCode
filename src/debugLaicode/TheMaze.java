package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;
/*
*
* solution:
* dfs
* bfs
*
* */
public class TheMaze {

    boolean[][] visit;
    boolean hit;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int[][] maze;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        visit = new boolean[m][n];
        this.maze = maze;
        dfs(start[0], start[1], destination);

        return hit;
    }
    private void dfs(int i, int j, int[] end) {
        // baes case
        if (visit[i][j] || hit) return;

        if(i == end[0] && j == end[1]) {
            hit = true;
            return;
        }

        // recursive rule
        visit[i][j] = true;

        for (int k = 0; k < 4; k++) {  // right, left, down, up
            int ii = i + dx[k];
            int jj = j + dy[k];

            while (inbound(ii, jj) && maze[ii][jj] == 0) {
                ii += dx[k];
                jj += dy[k];
            }
            // go back 1 step
            ii -= dx[k];
            jj -= dy[k];

            dfs(ii, jj, end);
        }
    }

    private boolean inbound(int i, int j) {
        return i >= 0 && j >= 0 && i < maze.length && j < maze[0].length;
    }


    // 2018

    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        // sanity check

        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        // initial
        q.offer(new Cell(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        // terminate
        while (!q.isEmpty()) {
            // expand
            Cell curr = q.poll();
            if (curr.x == destination[0] && curr.y == destination[1]) return true;
            // generate
            for (int k = 0; k < 4; k++) {
                int xx = curr.x;
                int yy = curr.y;

                while (xx >= 0 && xx < maze.length && yy >= 0 && yy < maze[0].length && maze[xx][yy] != 1) {
                    yy = yy + dy[k];
                    xx = xx + dx[k];
                }
                if (yy != curr.y || xx != curr.x) {
                    yy = yy - dy[k];
                    xx = xx - dx[k];
                    if (!visited[xx][yy]) {
                        q.offer(new Cell(xx, yy));
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        return false;

    }
    class Cell {
        int x;
        int y;
        Cell(int x ,int y) {
            this.x = x;
            this.y = y;
        }
    }
}