package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

/*

find the shortest path
for all empty room to any gate <==> for any gate to all empty room
time O(v + e) v = m * n   e = m * n * 4

*/
public class WallsAndGates {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        // sanity check
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        Queue<Cell> q = new LinkedList<>();
        int level = 0;

        // initial
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // terminaite
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                Cell curr = q.poll();
                // generate
                for (int k = 0; k < 4; k++) {
                    int newx = curr.x + dx[k];
                    int newy = curr.y + dy[k];
                    if (newx >= 0 && newy >= 0 && newx < rooms.length && newy < rooms[0].length && !visited[newx][newy]) {
                        // not obstacle
                        if (rooms[newx][newy] != -1 ) {
                            q.offer(new Cell(newx, newy));
                            visited[newx][newy] = true;
                        }
                        // empty room
                        if (rooms[newx][newy] == INF) {
                            rooms[newx][newy] = level + 1;
                            visited[newx][newy] = true;
                        }
                    }
                }
            }
            level++;
        }
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