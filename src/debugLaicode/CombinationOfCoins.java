package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
    // 2020
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        // sanity check

        dfs(0, coins, 0, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(int index, int[] coins, int curr, int target,List<List<Integer>>  res, List<Integer> list ) {
        // basecase
        if (index == coins.length) {
            if (curr == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        // recursive rule
        int coin = coins[index];
        for (int i = 0; i * coin + curr <= target; i++) {
            list.add(i);
            dfs(index + 1, coins, curr + i * coin, target, res, list);
            list.remove(list.size() - 1);
        }
    }

    // 2018
//    public List<List<Integer>> combinations(int target, int[] coins) {
//        // Write your solution here
//        if (coins == null || coins.length == 0) {
//            return null;
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        dfs(res, target, coins, 0, list);
//        return res;
//    }
//    private void dfs(List<List<Integer>> res, int target, int[] coins, int index, List<Integer> list) {
//        // base-case
//        if (index == coins.length) {
//            if (target == 0) {
//                res.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        // recursive rule
//        int coin = coins[index];
//        for (int i = 0; i * coin <= target; i++) {
//            list.add(i);
//            dfs(res, target - i * coin, coins, index + 1, list);
//            list.remove(list.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        CombinationOfCoins combinationOfCoins = new CombinationOfCoins();
        int[] coins =  {25, 10, 5, 2, 1};
        System.out.println(combinationOfCoins.combinations(20, coins));
    }
}
