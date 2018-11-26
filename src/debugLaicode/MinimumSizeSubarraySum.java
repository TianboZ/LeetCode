package debugLaicode;

/*

keep a sliding window, [left, right]
the sum of window >= s

*/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        // santity check
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            // handle right pointer
            sum = sum + nums[right];

            // handle left pointer
            while (sum >= s) {
                // update length of window
                min = Math.min(min, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
