package debugLaicode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;

        int round = n / 2;
        for (int i = 0; i < round; i++) {
            int left = i;
            int right = n - 2 - i;
            for (int j = left; j <= right; j++) {
                int tmpt = matrix[left][j];
                matrix[left][j] = matrix[n - 1 - j][left];
                matrix[n - 1 - j][left] = matrix[n - 1 - left][n - 1 - j];
                matrix[n - 1 - left][n - 1 - j] = matrix[j][n - 1 - left];
                matrix[j][n - 1 - left] = tmpt;
            }
        }
    }


}
