package debugLaicode;

public class SpiralOrderGenerateI {
    public int[][] spiralGenerate(int n) {
        // Write your solution here.
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        dfs(matrix, 0, n, 1);
        return matrix;
    }

    private void dfs(int[][] a, int offset, int size, int num) {
        // basecase
        if (size == 0) {
            return;
        }

        if (size == 1) {
            a[offset][offset] = num;
            return;
        }
        // recursive rule
        for (int i = 0; i < size - 1; i++) {
            a[offset][offset + i] = num;
            num++;
        }
        for (int i = 0; i < size - 1; i++) {
            a[offset + i][offset + size - 1] = num;
            num++;
        }
        for (int i = size - 1; i >= 1; i--) {
            a[offset + size - 1][offset + i] = num;
            num++;
        }
        for (int i = size - 1; i >= 1; i--) {
            a[offset + i][offset] = num;
            num++;
        }
        dfs(a, offset + 1, size - 2, num);
    }
}
