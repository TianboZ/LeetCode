package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        // sanity check
        // TODO
        char[] arr = set.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, 0, arr, k);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int index, char[] arr, int k) {
        // base case
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (index == arr.length) {
            return;
        }

        // recursive rule
        char c = arr[index];

        // case1, add `c`
        sb.append(c);
        dfs(res, sb, index + 1, arr, k);
        sb.deleteCharAt(sb.length() - 1); // backtracking

        // case2, not add `c`
        dfs(res, sb, index + 1, arr, k);
    }

    public static void main(String[] args) {
        AllSubsetOfSizeK sol = new AllSubsetOfSizeK();
        List<String> res = sol.subSetsOfSizeK("abc", 2);
        System.out.println(res);
    }

}
