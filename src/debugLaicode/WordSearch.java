package debugLaicode;

public class WordSearch {
//    boolean found;
//    int[] dx = {0, 0, 1, -1};
//    int[] dy = {1, -1, 0, 0};
//    boolean[][] v; // mark visit
//
//    public boolean exist(char[][] board, String word) {
//        v = new boolean[board.length][board[0].length];
//
//        for (int i  = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                dfs(board, 0, word, i, j);
//            }
//        }
//
//        return found;
//    }
//
//    private void dfs(char[][] b, int i, String word, int row, int col ) {
//        // base case
//        if (found) return;
//        if (i == word.length()) {
//            found = true;
//            return;
//        }
//
//        // check boundary
//        if (row < 0 || row >= b.length || col < 0 || col >= b[0].length) return;
//        if ( word.charAt(i) != b[row][col] ) return;
//        if (v[row][col]) return;
//
//
//        // recursive rule
//        v[row][col] = true;
//
//        for (int k = 0; k < 4; k++) {
//            int x = row + dx[k];
//            int y = col + dy[k];
//            dfs(b, i + 1, word, x, y);
//        }
//        v[row][col] = false;
//    }
//
//    public static void main(String[] args) {
//        char[][] board = {
//                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}};
//
//        WordSearch sol  = new WordSearch();
//        System.out.println(sol.exist(board, "eat"));
//    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] b, String w, int i, int j, int start) {
        // base case
        if (start == w.length()) return true;
        if (visited[i][j]) return false;
        if (b[i][j] != w.charAt(start)) return false;

        // recursive rule
        if (start == w.length() - 1) return true; // last char in string

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];

            boolean inBound = ii >= 0 && jj >= 0 && ii < b.length && jj < b[0].length;

            if (inBound ) {
                if (dfs(b, w, ii, jj, start + 1)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

// time O(3 ^ L):     L is length of word     3-nary recursion tree
// space O(L)