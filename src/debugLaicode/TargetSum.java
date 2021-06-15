package debugLaicode;

import java.util.*;

public class TargetSum {
    int cnt;
    Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, 0, 0, target);

    }

    private int dfs(int[] nums, int i, int sum, int target) {
        // base case
        String s = i + ","+sum;
        Integer state = memo.get(s);
        if(state != null)  return state;

        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        // recursive rule
        memo.put(s, 0);
        int n1 = dfs(nums, i + 1, sum + nums[i], target);
        int n2 = dfs(nums, i + 1, sum - nums[i], target);
        memo.put(s, n1 + n2);
        return n1 + n2;
    }
}
