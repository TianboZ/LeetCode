package debugLaicode;

public class BinarySearch {
    public int classicBS(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int generalBS(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2; // avoid overflow
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }
        return -1;
    }
}
