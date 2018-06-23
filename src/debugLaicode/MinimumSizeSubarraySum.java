package debugLaicode;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        // Write your solution here
        int sum = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // handle rightmost number
            sum = sum + nums[i];

            // handle leftmost number
            while (sum >= s) {
                // update
                if (i - j + 1 < min) {
                    min = i - j + 1;
                }

                sum = sum - nums[j];
                j++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
