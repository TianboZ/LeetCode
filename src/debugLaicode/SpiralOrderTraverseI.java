package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        dfs(res, matrix.length, 0, matrix);
        System.out.println(res);
        return res;
    }
    private void dfs(List<Integer> res, int size, int offset, int[][] a) {
        // base-case
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(a[offset][offset]);
            return;
        }
        // recursive rule
        for (int i = 0; i < size - 1; i++) { // left to right
            res.add(a[offset][offset + i]);
        }

        for (int i = 0; i < size - 1; i++) { // up to down
            res.add(a[offset + i][size  - 1 + offset]);
        }

        for (int i = size - 1; i >= 1; i--) { // right to left
            res.add(a[offset + size - 1][offset + i]);
        }

        for (int i = size - 1; i >= 1; i--) { // down to up
            res.add(a[offset + i][offset]);
        }
        System.out.println(res);
        dfs(res, size - 2, offset + 1, a);
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16}
        };

        SpiralOrderTraverseI spiralOrderTraverseI = new SpiralOrderTraverseI();
        spiralOrderTraverseI.spiral(a);
    }
}
