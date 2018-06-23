package debugLaicode;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your solution here
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                // update
                if (prefixSum[i] - prefixSum[j] + nums[j] == k) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }

        return max;
    }
}
