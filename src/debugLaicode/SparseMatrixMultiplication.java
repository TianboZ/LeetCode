package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {

        int[][] res = new int[A.length][B[0].length];

        List<Cell> a = new ArrayList<>();
        List<Cell> b = new ArrayList<>();
        helper(a, A);
        helper(b, B);

        for (Cell c1 : a) {
            for (Cell c2: b) {
                if (c1.y == c2.x) {
                    res[c1.x][c2.y] =  res[c1.x][c2.y] + c1.val * c2.val;
                }
            }
        }
        return res;
    }


    private void helper(List<Cell> list, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    list.add(new Cell(i, j, matrix[i][j]));
                }
            }
        }
    }
    class Cell {
        int x;
        int y;
        int val;

        Cell (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
