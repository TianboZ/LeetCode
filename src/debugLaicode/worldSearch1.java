package debugLaicode;

public class worldSearch1 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, 0, visited, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    // from (i,j) position, dfs, if there exist the word, return true
    private boolean exist(char[][] board, int index, boolean[][] visited, int x, int y, String s) {
        // base-case
        // all chars match, we found a path
        if (index == s.length()) {
            return true;
        }
        // more terminate condition 1. out of bound 2. visited  3. not match
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0
                || visited[x][y]
                || board[x][y] != s.charAt(index)) {
            return false;
        }

        // recursive rule
        // record the cell used on current DFS path
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (exist(board,index + 1, visited, newX, newY, s)) {
                visited[x][y] = false; // do not forget
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
