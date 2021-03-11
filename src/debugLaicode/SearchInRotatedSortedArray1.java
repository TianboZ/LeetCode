package debugLaicode;

public class SearchInRotatedSortedArray1 {
    public int search(int[] array, int target) {
        // sanity check
        if (array == null || array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > array[0]) {
                if (target >= array[0] && target < array[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target > array[mid] && target <= array[array.length - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        // post process, two elements left
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }



//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        return binarySearch(nums, target);
//    }
//
//    private int binarySearch(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left + 1 < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) return mid;
//
//            if (nums[mid] < nums[right]) {
//                if (target >= nums[mid] && target <= nums[right]) left = mid;
//                else right = mid;
//            } else {
//                if (target >= nums[left] && target <= nums[mid]) right = mid;
//                else left = mid;
//            }
//        }
//        if (nums[left] == target) return left;
//        if (nums[right] == target) return right;
//        return -1;
//    }
}
