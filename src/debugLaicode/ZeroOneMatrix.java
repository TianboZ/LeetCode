package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;


/*
find shortest path for all 1 point to any 0 point <==> shortest path for any 0 point to all 1 point
BFS time O(v+e) v = m * n   e = m * n * 4

*/
public class ZeroOneMatrix {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[][] updateMatrix(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;

        int dis = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Cell> q = new LinkedList<>();
        // intial
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
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
                if (matrix[curr.x][curr.y] == 1) {
                    matrix[curr.x][curr.y] = dis;
                }
                // generate
                for (int k = 0; k < 4; k++) {
                    int newx = curr.x + dx[k];
                    int newy = curr.y + dy[k];
                    if (newx >= 0 && newy >= 0 && newx < matrix.length && newy < matrix[0].length && !visited[newx][newy]) {
                        q.offer(new Cell(newx, newy));
                        visited[newx][newy] = true;
                    }
                }
            }
            dis++;
        }

        return matrix;
    }
    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
