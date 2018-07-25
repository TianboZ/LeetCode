package debugLaicode;

public class RangeSumQuery {
    public int sumRange(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length];

        // base-case
        prefixSum[0] = nums[0];

        // inductive rule
        for (int k = 1; k < nums.length; k++) {
            prefixSum[k] = prefixSum[k - 1] + nums[k];
        }

        return prefixSum[j] - prefixSum[i] + nums[i];
    }
}
