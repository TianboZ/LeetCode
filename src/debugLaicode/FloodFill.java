package debugLaicode;


import java.util.LinkedList;
import java.util.Queue;

/*
* sol1: BFS
*
* sol2: DFS, mark visited 1
* */
public class FloodFill {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    class Cell {
        int x;
        int  y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;

        Queue<Cell> q = new LinkedList<>();
        // initial
        q.offer(new Cell(sr, sc));
        image[sr][sc] = newColor;

        // terminate
        while (!q.isEmpty()) {
            Cell curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == oldColor ) {
                    q.offer(new Cell(nx, ny));
                    image[nx][ny] = newColor;
                }
            }
        }
        return image;
    }
}
