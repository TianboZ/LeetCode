package debugLaicode;

public class SerachInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return binarySearch(nums, target);
    }
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] < nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) left = mid;
                else right = mid;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                if (target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid;
            }
        }

        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }
}
