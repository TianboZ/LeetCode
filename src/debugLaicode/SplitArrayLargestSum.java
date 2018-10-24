package debugLaicode;

import java.util.*;

/*
solution:
Deapth first search
for each element, two choices:
    - append it with previous subarray
    - start a new subarray

branch factor: 2
depth of recurison tree: n

n is size of input array

time o(2^n)
space o(n)

*/
public class SplitArrayLargestSum {
    int min = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int m) {
        List<Integer> sums = new ArrayList<>();
        dfs(nums, 0, m, sums, 0);
        return min;
    }
    private void dfs(int[] nums, int index, int m, List<Integer> sums, int prevSum) {
        // base-case
        if (index == nums.length) {
            if(m == 1) {
                sums.add(prevSum);
                int max = Integer.MIN_VALUE;
                for (int i : sums) {
                    max = Math.max(max, i);
                }
                min = Math.min(min, max);
                sums.remove(sums.size() - 1);
            }
            return;
        }
        // recursive rule
        // start a new subarray
        if (m > 1) {
            sums.add(prevSum);
            dfs(nums, index + 1, m - 1, sums, nums[index]);
            sums.remove(sums.size() - 1);
        }

        // not start a new subarray
        dfs(nums, index + 1, m, sums, prevSum + nums[index]);
    }
}


