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

       time o(n^target)
       spce o(n)    n = candidates.length
*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(candidates, res, count, 0, target);
        for (List<Integer> list : res) {
            List<Integer> tmpt = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != 0) {
                    for(int j = 0; j < list.get(i);j++) {
                        tmpt.add(candidates[i]);
                    }
                }
            }
            sol.add(tmpt);
        }
        return sol;
    }
    private void dfs(int[] candidates, List<List<Integer>> res,List<Integer> count, int index, int target) {
        // base-case
        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(count));
            }
            return;
        }
        // recursive rule
        int num = candidates[index];
        for (int i = 0; i * num <= target; i++) {
            count.add(i);
            dfs(candidates, res, count, index + 1, target - i * num);
            count.remove(count.size() - 1); // backtracking
        }
    }
}