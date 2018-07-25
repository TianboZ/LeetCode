package debugLaicode;

import java.util.*;

public class FactorCombinations {
    public void combinations(int target) {
        // Write your solution here
        List<Integer> factors = new ArrayList<>(getFactors(target));
        Collections.sort(factors);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(res, list, factors, 0, target);

        int[][] sol = new int[res.size()][];
        int k = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            int[] arr = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[j] = res.get(i).get(j);
            }
            sol[k] = arr;
            k++;
        }

        System.out.println(res);
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, List<Integer> factors, int index, int target) {
        // base-case
        if (index == factors.size()) {
            //System.out.println(path);
            if (target == 1) {
                res.add(new ArrayList<>(list));
            }

            return;
        }
        // recursive rule
        int num = factors.get(index);
        for (int i = 0; (int)Math.pow(num, i) <= target; i++) {
            if (target % (int)Math.pow(num, i) == 0) {
                for (int k = 0; k < i; k++) {
                    list.add(num);
                }
                dfs(res, list, factors, index + 1, target / (int)Math.pow(num, i));
                for (int k = 0; k < i; k++) {
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    private Set<Integer> getFactors(int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < target; i++) {
            if (target % i == 0) {
                set.add(i);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        factorCombinations.combinations(24);
    }
}
