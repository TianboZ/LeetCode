package debugLaicode;

import java.util.*;

public class SpiralMatrix2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }

            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        // nothing left
        if (left > right || up > down) {
            return list;
        }
        // one column left
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        } else {
            // one row left
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
}
