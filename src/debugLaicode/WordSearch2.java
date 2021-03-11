package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    // 2021
    boolean[][] v; // visited
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean found;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        v = new boolean[board.length][board[0].length];

        for (String w : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(res, board, w, 0, i, j);
                }
            }

            // clean up
            found = false;
            v = new boolean[board.length][board[0].length];
        }
        return res;
    }

    private void dfs(List<String> res, char[][] b, String s, int idx, int i, int j) {
        // base case
        if (found) return;
        if (idx == s.length()) {
            found = true;
            res.add(s);
            return;
        }

        // check boundary
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length) return;
        if (s.charAt(idx) != b[i][j]) return;
        if (v[i][j]) return;

        // recursive rule
        v[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k]; int y = j + dy[k];
            dfs(res, b, s, idx + 1, x, y);
        }
        v[i][j] = false;
    }
}

//    int[] dx = {1, -1, 0, 0};
//    int[] dy = {0, 0, 1, -1};
//    boolean[][] v;
//
//    public List<String> findWords(char[][] board, String[] words) {
//        v = new boolean[board.length][board[0].length];
//
//        Set<String> result = new HashSet<>();
//        for (String word : words) {
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    if (dfs(board, i, j, word, 0)) result.add(word);
//                }
//            }
//        }
//        List<String> list = new ArrayList<>();
//        list.addAll(result);
//        return list;
//    }
//
//    private boolean dfs(char[][] board, int i, int j, String word, int index) {
//        // base-case
//        if (index == word.length()) {
//            return true;
//        }
//        // more terminate conditions
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || v[i][j] || board[i][j] != word.charAt(index)) {
//            return false;
//        }
//
//        // recursive rule
//        v[i][j] = true;
//        for (int k = 0; k < 4; k++) {
//            int newX = dx[k] + i;
//            int newY = dy[k] + j;
//            if (dfs(board, newX, newY, word, index + 1)) {
//                v[i][j] = false;
//                return true;
//            }
//        }
//        v[i][j] = false;
//        return false;
//    }
//}
