package debugLaicode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {


    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !isBoard(i, j, board)) {
                    System.out.println("for loop");
                    bfs(i, j, board);

                }
            }
        }
        print(board);

    }

    public void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();

        }
    }

    public void bfs(int i, int j, char[][] board) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        System.out.println("aaaa");
        Queue<Cordinate> open = new LinkedList<Cordinate>();
        Set<Cordinate> visited = new HashSet<Cordinate>();

        Cordinate cordinate = new Cordinate(i, j);
        open.offer(cordinate);
        visited.add(cordinate);
        while(!open.isEmpty()) {

            print(board);

            Cordinate coor = open.poll();
            for(int k = 0; k < 4; k++) {
                int newI = dx[k] + coor.x;
                int newJ = dy[k] + coor.y;
                Cordinate adj = new Cordinate(newI, newJ);

                if (isValid(newI, newJ, board)) {
                    if (board[newI][newJ] == 'X') {
                        continue;
                    }
                    if (board[newI][newJ] == 'O') {
                        if (isBoard(newI, newJ, board)) {
                            return;
                        }
                        if (visited.add(adj)) {
                            // now, adj is surrounded
                            open.offer(adj);
                            visited.add(adj);
                        }

                    }
                }
            }
            System.out.println("finish for");
        }

        for (Cordinate pair : visited) {
            System.out.println("CCC");
            board[pair.x][pair.y] = 'X';
        }
    }

    public boolean isValid(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return false;
        }
        return true;
    }

    public boolean isBoard(int i, int j, char[][] board) {
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            return true;
        }
        return false;
    }
}
class Cordinate {
    int x, y;
    Cordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // compare
    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cordinate)) {
            return false;
        }
        Cordinate compareCordinate = (Cordinate) obj;
        return ((compareCordinate.x == x)&& (compareCordinate.y == y));
    }
}