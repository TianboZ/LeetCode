package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

/*

find the shortest path
for all empty room to any gate <==> for any gate to all empty room
time O(v + e) v = m * n   e = m * n * 4

*/
public class WallsAndGates {
    private static class Cell {
        int x; int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int EMPTY = Integer.MAX_VALUE;


    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();
        int level = 1;

        // initial
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
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
                    int nx = curr.x + dx[k];
                    int ny = curr.y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && !visited[nx][ny] && rooms[nx][ny] == EMPTY) {
                        q.offer(new Cell(nx, ny));
                        visited[nx][ny] = true;
                        rooms[nx][ny] = level;
                    }
                }
            }
            level++;
        }
    }
}