package debugLaicode;


import java.util.*;

public class ParlindromePermutation {
    public static void main(String[] args) {

        ParlindromePermutation parlindromePermutation = new ParlindromePermutation();
        parlindromePermutation.generatePalindromes("aaabbbb");
    }
    public String[] generatePalindromes(String s) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(res, arr, 0);
        String[] ans = new String[res.size()];
        System.out.println(res);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    private void dfs(List<String> res, char[] arr, int index) {
        // base-case
        if (index == arr.length) {
            if (isP(arr)) {
                res.add(new String(arr));
            }
            return;
        }
        // rule
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, i, index);
                dfs(res, arr, index + 1);
                swap(arr, i, index);
            }
        }
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
