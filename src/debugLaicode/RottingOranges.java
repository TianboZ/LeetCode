package debugLaicode;

import java.util.*;

public class RottingOranges {
    private static class Cell {
        int x; int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();
        int level = -1;
        int fresh = 0;

        // initial
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Cell(i, j));
                    //visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

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
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n
                            //&& !visited[nx][ny]
                            &&  grid[nx][ny] == 1) {
                        q.offer(new Cell(nx, ny));
                        //visited[nx][ny] = true;
                        grid[nx][ny] = 2;
                        fresh--;
                    }
                }
            }
            level++;
        }
        return fresh == 0 ? level : -1;
    }
}


// time o(m * n)  space o(1)