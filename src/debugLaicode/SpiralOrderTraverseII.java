package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        dfs(res, 0, matrix, matrix.length, matrix[0].length);
        return res;
    }

    private void dfs(List<Integer> res, int offset, int[][] a, int rowSize, int colSize) {
        // base-case
        if (rowSize == colSize && rowSize == 0) {
            return;
        }
        if (rowSize == colSize && rowSize == 1) {
            res.add(a[offset][offset]);
            return;
        }

        // column left
        if (rowSize != colSize && rowSize == 1) {
            for (int i = 0; i < colSize; i++) {
                res.add(a[offset][offset + i]);
            }
            return;
        }

        // row left
        if (rowSize != colSize && colSize == 1) {
            for (int i = 0; i < rowSize; i++) {
                res.add(a[offset + i][offset]);
            }
            return;
        }
        // recursive rule
        for (int i = 0; i < colSize - 1; i++) {
            res.add(a[offset][offset + i]);
        }
        for (int i = 0; i < rowSize - 1; i++) {
            res.add(a[offset + i][offset + colSize - 1]);
        }
        for (int i = colSize - 1; i >= 1; i--) {
            res.add(a[offset + rowSize - 1][offset + i]);
        }
        for (int i = rowSize - 1; i >= 1; i--) {
            res.add(a[offset + i][offset]);
        }
        dfs(res, offset + 1, a, rowSize - 2, colSize - 2);
    }
}
