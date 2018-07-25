package debugLaicode;


import java.util.*;

public class PutChairI {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public List<Integer> putChair(char[][] gym) {
        if (gym.length == 0 || gym[0].length == 0) {
            return null;
        }
        // initial cell
        Cell[][] cell = new Cell[gym.length][gym[0].length];
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                cell[i][j] = new Cell();
            }
        }

        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (gym[i][j] == 'E') {
                    bfs(gym, cell, i, j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (gym[i][j] == 'C') {
                    int sum = getSum(cell[i][j].path);
                    if (sum < min) {
                        min = sum;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(x);
        res.add(y);
        //return res.size() > 0 ? res : null;
        return res;
    }
    private int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum = sum + i;
        }
        return sum;
    }
    private void bfs(char[][] gym, Cell[][] cell, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        // initial
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        int dis = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // expand
                Point cur = queue.poll();
                cell[cur.x][cur.y].path.add(dis);
                // generate
                for (int k = 0; k < 4; k++) {
                    int newX = cur.x + dx[k];
                    int newY = cur.y + dy[k];
                    if (newX >= 0
                            && newY >= 0
                            && newX < gym.length
                            && newY < gym[0].length
                            && !visited[newX][newY]
                            && gym[newX][newY] != 'O') {
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            dis++;
        }
    }
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class Cell {
        List<Integer> path;
        public Cell() {
            this.path = new ArrayList<>();
        }
    }
}