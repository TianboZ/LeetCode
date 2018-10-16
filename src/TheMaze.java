import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check

        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        // initial
        q.offer(new Cell(start[0], start[1]));
        visited[start[0]][start[1]] = true;;

        // terminate
        while (!q.isEmpty()) {
            // expand
            Cell curr = q.poll();
            if (curr.x == destination[0] && curr.y == destination[1]) return true;
            // generate
            for (int k = 0; k < 4; k++) {
                int xx = curr.x;
                int yy = curr.y;

                while (xx >= 0 && xx < maze.length && yy >= 0 && yy < maze[0].length && maze[xx][yy] != 1) {
                    yy = yy + dy[k];
                    xx = xx + dx[k];
                }
                if (yy != curr.y || xx != curr.x) {
                    yy = yy - dy[k];
                    xx = xx - dx[k];
                    if (!visited[xx][yy]) {
                        q.offer(new Cell(xx, yy));
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        return false;

    }
    class Cell {
        int x;
        int y;
        Cell(int x ,int y) {
            this.x = x;
            this.y = y;
        }
    }
}