package debugLaicode;


import java.util.*;

public class PutChairI {
    public static void main(String[] args) {
        PutChairI putChairI = new PutChairI();
        char[][] gym = {{'E', ' ', ' '},
                {' ', 'E', ' '},
                {' ', ' ', 'E'}};
        putChairI.putChair(gym);
    }

    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (gym.length == 0 || gym[0].length == 0) {
            return res;
        }
        Board[][] board = new Board[gym.length][gym[0].length];

        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                board[i][j] = new Board();
            }
        }

        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'E') {
                    bfs(gym, board, i, j);
                }
            }
        }

        int min = 10000;
        int x = 0;
        int y = 0;
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == ' ' || gym[i][j] == 'E') {
                    int sum = 0;
                    for (Integer dis : board[i][j].list) {
                        sum = sum + dis;
                    }
                    if (sum < min) {
                        min = sum;
                        x = i;
                        y = j;
                    }

                }
            }
        }
        res.add(x);
        res.add(y);
        return res;

    }

    public void bfs(char[][] gym, Board[][] board, int x, int y) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int dis = 0;
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        board[x][y].list.add(dis);
        dis++;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // expand
                Point cur = queue.poll();

                // generate rule
                for (int k = 0; k < 4; k++) {
                    int curX = cur.x + dx[k];
                    int curY = cur.y + dy[k];
                    if (curX >= 0 && curX < gym.length && curY >= 0 && curY < gym[0].length && !visited[curX][curY]) {
                        queue.offer(new Point(curX, curY));
                        visited[curX][curY] = true;
                        board[curX][curY].list.add(dis);
                    }
                }
            }
            dis++;
        }
    }

    class Board {
        List<Integer> list;

        public Board() {
            this.list = new ArrayList<>();
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
}