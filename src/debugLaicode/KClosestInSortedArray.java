package debugLaicode;

public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }

        int left = largestSmallerEqual(array, target);
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < array.length && (target - array[left]) <= (array[right] - target)) {
                result[i] = array[left];
                left--;
            } else if (left >= 0 && right < array.length && (target - array[left]) > (array[right] - target)) {
                result[i] = array[right];
                right++;
            } else if (left < 0) {
                result[i] = array[right];
                right++;
            } else if (right >= array.length) {
                result[i] = array[left];
                left--;
            }
        }
        return result;
    }

    private int largestSmallerEqual(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // post processing
        if (target >= array[right]) {
            return right;
        }
        if (target >= array[left]) {
            return left;
        }

        // can not find
        return -1;
    }

    public static void main(String[] args) {
        KClosestInSortedArray kClosestInSortedArray = new KClosestInSortedArray();
        int[] arr = {-1, 2, 3, 5, 6, 11};
        int target = 4;
        int[] result = kClosestInSortedArray.kClosest(arr, target, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
