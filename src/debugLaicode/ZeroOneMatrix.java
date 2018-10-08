package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    int[] dx = {-1,1,0,0};
    int[] dy = {0, 0,-1,1};

    // sol1:
    // naive

    /*
    for each 1 point, run BFS to find the shortest distance to 0 point, then update 1 point value
    */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int dis = bfs(i, j, matrix);
                    matrix[i][j] = dis;
                }

            }
        }
        return matrix;
    }
    private int bfs(int x, int y, int[][] m) {
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[m.length][m[0].length];
        // initial
        q.offer(new Cell(x, y));
        visited[x][y] = true;
        int dis = 0;

        // terminate condiiton
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                Cell curr = q.poll();
                //System.out.println("x :" + x + " y" + y);
                if (m[curr.x][curr.y] == 0) {
                    //ystem.out.println(dis);
                    return dis;
                }

                // generate
                for (int k = 0; k < 4; k++) {
                    int newx = curr.x + dx[k];
                    int newy = curr.y + dy[k];

                    if (newx >= 0 && newy >= 0 && newx < m.length && newy < m[0].length && !visited[newx][newy]) {
                        visited[newx][newy] = true;
                        q.offer(new Cell(newx, newy));
                    }
                }
            }
            dis++;
        }
        return dis;
    }
    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // time o(mn * (v + e))   v = mn    e = mn * 4    --> total time o(mn(5mn)) == o(5m^2 * n ^ 2) == o(m^2 * n^2)


    // sol2:
    public int[][] updateMatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = dfs(i, j, matrix, visited, dis);
                }
            }
        }
        return matrix;
    }
    // find the shortest path from current point to 0 point
    private int dfs(int x, int y, int[][] m, boolean[][] visited, int[][] dis) {
        // base-case
        if (dis[x][y] > 0) return dis[x][y];
        if (m[x][y] == 0) return 0;
        if (visited[x][y]) return Integer.MAX_VALUE;

        // recursive rule
        visited[x][y] = true;
        dis[x][y] = Integer.MAX_VALUE;
        for (int i = 0; i<4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx >= 0 && newy >= 0 && newx< m.length && newy < m[0].length) {
                dis[x][y] = Math.min(dis[x][y], dfs(newx, newy, m, visited, dis) + 1);
            }
        }
        visited[x][y] = false;
        return dis[x][y];
    }
}
