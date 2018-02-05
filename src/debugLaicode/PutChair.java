package debugLaicode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PutChair {
    public static void main(String[] args) {
        PutChair putChair = new PutChair();
        char[][] gym = { { 'E', ' ', ' ' },

                     {  ' ', 'E',  ' ' },

                     {  ' ',  ' ', 'E' } };
        putChair.putChair(gym);
    }
    public List<Integer> putChair(char[][] gym) {
        // write your solution here
        Board[][] boards = new Board[gym.length][gym[0].length];
        for (int m = 0; m < boards.length; m++) {
            for (int n = 0; n < boards[0].length; n++) {
                boards[m][n] = new Board();
            }
        }
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'E') {
                    bfs(gym, i, j, boards);
                }
            }
        }

        // find solution
        int min = 99999999;
        int x = 0, y = 0;
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == ' ') {
                    int sum = 0;
                    for (int dis : boards[i][j].disFromEquip) {
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
        List<Integer> res = new ArrayList<>();
        res.add(x);
        res.add(y);
        return res;

    }
    public void bfs(char[][] gym, int i, int j, Board[][] boards) {
        boolean[][] isVisite = new boolean[gym.length][gym[0].length];
        isVisite[i][j] = true;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(i,j));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dis = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                // expand
                Cell cur = queue.poll();
                // generate
                for (int k = 0; k < 4; k++) {
                    int x = cur.x + dx[k];
                    int y = cur.y + dy[k];
                    if (x >= 0 && x < gym.length && y >= 0 && y < gym[0].length && !isVisite[x][y]) {
                        isVisite[x][y] = true;
                        boards[x][y].disFromEquip.add(dis);
                        queue.offer(new Cell(x,y));
                    }
                }
            }
            dis++;
        }
    }


}

class Cell {
    int x;
    int y;
    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Board {
    List<Integer> disFromEquip;
    public Board() {
        this.disFromEquip = new ArrayList<>();
    }
}