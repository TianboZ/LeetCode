package debugLaicode;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // Write your solution here
        int[][] ps = prefixSum(matrix);
        int max = Integer.MIN_VALUE;
        // iterate every left up conner
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // iterate every right bottom conner
                for (int x = i; x < matrix.length; x++) {
                    for (int y = j; y < matrix[0].length; y++) {
                        if (i == 0 && j == 0) {
                            int sum = ps[x][y];
                            max = Math.max(max, sum);
                        } else if (i == 0) {
                            int sum = ps[x][y]
                                    - ps[x][j - 1];
                            max = Math.max(max, sum);
                        } else if (j == 0) {
                            int sum = ps[x][y]
                                    - ps[i - 1][y];
                            max = Math.max(max, sum);
                        } else {
                            int sum = ps[x][y]
                                    + ps[i - 1][j - 1]
                                    - ps[i - 1][y]
                                    - ps[x][j - 1];
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
        return max;
    }
    private int[][] prefixSum(int[][] a) {
        int[][] ps = new int[a.length][a[0].length];
        ps[0][0] = a[0][0];

        for (int i = 1; i < a[0].length; i++) {
            ps[0][i] = ps[0][i - 1] + a[0][i];
        }
        for (int j = 1; j < a.length; j++) {
            ps[j][0] = ps[j - 1][0] + a[j][0];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                ps[i][j] = ps[i - 1][j]
                        + ps[i][j - 1]
                        - ps[i - 1][j - 1]
                        + a[i][j];
            }
        }
        return ps;
    }
}
