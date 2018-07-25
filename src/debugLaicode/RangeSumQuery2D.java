package debugLaicode;

public class RangeSumQuery2D {
    // prefixSum in 2D
    public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        // Write your solution here
        int[][] prefixSum = prefixSum2D(matrix);
        return prefixSum[row2][col2]
                + prefixSum[row1 - 1][col1 - 1]
                - prefixSum[row1 - 1][col2]
                - prefixSum[row2][col1 - 1];
    }

    private int[][] prefixSum2D(int a[][]) {
        int m = a.length;
        int n = a[0].length;

        int prefixSum[][] = new int[m][n];

        prefixSum[0][0] = a[0][0];

        // Filling first row and first column
        for (int i = 1; i < n; i++) {
            prefixSum[0][i] = prefixSum[0][i - 1] + a[0][i];
        }

        for (int i = 1; i < m; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + a[i][0];
        }

        // updating the values in the
        // cells as per the general formula.
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                // values in the cells of new array
                // are updated
                prefixSum[i][j] = prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1]
                        + a[i][j];
        return prefixSum;
    }

    // driver code
    public static void main(String[] args) {
        int a[][] = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        RangeSumQuery2D rangeSumQuery2D = new RangeSumQuery2D();
        rangeSumQuery2D.prefixSum2D(a);
    }
}
