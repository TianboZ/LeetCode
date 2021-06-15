package debugLaicode;

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && checkSubBox(board);
    }

    private boolean checkRow(char[][] b) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (b[i][j] == '.') continue;
                if (!set.add(b[i][j])) return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] b) {
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (b[i][j] == '.') continue;
                if (!set.add(b[i][j])) return false;
            }
        }
        return true;
    }
    private boolean checkSubBox(char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ii = i * 3;
                int jj = j * 3;
                Set<Character> set = new HashSet<>();
                for (int x = ii; x < ii + 3; x++) {
                    for (int y = jj; y < jj +3; y++) {
                        if (b[x][y] == '.') continue;
                        if (!set.add(b[x][y])) return false;
                    }
                }
            }
        }
        return true;
    }
}
