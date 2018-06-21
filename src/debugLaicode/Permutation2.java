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

    private void dfs(List<String> res, char[] arr, int index) {
        // base-case
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }
        // recursive rule
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (set.add(arr[i])) {
                swap(arr, index, i);
                dfs(res, arr, index + 1);
                // back-tracking
                swap(arr, index, i);
            }
        }
    }
    private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
