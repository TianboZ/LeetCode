package debugLaicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * sol1:
 *
 *
 * sol2:
 * use HashSet to deduplicate
 *
 *
 * */

public class AllSubsets2 {
    public List<String> subSets(String set) {
        // Write your solution here.
        char[] arr = set.toCharArray();
        Arrays.sort(arr);
        List<String> res = new ArrayList<>();

        dfs(new StringBuilder(), 0, arr, res);
        return res;
    }

    private void dfs(StringBuilder sb, int index, char[] set, List<String> res) {
        // base case
        if (index == set.length) {
            res.add(sb.toString());
            return;
        }

        // recursive rule
        char ch = set[index];

        // case1, add `ch` to res
        sb.append(ch);
        dfs(sb, index + 1, set, res);
        sb.deleteCharAt(sb.length() - 1);

        // case2, not add `ch`, and skip all consecutive elements
        while (index + 1 < set.length && set[index] == set[index + 1]) {
            index++;
        }
        dfs(sb, index + 1, set, res);
    }
}
