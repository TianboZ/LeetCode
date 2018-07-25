package debugLaicode;

public class PrefixSum2D {
    public int[][] prefixSum2D(int a[][]) {
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

}
