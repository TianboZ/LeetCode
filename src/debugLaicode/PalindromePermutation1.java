package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutation1 {
    public boolean canPermutePalindrome(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        char[] arr = input.toCharArray();
        return dfs(res, arr, 0);
    }
    private boolean dfs(List<String> res, char[] arr, int index) {
        // base-case
        if (index == arr.length) {
            if (isP(arr)) {
                res.add(new String(arr));
                return true;
            }
            return false;
        }
        // rule
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, i, index);
                if (dfs(res, arr, index + 1)) {
                    return true;
                }
                swap(arr, i, index);
            }
        }
        return false;
    }
    private void swap(char[] arr, int s, int e) {
        char tmp = arr[e];
        arr[e] = arr[s];
        arr[s] = tmp;
    }

    private boolean isP(char[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            if (arr[s] != arr[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
