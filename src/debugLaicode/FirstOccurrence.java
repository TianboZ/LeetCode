package debugLaicode;

public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
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
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }

        return -1;
    }
}
