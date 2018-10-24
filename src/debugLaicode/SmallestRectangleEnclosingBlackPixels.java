package debugLaicode;

import java.util.*;

public class SmallestRectangleEnclosingBlackPixels {
    int left = Integer.MAX_VALUE;
    int up = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;
    int bottom = Integer.MIN_VALUE;

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int minArea(char[][] image, int x, int y) {
        // return bfs(image, x, y);
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, x, y, visited);
        return (right - left + 1) * (bottom - up + 1);
    }
    private int bfs(char[][] image, int x, int y) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Cell> q = new LinkedList<>();

        // initial
        q.add (new Cell(x, y));
        visited[x][y] = true;

        // terminate
        while (!q.isEmpty()) {
            // expand
            Cell curr =  q.poll();
            int currx = curr.x;
            int curry = curr.y;

            // right bottom conner
            right = Math.max(right, currx);
            bottom =  Math.max(bottom, curry);

            // left bottom conner
            left = Math.min(left, currx);
            up = Math.min(up, curry);

            // generate
            for (int i = 0; i < 4; i++) {
                int newx = dx[i] + currx;
                int newy = dy[i] + curry;
                if (newx >= 0 && newx < image.length && newy >= 0 && newy < image[0].length
                        && !visited[newx][newy]
                        && image[newx][newy] == '1') {
                    q.add(new Cell(newx, newy));
                    visited[newx][newy] = true;
                }
            }
        }

        return (right - left + 1) * (bottom - up + 1);

    }

    // given board, and start from x y, traverse all unvisited connected area
    private void dfs(char[][] image, int x, int y, boolean[][] visited) {
        // base-case
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        if (image[x][y] != '1') {
            return;
        }
        // resurrive rule
        visited[x][y] = true;

        // right bottom conner
        right = Math.max(right, x);
        bottom =  Math.max(bottom, y);

        // left bottom conner
        left = Math.min(left, x);
        up = Math.min(up, y);

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            dfs(image, newx, newy, visited);
        }

    }
    class  Cell {
        int x;
        int y;
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
