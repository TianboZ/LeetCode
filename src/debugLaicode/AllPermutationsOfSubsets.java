package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (set == null) return res;

        char[] arr = set.toCharArray();
        dfs(res,0, arr);
        return res;
    }

    private void dfs(List<String>  res, int index, char[] arr) {
        // base case
        res.add(new String(arr, 0, index));
        if (index == arr.length) {
            return;
        }

        // recursive rule
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            dfs(res, index + 1, arr);
            swap(arr, index, i); // backtracking
        }
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        AllPermutationsOfSubsets sol = new AllPermutationsOfSubsets();
        res = sol.allPermutationsOfSubsets("abcd");
        System.out.println(res);
    }
}
