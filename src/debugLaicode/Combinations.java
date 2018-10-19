package debugLaicode;


import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index, int k) {
        // base case
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (index == nums.length) {
            return;
        }

        // recursive rule
        // case 1, add
        list.add(nums[index]);
        dfs(result, list, nums, index + 1, k);
        // remember to remove the add element when back tracking to
        // the parent node
        // back-tracking
        list.remove(list.size() - 1);

        // case 2, not add
        dfs(result, list, nums, index + 1, k);
        // no-backtracking
    }
}

// time o(2^n)
// space o(n)