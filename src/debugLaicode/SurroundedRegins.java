package debugLaicode;

import java.util.*;

public class SurroundedRegins {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean onBoundary = false;

    // find the connected 'O' area, if all the 'O' are not on the boundary,
    // then this area of 'O' can be replace by 'X'
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        boolean[][] visited = new boolean[board.length][board[0].length];
        List<List<Integer>> cordinates = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    cordinates.clear();
                    onBoundary = false;
                    bfs(board, visited, i, j, cordinates);
                    if (!onBoundary) {
                        replaceO(cordinates, board);
                    }
                }
            }
        }
    }
    private void replaceO(List<List<Integer>> cordinates, char[][] board) {
        for (List<Integer> point : cordinates) {
            board[point.get(0)][point.get(1)] = 'X';
        }
    }

    // sol1: stack overflow
    // traverse the board, DFS
    private void dfs(char[][] board, boolean[][] visited, int x, int y, List<List<Integer>> cordinates) {
        // base-case
        if (visited[x][y]) return;

        // recursive rule
        visited[x][y] = true;
        List<Integer> point = new ArrayList<>();
        point.add(x);
        point.add(y);
        cordinates.add(point);
        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) onBoundary = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && board[newX][newY] == 'O') {
                dfs(board, visited, newX, newY, cordinates);
            }
        }
    }

    // sol2:
    // traverse the board, BFS
    public void bfs(char[][] board, boolean[][] visited, int x, int y, List<List<Integer>> cordinates) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        List<Integer> point = new ArrayList<>();
        point.add(x);
        point.add(y);
        cordinates.add(point);
        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) onBoundary = true;

        while (!q.isEmpty()) {
            // expand
            Node curr = q.poll();

            // generate
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && board[newX][newY] == 'O' && !visited[newX][newY]) {
                    q.offer(new Node(newX, newY));
                    visited[newX][newY] = true;
                    point = new ArrayList<>();
                    point.add(newX);
                    point.add(newY);
                    cordinates.add(point);
                    if (newX == 0 || newY == 0 ||newX == board.length - 1 || newY == board[0].length - 1) onBoundary = true;
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int hash1 = list.hashCode();
        list.add(2);
        int hash2 = list.hashCode();

        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int hash3 = list.hashCode();

        System.out.println("hash1: " + hash1 + " hash2: " + hash2 + "  hash3: " + hash3);
    }
}
