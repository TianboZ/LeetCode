package debugLaicode;

import java.util.ArrayList;
import java.util.List;

/*
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
*/


public class Cents99 {
    public static void main(String[] args) {
        Cents99 cents99 = new Cents99();
        int[] coins =  {25, 10, 5, 2, 1};
        cents99.combinations(99, coins);
    }
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        if (coins == null || coins.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, target, coins, 0, list);
        return res;
    }
    public void dfs(List<List<Integer>> res, int target, int[] coins, int index, List<Integer> list) {
        // base-case
        if (index == coins.length) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        System.out.println(target);
        System.out.println(index);
        // recursive rule
        int curCoin = coins[index];
        int max = target / curCoin;
        for (int i = 0; i <= max; i++) {
            list.add(i);
            dfs(res, target - i * curCoin, coins, index+1, list);
            list.remove(list.size() - 1);
        }
    }
}
