package debugLaicode;

import java.util.HashMap;
import java.util.Map;

/*

solution1:
steps:
1. pre-compute the prefixSum for the input array, so that we can get sum[i, j] in O(1) time complexity
2. find all the subarray, o(n^2) subarrays, for each of them, use O(1) time to check if they equals to k or not

time o(n^2)
space o(n)

*/
public class MaximumSizeSubarraySumEqualsK {
    // sol1:
    public int maxSubArrayLen(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;

        int[] ps = new int[nums.length]; // prefix sum array
        ps[0] = nums[0];
        int max = 0;

        // compute the prefix sum array
        for (int i = 1; i < nums.length; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }

        // get all the subarrays
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i <= j; i++) {
                int sum = ps[j] - ps[i] + nums[i];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // sol2:
    public int maxSubArrayLen1(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int max = 0;
        // key: sum from 0 to i index          value: index i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            // case1
            if (sum == k) max = Math.max(max, i + 1);

            // case2
            if (map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                max = Math.max(max, i - index);
            }

            // case3:
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}