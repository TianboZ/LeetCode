package debugLaicode;

import java.util.*;

public class CombinationSum {

/*
                    target(8)
                /       |||||||||\
       2       0*2(8)    1*2(6).....
                /|||\ ...
       3     0*3(8) 1*3(5)
             /|||\    /||||\
       5    0*5(8)...   1*5(0)....

       if there is candidate value is 1, then there will be at most target branches

       time o(branch ^ level)
       space o(level)

       level = candidates.length
       branch = this is dynamical changing, wort case is,
*/
private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, 0, target, 0);
        return res;
    }

    private void dfs(int[] arr, int i, int target, int sum) {
        // base case
        if (i == arr.length) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // recursive rule
        int num = arr[i];

        for (int k = 0; sum + k * num <= target; k++) {
            for (int j = 0; j < k; j++) {
                path.add(num);
            }
            dfs(arr, i + 1, target, sum + k * num);
            for (int j = 0; j < k; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
}