package debugLaicode;

import java.util.*;

public class AllSubsets2OfSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        char[] arr = set.toCharArray();
        Arrays.sort(arr);
        Set<String> res = new HashSet<>();
        dfs(new StringBuilder(), 0, k, arr, res);

        List<String> list = new ArrayList<>(res);
        return list;
    }

    private void dfs(StringBuilder sb, int index, int k, char[] arr, Set<String> res) {
        // base case
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (index == arr.length) return;
        // recursive rule
        char ch  = arr[index];

        // case1, add `ch`
        sb.append(ch);
        dfs(sb, index + 1, k, arr, res);
        sb.deleteCharAt(sb.length() - 1);

        // case2, not add `ch`
        dfs(sb, index + 1, k, arr, res);
    }

    public static void main(String[] args) {
        String str = "accfcb";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
    }
}
