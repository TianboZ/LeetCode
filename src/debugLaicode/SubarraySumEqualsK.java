package debugLaicode;

/*

solution1:
steps:
1. pre-compute the prefixSum for the input array, so that we can get sum[i, j] in O(1) time complexity
2. find all the subarray, o(n^2) subarrays, for each of them, use O(1) time to check if they equals to k or not

time o(n^2)
space o(n)


solution2:
HashMap<key: sum,  value: frequence>
for each nums[j], count how many of subarray that sum[i, j] == k, where i <= j

*/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        // key: sum [0, i]  value: frequence
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i]; // current sum from 0 to i index

            // count
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            // update frequence
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}