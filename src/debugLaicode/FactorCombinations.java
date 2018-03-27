package debugLaicode;

import java.util.*;

public class FactorCombinations {

    public static void main(String[] args) {

        FactorCombinations factorCombinations = new FactorCombinations();
        factorCombinations.combinations(24);
    }
    public void combinations(int target) {
        // Write your solution here
        Set<Integer> set = getFactors(target);
        int[] arr = new int[set.size()];
        int i = 0;
        for (Integer e : set) {
            arr[i] = e;
            i++;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, arr, 0, target);
        int[][] sol = new int[res.size()][];

        i = 0;
        for (List<Integer> list1 : res) {
            int j = 0;
            int[] tmp = new int[list1.size()];
            for (Integer integer : list1) {
                tmp[j] = integer;
                j++;
            }
            sol[i] = tmp;
            i++;
        }
        System.out.println(res);
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] arr, int index, int target) {
        // base-case
        if (target == 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == arr.length) {
            return;
        }
        // recursive rule
        int factor = arr[index];

        for (int i = 0; (int)Math.pow(factor, i) <= target; i++) {
            if (target % ((int)Math.pow(factor, i)) == 0) {
                for (int j = 0; j < i; j++) {
                    list.add(factor);
                }
                dfs(res, list, arr, index + 1, target / ((int)Math.pow(factor, i)));
                // back-tarcking
                for (int j = 0; j < i; j++) {
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    public Set<Integer> getFactors(int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < target; i++) {
            if (target % i == 0) {
                set.add(i);
            }
        }
        return set;
    }
}
