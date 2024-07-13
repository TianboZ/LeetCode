package debugLaicode;

import java.util.*;

public class allpermutations2 {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        dfs(0, res, input.toCharArray());
        return res;
    }

    private void dfs(int index, List<String> res, char[] arr) {
        // basecase
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }

        // recursive rule
        Set<Character> set = new HashSet<>(); // used for swap deduplicate
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                swap(arr, index, i);
                set.add(arr[index]);
                dfs(index + 1, res, arr);
                swap(arr, index, i); // backtracking
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}
