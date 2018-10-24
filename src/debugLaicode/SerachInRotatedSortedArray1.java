package debugLaicode;

public class SerachInRotatedSortedArray1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) left = mid;
                else right = mid;
            } else {
                if (target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}
