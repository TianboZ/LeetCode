package debugLaicode;

import java.util.*;

/*
shortest path sum
sol1:
for each 0 point:
    one initial state to all goals(1) shortest path problem

time: O(# of 0 * BFS)

sol2:
for each 1 point:
    one initial state to all goals(0) shortest path problem

time: O(# of 1 * BFS)

time of BFS: O(V + E)  V==m*n  E = 4 * V^2 = 4*m*n
assume that # of 1 is smaller

*/

public class ShortestDistanceFromAllBuildings {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {

        int count = 0; // count houses
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) count++;
            }
        }

        int min = Integer.MAX_VALUE;
        // for each 0 point
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int res = bfs(grid, i, j, count);
                    if (res == 0) continue; // this point cannot reach to all houses
                    min = Math.min(min, res);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // return path sum from 0 point to all 1 point
    private int bfs(int[][] m, int x, int y, int count) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        Queue<Cell> q = new LinkedList<>();
        int dis = 0;
        int total = 0;

        // initial
        q.offer(new Cell(x, y));
        visited[x][y] = true;

        // terminiate
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                Cell curr = q.poll();

                // generate
                for (int k = 0; k < 4; k++) {
                    int newx = curr.x + dx[k];
                    int newy = curr.y + dy[k];

                    if (newx >= 0 && newy >=0 && newx < m.length && newy <m[0].length && !visited[newx][newy]) {
                        // empty land
                        if ( m[newx][newy] == 0) {
                            q.offer(new Cell(newx, newy));
                            visited[newx][newy] = true;
                        }
                        // house
                        if ( m[newx][newy] == 1) {
                            total = total + dis + 1;
                            visited[newx][newy] = true;
                            count--; // every time reach a house, count--
                        }
                    }
                }
            }
            dis++;
        }
        return count == 0? total : 0;
    }
    class Cell{
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
