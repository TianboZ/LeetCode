package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;


/*
find shortest path for all 1 point to any 0 point <==> shortest path for any 0 point to all 1 point
BFS time O(v+e) v = m * n   e = m * n * 4

*/
public class ZeroOneMatrix {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;

        int level = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        // initial
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // terminate condition
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                Cell curr = q.poll();

                // generate
                for (int k = 0; k < 4; k++) {
                    int xx = curr.x + dx[k];
                    int yy = curr.y + dy[k];

                    boolean inBound = xx >= 0 && yy >= 0 && xx < m && yy < n;
                    if (inBound && !visited[xx][yy]) {
                        visited[xx][yy] = true;
                        q.offer(new Cell(xx, yy));
                        matrix[xx][yy] = level + 1;
                    }
                }
            }
            level++;
        }

        return matrix;
    }

}
