package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] visit = new boolean[board.length][board[0].length];
                    if (dfs(board, i, j, word, 0, visit)) result.add(word);
                }
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(result);
        return list;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visit) {
        // base-case
        if (index == word.length()) {
            return true;
        }
        // more terminate conditions
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // recursive rule
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = dx[k] + i;
            int newY = dy[k] + j;
            if (dfs(board, newX, newY, word, index + 1, visit)) {
                visit[i][j] = false;
                return true;
            }
        }
        visit[i][j] = false;
        return false;
    }
}
