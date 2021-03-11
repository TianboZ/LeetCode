package debugLaicode;

public class BitonicPoint {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        // Write your solution here
        int peak = findPeak(array);

        if (array[peak] == target) {
            return peak;
        }
        int leftRes = binarySearchAsc(array, target, 0, peak);
        int rightRes = binarySearchDes(array, target, peak, array.length - 1);
        return leftRes == -1 ? (rightRes) : leftRes;
    }
    private int binarySearchAsc(int[] arr, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        // post process, two elements left
        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }
        return -1;
    }
    private int binarySearchDes(int[] arr, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target){
                right = mid;
            } else {
                left = mid;
            }
        }
        // post process, two elements left
        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }
        return -1;
    }
    private int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid; // ascending order
            } else {
                right = mid;
            }
        }
        // post process, two elements left
        return arr[left] < arr[right] ? right : left;
    }

    public static void main(String[] args) {
        BitonicPoint sol = new BitonicPoint();
        sol.search(new int[]{1,3,5,8,6,2}, 6);
    }
}