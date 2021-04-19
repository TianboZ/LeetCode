package debugLaicode;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m * n - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        int row = lo / n;
        int col = lo % n;
        if (matrix[row][col] == target) return true;

        row = hi / n;
        col = hi % n;
        if (matrix[row][col] == target) return true;

        return false;
    }


}
