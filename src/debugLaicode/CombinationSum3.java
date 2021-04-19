package debugLaicode;

import java.util.*;

public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path  = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs( 0, n, k, nums, 0);
        return res;
    }

    private void dfs(int i, int target, int k, int[] nums, int sum) {
        // base case
        if (k == 0 || i == nums.length) {
            if (sum == target && k == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // recursive rule
        int num = nums[i];
        path.add(num);
        dfs(i + 1, target, k - 1, nums, sum + num);
        path.remove(path.size() - 1);

        dfs(i + 1, target, k, nums, sum);
    }
}
