package debugLaicode;

import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> res;
    List<Integer> list;
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>(); // deduplicate
        Arrays.sort(candidates);
        list = new ArrayList<>();

        dfs(candidates, target, 0, 0);

        return res;
    }

    // laioffer
    private void dfs(int[] arr, int target, int sum, int index) {
        // base-case
        if (sum == target && set.add(list)) {
            res.add( new ArrayList<>(list));
        }

        if (index == arr.length) {
            return;
        }

        if (sum > target) return;

        // recursive rule
        // case1: add arr[index]
        int num = arr[index];
        list.add(num);
        dfs(arr, target, sum + num, index + 1 );
        list.remove(list.size() - 1);

        // case2: not add arr[index]
        dfs(arr, target, sum, index + 1 );
    }
}
