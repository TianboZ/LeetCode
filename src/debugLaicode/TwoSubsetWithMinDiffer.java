package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSubsetWithMinDiffer {
    public static  void main(String[] args) {
        TwoSubsetWithMinDiffer twoSubsetWithMinDiffer = new TwoSubsetWithMinDiffer();
        int[] arr = {1,2,3,4};
        twoSubsetWithMinDiffer.minDifference(arr);
    }
    int min;
    public int minDifference(int[] array) {
        // Write your solution here.
        min = Integer.MAX_VALUE;
        List<Integer> list= new ArrayList<>();
        dfs(array, 0, list);
        return min;
    }
    public void dfs(int[] arr, int index, List<Integer> list) {
        // base-case
        if (index == arr.length) {
            if (list.size() == arr.length / 2) {
                System.out.println(list);
                List<Integer> tmp = new ArrayList<>(list);
                Set<Integer> set = new HashSet<>(tmp);
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (set.contains(i)) {
                        sum1 = sum1 + arr[i];
                    } else {
                        sum2 = sum2 + arr[i];
                    }
                }
                if (Math.abs(sum1 - sum2) < min) {
                    min = Math.abs(sum1 - sum2);
                }
            }

            return;
        }
        // recursive rule
        // case1 take arr[index]
        list.add(index);
        dfs(arr, index + 1, list);
        list.remove(list.size() - 1);

        // case2 not take arr[index]
        dfs(arr, index + 1, list);
    }
}
