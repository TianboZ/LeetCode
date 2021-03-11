package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        recursiveTraversal(res, matrix.length, 0, matrix);
        System.out.println(res);
        return res;
    }
    private void recursiveTraversal(List<Integer> res, int size, int offset, int[][] m) {
        // base-case
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(m[offset][offset]);
            return;
        }
        // recursive rule
        // -->
        for (int i = 0; i < size - 1; i++) {
            res.add(m[offset][offset + i]);
        }

        // from top to down
        for (int i = 0; i < size - 1; i++) {
            res.add(m[i +  offset][size - 1 + offset]);
        }
        // <--
        for (int i = size - 1; i > 0; i--) {
            res.add(m[size - 1 + offset][i + offset]);
        }

        // from down to top
        for (int i = size - 1; i > 0; i--) {
            res.add(m[i +  offset][offset]);
        }

        System.out.println(res);
        recursiveTraversal(res, size - 2, offset + 1, m);
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
