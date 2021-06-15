package MianJing.tiktok;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {
    private List<Integer> path = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();

    // time o(2^n)
    // space o(n)
    public void lis(int[] arr) {
        dfs(0, arr);
        System.out.println(res);
    }

    private void dfs(int i, int[] arr) {
        // base case
        if (i == arr.length) {
            if (path.size() > res.size()) {
                res = new ArrayList<>(path); // deep copy
            }
            return;
        }

        // recursive rule
        int prev = path.size() > 0 ? path.get(path.size() - 1) : Integer.MIN_VALUE;

        // case1
        if (arr[i] > prev) {
            path.add(arr[i]);
            dfs(i + 1, arr);
            path.remove(path.size() - 1);
        }
        // case2
        dfs(i + 1, arr);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}; // not unique, e.g. [0, 4, 6, 9, 13, 15]
        sol.lis(arr);
    }
}
