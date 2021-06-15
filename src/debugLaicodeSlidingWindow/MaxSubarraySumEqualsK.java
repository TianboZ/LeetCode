package debugLaicodeSlidingWindow;

import java.util.*;

/*

solution1:
steps:
1. pre-compute the prefixSum for the input array, so that we can get sum[i, j] in O(1) time complexity
2. find all the subarray, o(n^2) subarrays, for each of them, use O(1) time to check if they equals to k or not

time o(n^2)
space o(n)


sol2:


follow up:
min size subsarray sum == k

*/
public class MaxSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();  // key: prevfix sum          value: leftmost index

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // case1
            if (sum == k) max = Math.max(max, i + 1);

            // case2
            Integer j = map.get(sum - k);
            if (j != null) {
                max = Math.max(max, i - j);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return max;
    }
}