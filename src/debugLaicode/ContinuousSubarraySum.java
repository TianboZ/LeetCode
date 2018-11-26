package debugLaicode;

/*
solution1:

steps:
1. get all valid subarrays
2. for each subarray, check sum of it == k * n
    - detail: use prefix sum array to get sum of subarray in O(1)

time o(n ^ 2)
space o(1)

solution2:
HashMap<key: sum, value: index> ,  if mulitiple same sum appears, keep the index of first time it sppears

*/

public class ContinuousSubarraySum {
    // sol1
    public boolean checkSubarraySum1(int[] nums, int k) {
        // sanity check
        // todo:

        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i + 1<= j; i++) {
                if (k != 0 && (prefixsum[j] - prefixsum[i] + nums[i]) % k == 0) {
                    return true;
                } else if (prefixsum[j] - prefixsum[i] + nums[i] == 0 && k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
