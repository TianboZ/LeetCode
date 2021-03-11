package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2 {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] arr = set.toCharArray();
        dfs(res, arr, 0);
        return res;
    }

    private void dfs(List<String> res, char[] arr, int i) {
        // base-case
        if (i == arr.length) {
            res.add(new String(arr));
            return;
        }
        // recursive rule
        Set<Character> set = new HashSet<>();
        for (int j = i; j < arr.length; j++) {
            if (!set.contains(arr[j])) {
                swap(arr, i, j);
                dfs(res, arr, i + 1);
                swap(arr, i, j);
                set.add(arr[j]);
            }
        }

    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
