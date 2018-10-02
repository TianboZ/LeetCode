package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderGenerateII {
    public void spiralOrderGenerator(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;


        int num = 1;

        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num;
                num++;
            }
            for (int i = up + 1; i <= down - 1; i++) {
                matrix[i][right] = num;
                num++;
            }

            for (int i = right; i >= left; i--) {
                matrix[down][i] = num;
                num++;
            }
            for (int i = down - 1; i >= up + 1; i--) {
                matrix[i][left] = num;
                num++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        // nothing left
        if (left > right || up > down) {
            return;
        }
        // one column left
        if (left == right) {
            for (int i = up; i <= down; i++) {
                matrix[i][left] = num;
                num++;
            }
        } else {
            // one row left
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num;
                num++;
            }
        }
    }
}
