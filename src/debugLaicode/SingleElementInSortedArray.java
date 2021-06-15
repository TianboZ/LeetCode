package debugLaicode;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1  < hi) {
            int mid =  ( hi + lo) / 2;
            if (nums[mid - 1] == nums[mid]) {
                int left = mid - 1 - lo;
                if (left % 2 != 0) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                int left = mid - lo;
                if (left % 2 != 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 2;
                }

            } else {
                return nums[mid];
            }
        }

        return nums[hi];  // nums[lo]
    }
}
