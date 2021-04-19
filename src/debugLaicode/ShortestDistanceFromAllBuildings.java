package debugLaicode;

/*
shortest path sum

# of 1: k
# of 0: mn - k

sol1:
for each 0 point:
    run BFS algorithm to find shortest path to all 1, find the smallest sum of distance

time: O(# of 0 * BFS)  -->  O(# of 0  *  (V + E))   --> O((mn - k) * mn)

time of BFS: O(V + E)  V==m*n  E = 4 * V^2 = 4*m*n



sol2:
for each 1 point:
    apply BFS algorithm to find shortest path to all 0,

time: O(# of 1 * BFS)  --> O(k * mn)



*/

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[][] sum;
    int[][] count; // count[i][j] represent how many 1 can reach 0
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        sum = new int[m][n];
        count = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                }
            }
        }

        // find smallest sum
        int k = 0;   // # of houses
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) k++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && count[i][j] == k) {
                    min = Math.min(min, sum[i][j]);
                }

            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] g, int i, int j) {
        int m = g.length;
        int n = g[0].length;
        boolean[][] visit = new boolean[m][n];

        Queue<Cell> q = new LinkedList<>();
        int level = 1;

        // initial
        q.offer(new Cell(i, j));
        visit[i][j]  = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                // expand
                Cell curr = q.poll();

                // generate
                for (int l = 0; l < 4; l++) {
                    int x = dx[l] + curr.x;
                    int y = dy[l] + curr.y;
                    boolean inBound = x >= 0 && y >= 0 && x < m && y < n;
                    if (inBound && !visit[x][y] && g[x][y] == 0) {
                        visit[x][y] = true;
                        sum[x][y] += level;
                        count[x][y] += 1;
                        q.offer(new Cell(x, y));
                    }
                }
            }
            level++;
        }
    }

}
