package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class Cents99 {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here.
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = coins.length;
        helper(list, result, coins, target, 0, n);
        System.out.println(result);

        return result;
    }
    public void helper(List<Integer> list,
                       List<List<Integer>> result,
                       int[] coins,
                       int remaining,
                       int level,
                       int n) {


        // base-case
        if (level == coins.length) {
            if (remaining == 0) {
                // deep copy!!!!!!!!!!!!!
                List<Integer> templist = new ArrayList<>(list);
                result.add(templist);
            }
            return;
        }

        // recursive rule
        for (int i = 0; i * coins[level] <= remaining; i++) {
            list.add(i);
            helper(list, result, coins, remaining - i * coins[level], level + 1, n);
            list.remove(list.size() - 1);
        }
    }


}
