package debugLaicode;

public class NumberOfNegativeNumbersInSortedMatrix {
    public int negNumber(int[][] matrix) {
        // Write your solution here
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = largestSmaller(matrix[i], 0);
            if (j != -1) {
                count = count + j + 1;
            }
        }
        return count;
    }

    private int largestSmaller(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            }
        }
        // post-processing
        if (array[right] < target) {
            return right;
        } else if (array[left] < target) {
            return left;
        }

        return -1;
    }
}
