package debugLaicode;

public class SearchIn2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // start point
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

}
