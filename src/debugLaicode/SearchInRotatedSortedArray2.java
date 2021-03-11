package debugLaicode;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return binarySearch(nums, target);
    }
    private boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] < nums[r]) {
                if (target >= nums[mid] && target <= nums[r]) l = mid;
                else r = mid;
            } else if (nums[mid] == nums[r]) {
                r--;
            } else {
                if (target >= nums[l] && target <= nums[mid]) r = mid;
                else l = mid;
            }
        }

        if (nums[l] == target || nums[r] == target) return true;
        return false;
    }
}
