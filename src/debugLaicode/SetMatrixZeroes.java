package debugLaicode;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        //Input your code here
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m]; // 标记该行是否存在0
        boolean[] col = new boolean[n]; // 标记该列是否存在0

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i]) Arrays.fill(matrix[i], 0);
        }
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
