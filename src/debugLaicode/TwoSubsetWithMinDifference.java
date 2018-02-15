package debugLaicode;

import java.util.ArrayList;
import java.util.*;

public class TwoSubsetWithMinDifference {

    public static void main(String[] args) {
        TwoSubsetWithMinDiffer twoSubsetWithMinDiffer = new TwoSubsetWithMinDiffer();
        int[] arr = {1,4,2,3};
        twoSubsetWithMinDiffer.minDifference(arr);
    }

    public int minDifference(int[] array) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, array, 0);
        System.out.println(res);
        return findMinDiff(res, array);
    }

    public int findMinDiff(List<List<Integer>> res, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(i);
        }
        int min = 100000;
        for (List<Integer> list : res) {
            int sum1 = 0;
            int sum2 = 0;
            for (Integer i : list) {
                if (set.contains(i)) {
                    sum1 = sum1 + arr[i];
                } else {
                    sum2 = sum2 + arr[i];
                }
            }
            min = Math.min(min, Math.abs(sum1 - sum2));
        }
        return min;
    }

    // get all the size of n/2 subset of index
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] arr, int index) {
        // base-case
        if (index == arr.length) {
            if (list.size() == arr.length / 2) {
                res.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        // recursive rule
        // case1 take arr[index]
        list.add(index);
        dfs(res, list, arr, index + 1);
        list.remove(list.size() - 1);
        // case2 not take arr[index]
        dfs(res, list, arr, index + 1);
    }

    // 99 cents template
    public void dfs(List<List<Integer>> res, List<Integer> list,
                    List<Integer> factor, int index, int target) {
        // base-case
        if (index == factor.size()) {
            if (target == 1) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == 0) {
                        continue;
                    }
                    for (int j = 1; j <= list.get(i); j++) {
                        tmp.add(factor.get(i));
                    }
                }
                res.add(tmp);
                return;
            }
            return;
        }
        // recursive rule
        int curFactor = factor.get(index);
        int max = target / curFactor;
        for (int i = 0; i <= max; i++) {
            if (i == 0) {
                list.add(i);
                dfs(res, list, factor, index + 1, target);
                list.remove(list.size() - 1);
            } else {
                if (target % (i * curFactor) == 0) {
                    list.add(i);
                    dfs(res, list, factor, index + 1, target / (i * curFactor));
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
